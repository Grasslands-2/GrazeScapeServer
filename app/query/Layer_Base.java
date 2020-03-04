package query;

import play.*;
import play.mvc.Http;
import query.Layer_Integer.EType;
import utils.*;
import java.util.*;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;

import analysis.Downsampler;
import analysis.Extract;
import analysis.AreaStats;
import analysis.RasterToPNG;
import analysis.RasterizeFeature;
import analysis.AreaStats.Stats;
import analysis.windowing.Moving_CDL_Window;
import analysis.windowing.Moving_CDL_Window_N;
import analysis.windowing.Moving_CDL_Window_Z;
import analysis.windowing.Moving_Window;
import db.FieldGeometry;
import fileHandling.Asc_Writer;

//------------------------------------------------------------------------------
public abstract class Layer_Base
{
    private static final Logger logger = LoggerFactory.getLogger("app");

	//--------------------------------------------------------------------------
	private static boolean DETAILED_DEBUG_LOGGING = true;
	protected static void detailedLog(String detailedMessage) {
		
		if (DETAILED_DEBUG_LOGGING) {
			logger.debug(detailedMessage);
		}
	}
	
	// STATIC DATA --------------------------
	// NOTE: Width, height, cellSize, and corners were deliberately made static because
	//	no code can currently handle layers of different dimensions or data density.
	private static Map<String, Layer_Base>	mLayers = new HashMap<String,Layer_Base>();
	
	protected static int mWidth, mHeight;
	protected static float mCellSize, mCornerX, mCornerY;
	
	protected final static boolean mbUseBinaryFormat = true;
	protected final static int mBinaryWriteVersion = 1; // NOTE: update version for each new header version change
	
	// CLASS DATA --------------------------
	protected String mName;
	// TODO: move noDataValue into subclasses? Is that even possible?
	protected int mNoDataValue;
	
	// MASK values from ClientUser.ACCESS...
	protected int mAccessRestrictions = 0;
	
	
	//--------------------------------------------------------------------------
	// Functions that must be in the subclass. 
	// TODO: adding a procedural layer type kind of changes the pattern and needs here...
	//	Consider refactoring the base such that there is a Layer_Data type class that
	//	is the base for disk related layers?
	//--------------------------------------------------------------------------
	protected void beforeLoad() {};
	abstract protected void onLoadEnd();
	abstract protected void processASC_Line(int y, String lineElementsArray[]);
	abstract protected void allocMemory();
	// Copies a file read bytebuffer into the internal native float array...
	abstract protected void readCopy(ByteBuffer dataBuffer, int width, int atY);
	// Copies the native float data into a bytebuffer that is set up to receive it (by the caller)
	abstract protected void writeCopy(ByteBuffer dataBuffer, int width, int atY);
	
	//--------------------------------------------------------------------------
	// Base constructor
	//--------------------------------------------------------------------------
	public Layer_Base(String name) {
		
		this(name, false); // not temporary...
	}
	
	// TEMPORARY layers are not added to the managed list...
	//--------------------------------------------------------------------------
	public Layer_Base(String name, boolean temporary) {
	
		mName = name.toLowerCase();
		if (!temporary) {
			if (mLayers.containsKey(name)) {
				logger.warn("Layer_Base: a layer with the name <" + "> is already in the cached set");
			}
			mLayers.put(mName, this);
		}
	}
	
	//--------------------------------------------------------------------------
	public int getWidth() {
		return mWidth;
	}
	public int getHeight() {
		return mHeight;
	}
	
	//--------------------------------------------------------------------------
	public int[][] getIntData() {
		return null;
	}
	
	//--------------------------------------------------------------------------
	public float[][] getFloatData() {
		return null;
	}

	// NOTE: this is only for Query/Selection access restrictions.
	//--------------------------------------------------------------------------
	public void setAccessRestrictions(int restrictionMask) {
		this.mAccessRestrictions = restrictionMask;
	}
	
	// NOTE: this is only for Query/Selection access restrictions.
	//--------------------------------------------------------------------------
	public boolean allowAccessFor(int clientUserAccessMask) {
		if (this.mAccessRestrictions == 0) {
			return true;
		}
		
		return ((this.mAccessRestrictions & clientUserAccessMask) > 0);
	}
	
