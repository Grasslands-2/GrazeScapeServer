
package views.html

import models._
import controllers._
import play.api.i18n._
import play.api.templates.PlayMagic._
import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.libs.F
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._
import views.html._

object app extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="apple-mobile-web-app-capable" content="yes">
	<meta name="mobile-web-app-capable" content="yes">

        <title>GrazeScape v0.1</title>
        <link rel="stylesheet" type="text/css" href="/assets/vendor/ol/ol.css">
        <link rel="stylesheet" media="screen" href="/assets/vendor/extjs/ext-theme-crisp-all.css">
        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*13.59*/routes/*13.65*/.Assets.versioned("images/favicon.png")),format.raw/*13.104*/("""">
        <script src="/assets/vendor/ol/ol.js"></script>
		<script src="https://cdn.maptiler.com/ol-mapbox-style/v5.0.2/olms.js"></script>
        <script src="/assets/vendor/extjs/ext-all.js"></script>
		<link rel="stylesheet" href="/assets/vendor/extjs/charts-all.css">
        <link rel="stylesheet" media="screen" href=""""),_display_(/*18.54*/routes/*18.60*/.Assets.versioned("css/app_main.css")),format.raw/*18.97*/("""">
		<link rel="stylesheet" media="screen" href=""""),_display_(/*19.48*/routes/*19.54*/.Assets.versioned("css/d3-nav.css")),format.raw/*19.89*/("""">
		<link href="/assets/vendor/font-awesome/css/all.css" rel="stylesheet">
		<!--  <script src="/assets/vendor/font-awesome/js/all.min.js"></script> -->
		
    </head>
    <body>
        <script src="assets/js/ExtUtils.js" type="text/javascript"></script>
        <script src="assets/js/app_main.js" type="text/javascript"></script>
		<script src="assets/vendor/d3/d3.min.js"></script>
		<script src="assets/vendor/d3/sankey.js"></script>
		<script type="text/javascript" src="/assets/vendor/extjs/charts.js"></script>
		<!--  <script src="https://kit.fontawesome.com/64ce03480e.js" crossorigin="anonymous"></script>  -->
		
		<script src="https://cdnjs.cloudflare.com/ajax/libs/proj4js/2.6.0/proj4.js" crossorigin="anonymous"></script>
    </body>
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Wed Feb 03 13:56:49 CST 2021
                  SOURCE: C:/Users/mmbay/Work/GrazeScapeServer/app/views/app.scala.html
                  HASH: aa807aacfd545ad02899567f6250f696e17abf3a
                  MATRIX: 1047->0|1654->580|1669->586|1730->625|2089->957|2104->963|2162->1000|2240->1051|2255->1057|2311->1092
                  LINES: 34->1|46->13|46->13|46->13|51->18|51->18|51->18|52->19|52->19|52->19
                  -- GENERATED --
              */
          