	//--------------------------------------------------------------------------
	public void init() {
		
		try {
			// TODO: FIXME: binary format reading or writing has an issue, not sure which
			if (mbUseBinaryFormat) {
				File input = new File("./layerData/" + mName + ".dss");
				if(input.exists()) {
					readBinary();
				}
				else {
					// wanting to use binary format but file doesn't exist...
					// 	try to load ASC and save as Binary for future loads
					loadASC();
					writeBinary();
				}
			}
			else {
				loadASC();
			}
		}
		catch(Exception e) {
			logger.error(e.toString());
		}
	}
	
	//--------------------------------------------------------------------------
	private String getASC_HeaderValue(String line) {
		
		String split[] = line.split("\\s+");
		if (split.length == 2) {
			return split[1];
		}
		
		return null;
	}
	
	//--------------------------------------------------------------------------
	private void readASC_Header(BufferedReader reader) throws Exception {
		
		try {
			String width = reader.readLine(); // ncols
			String height = reader.readLine(); // nrows
			String xllCorner = reader.readLine(); // xll corner
			String yllCorner = reader.readLine(); // yll corner
			String cellSize = reader.readLine(); // cellsize
			String noData = reader.readLine(); // nodata value
			
			// Echo string values in ASC header
			logger.info("  " + width);
			logger.info("  " + height);
			logger.info("  " + xllCorner);
			logger.info("  " + yllCorner);
			logger.info("  " + cellSize);
			logger.info("  " + noData);
			
			// convert to required data types and save
			mWidth = Integer.parseInt(getASC_HeaderValue(width));
			mHeight = Integer.parseInt(getASC_HeaderValue(height));
			mCornerX = Float.parseFloat(getASC_HeaderValue(xllCorner));
			mCornerY = Float.parseFloat(getASC_HeaderValue(yllCorner));
			mCellSize = Float.parseFloat(getASC_HeaderValue(cellSize));
			mNoDataValue = Integer.parseInt(getASC_HeaderValue(noData));
		}
		catch (Exception e) {
			logger.info(e.toString());
		}
	}
	
	//--------------------------------------------------------------------------
	private void loadASC() throws Exception {
		
		logger.info("+-------------------------------------------------------+");
		logger.info("| " + mName);
		logger.info("+-------------------------------------------------------+");
		
		beforeLoad();
		try(BufferedReader br = new BufferedReader(new FileReader("./layerData/" + mName + ".asc"))) {
			
			readASC_Header(br);
			allocMemory();
			
			logger.debug("  Attempting to read the array data");
			
			int y = 0;
			
			// now read the array data
			while (br.ready()) {
				if (y >= mHeight) {
					logger.error("BAD READ - more lines than expected!");
					break;
				}
				String line = br.readLine().trim();
				String split[] = line.split("\\s+");
				processASC_Line(y, split);
				y++;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		//	logger.info(e.toString());
		}
		
		onLoadEnd();
		logger.info(" ");
	}
	
	// ordering expects subclasses to call the super (this) first...
	//--------------------------------------------------------------------------
	protected JsonNode getParameterInternal(JsonNode clientRequest) throws Exception {
		
		// Set this as a default
		JsonNode ret = null;
		
		// Do any processing here if the base layer class needs to...
		//	e.g., if we ever need to pass back layer dimensions, cell size, etc...
		
		return ret;
	}


	//--------------------------------------------------------------------------
	// BINARY format reading/writing
	//	~3-6x faster 
	//--------------------------------------------------------------------------
	private void writeBinary() throws Exception {
		
		logger.info("Writing Binary");
		File output = new File("./layerData/" + mName + ".dss");

		try (FileOutputStream fos = new FileOutputStream(output); WritableByteChannel channel = fos.getChannel()) {
			
			ByteBuffer buf = ByteBuffer.allocateDirect(4); // FIXME: size of int
			
			// write version type			
			buf.putInt(mBinaryWriteVersion);
			buf.flip();
			channel.write(buf);
			
			buf = ByteBuffer.allocateDirect(6 * 4); // FIXME: header field ct * size of int
			
			buf.putInt(mWidth);
			buf.putInt(mHeight);
			buf.putFloat(mCornerX);
			buf.putFloat(mCornerY);
			buf.putFloat(mCellSize);
			buf.putInt(mNoDataValue);
			buf.flip();
			channel.write(buf);
			
			buf = ByteBuffer.allocateDirect(mWidth * 4); // FIXME: size of int?
			
			for (int y = 0; y < mHeight; y++) {
				// shuttle native internal data, line by line, into buf for writing
				buf.clear();
				writeCopy(buf, mWidth, y);
				buf.flip();
				channel.write(buf);
			}
		}
		catch (Exception e) {
			logger.info(e.toString());
		}
	}
	
	//--------------------------------------------------------------------------
	private void readBinary() throws Exception {
		
		logger.info("┌───────────────────────────────────────────────────────┼");
		logger.info("» Binary Read: " + mName);
		logger.info("└───────────────────────────────────────────────────────┼");
		File input = new File("./layerData/" + mName + ".dss");

		logger.info("  Real Path: " + input.getCanonicalPath());

		beforeLoad();
		
		try (FileInputStream fis = new FileInputStream(input); ReadableByteChannel channel = fis.getChannel()) {
			
			logger.info("  Reading header...");
			ByteBuffer buf = ByteBuffer.allocateDirect(4); // FIXME: size of int (version)?
			channel.read(buf); 
			buf.rewind();
			logger.info("  - Binary file version: " + Integer.toString(buf.getInt()));
				
			buf = ByteBuffer.allocateDirect(6 * 4); // FIXME: size of header * size of int?
			channel.read(buf); 
			buf.rewind();
			
			mWidth = buf.getInt();
			mHeight = buf.getInt();
			mCornerX = buf.getFloat();
			mCornerY = buf.getFloat();
			mCellSize = buf.getFloat();
			mNoDataValue = buf.getInt();
			
			logger.info("  - Width: " + Integer.toString(mWidth) 
							+ "  Height: " + Integer.toString(mHeight));
			allocMemory();
			
			buf = ByteBuffer.allocateDirect(mWidth * 4); // FIXME: size of int?
			
			for (int y = 0; y < mHeight; y++) {
				// shuttle read data from buf, line by line, into native internal arrays.
				buf.clear();
				channel.read(buf);
				buf.rewind();
				readCopy(buf, mWidth, y);
			}
		}
		catch (Exception e) {
			logger.info(e.toString());
		}
		
		onLoadEnd();
		logger.info("");
	}

	//--------------------------------------------------------------------------
	//	
	// 	   ____  _        _   _          
	//	  / ___|| |_ __ _| |_(_) ___ ___ 
	//	  \___ \| __/ _` | __| |/ __/ __|
	//	   ___) | || (_| | |_| | (__\__ \
	//	  |____/ \__\__,_|\__|_|\___|___/
	//	                                 
	//	
	//--------------------------------------------------------------------------
	
	// Return the Layer_Base object when asked for it by name
	//--------------------------------------------------------------------------
	public static Layer_Base getLayer(String name) {
		
		String name_low = name.toLowerCase();
		if (!mLayers.containsKey(name_low)) {
			logger.error("getLayer called looking for: <" + name_low + "> but layer doesn't exist");
			return null;
		}
		return mLayers.get(name_low);
	}

	// Use carefully...e.g., only if you are temporarily loading data for a process that rarely runs...
	//--------------------------------------------------------------------------
	public static void removeLayer(String name) {

		logger.warn("A call was made to remove layer: " + name + " from memory");
		name = name.toLowerCase();
		mLayers.remove(name);
	}
	
	// Use even more carefully...currently only be used when the server shuts down.
	//--------------------------------------------------------------------------
	public static void removeAllLayers() {

		logger.info(" ... A call was made to clear all Layers!");
		mLayers.clear();
	}
	
	// returns an array of restricted layer names...
	//--------------------------------------------------------------------------
	public static ArrayNode getAccessRestrictedLayers() {
	
		ArrayNode list = JsonNodeFactory.instance.arrayNode();
		for (Layer_Base layer : mLayers.values()) {
			if (layer.mAccessRestrictions > 0) {
				list.add(layer.mName);
			}
		}
		
		return list;
	}
	
	// returns an array of access restricted layer names the given user can actually access...
	//--------------------------------------------------------------------------
	public static ArrayNode getAccessibleRestrictedLayers(int accessFlags) {
	
		ArrayNode list = JsonNodeFactory.instance.arrayNode();
		for (Layer_Base layer : mLayers.values()) {
			if (layer.mAccessRestrictions > 0 && (layer.mAccessRestrictions & accessFlags) > 0) {
				list.add(layer.mName);
			}
		}
		
		return list;
	}	
	
	//--------------------------------------------------------------------------
	public static Layer_Float newFloatLayer(String name) {
		Layer_Float layer = new Layer_Float(name);
		return layer;
	}
	
	//--------------------------------------------------------------------------
	public static Layer_Integer newIntegerLayer(String name, EType layerType) {
		Layer_Integer layer = new Layer_Integer(name, layerType);
		return layer;
	}
	
	//--------------------------------------------------------------------------
	public static Layer_Integer newIntegerLayer(String name) {
		Layer_Integer layer = new Layer_Integer(name, EType.ELoadShiftedIndex);
		return layer;
	}

	//--------------------------------------------------------------------------
	public static void computeLayers() {

		logger.info("Computing layers if needed");
	}
	
	//--------------------------------------------------------------------------
	public static void cacheLayers() {
		
		PerformanceTimer timer = new PerformanceTimer();
		try {
			logger.info("Caching all data layers");
			
			newIntegerLayer("wisc_land_2").init();	// Wisc Land 2.0 - 2016
			
			newIntegerLayer("road_mask").init();	
			newIntegerLayer("water_mask").init();	
			
			newFloatLayer("dem").init();				// Derived from the US Geological Survey's 10-meter National Elevation Dataset (NED)
			newFloatLayer("slope").init();				// Derived from the US Geological Survey's 10-meter National Elevation Dataset (NED)
			newFloatLayer("distance_to_water").init();	// 24k Hydro Waterbodies, WI DNR: Merged Open Water + Streams [including ephemeral streams]
			
//			newIntegerLayer("non_ag_mask",EType.ERaw).init();	// Hybrid of Wisc-Land, DNR perennial streams, DNR open water, and DMV road data
			
			// SSURGO-Derived layers: topmost horizon only
//			newFloatLayer("k_fact").init();			// SSURGO: kffact
//			newFloatLayer("soil_depth").init();		// SSURGO: hzdept_r
//			newFloatLayer("clay_perc").init();		// SSURGO: claytotal_r
			newFloatLayer("sand_perc").init();		// SSURGO: sandtotal_r
			newFloatLayer("silt_perc").init();		// SSURGO: silttotal_r			
			newFloatLayer("cec").init();			// SSURGO: cec7_r
//			newFloatLayer("om_perc").init();		// SSURGO: om_r
		}
		catch (Exception e) {
			logger.error(e.toString());
		}
		
		logger.info("┌───────────────────────────────────────────────────────┼");
		logger.info("» Layers are loaded:");
		
		logger.info(String.format("│   Time to cache all layers: %.3f (s): ", timer.elapsedSeconds()));
		
		// TODO: probably have a getSize function on each layer type. Though all are 4bytes per raster at this point
		Double mem = mLayers.size() * 3900 * 1400 * 4.0 / (1024.0 * 1024.0);
		logger.info(String.format("│   Approximate layer cache size: %.1f (MB)", mem));
		logger.info("└───────────────────────────────────────────────────────┼\n");
		
	}
	
	// Generally comes from a client request for data about this layer...
	//	this could be layer width/height, maybe cell size (30m), maybe the layer
	//	ranges, in the case of indexed layers...the key/legend for the layer
	//--------------------------------------------------------------------------
	public static JsonNode getParameter(JsonNode clientRequest) throws Exception {
		
		JsonNode ret = null;
		String layername = clientRequest.get("name").textValue();
		
		// Check for custom layer handlers
		Layer_Base layer = Layer_Base.getLayer(layername);
		if (layer != null) {
			ret = layer.getParameterInternal(clientRequest);
		}

		return ret;
	}
	
}
