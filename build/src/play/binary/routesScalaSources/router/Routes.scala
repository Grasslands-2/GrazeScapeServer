// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mmbay/Work/GrazeScapeServer/conf/routes
// @DATE:Wed Feb 03 13:56:47 CST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:4
  HomeController_0: controllers.HomeController,
  // @LINE:17
  FileService_1: controllers.FileService,
  // @LINE:18
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:4
    HomeController_0: controllers.HomeController,
    // @LINE:17
    FileService_1: controllers.FileService,
    // @LINE:18
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, FileService_1, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, FileService_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.app(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """app""", """controllers.HomeController.app(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """get_farms""", """controllers.HomeController.getFarms()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """fetch_image""", """controllers.HomeController.fetchImage(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """get_fields""", """controllers.HomeController.getFields(farm:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create_operation""", """controllers.HomeController.createOperation(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """add_field""", """controllers.HomeController.addField(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """modify_fields""", """controllers.HomeController.modifyFields(request:Request)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """delete_fields""", """controllers.HomeController.deleteFields(request:Request)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """get_options""", """controllers.HomeController.getOptions(type:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """renders/""" + "$" + """file<[^/]+>""", """controllers.FileService.getFile(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """app/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public/js", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:4
  private[this] lazy val controllers_HomeController_app0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_app0_invoker = createInvoker(
    HomeController_0.app(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "app",
      Seq(classOf[Request]),
      "GET",
      this.prefix + """""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_HomeController_app1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("app")))
  )
  private[this] lazy val controllers_HomeController_app1_invoker = createInvoker(
    HomeController_0.app(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "app",
      Seq(classOf[Request]),
      "GET",
      this.prefix + """app""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HomeController_getFarms2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("get_farms")))
  )
  private[this] lazy val controllers_HomeController_getFarms2_invoker = createInvoker(
    HomeController_0.getFarms(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getFarms",
      Nil,
      "GET",
      this.prefix + """get_farms""",
      """""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_fetchImage3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("fetch_image")))
  )
  private[this] lazy val controllers_HomeController_fetchImage3_invoker = createInvoker(
    HomeController_0.fetchImage(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "fetchImage",
      Seq(classOf[Request]),
      "POST",
      this.prefix + """fetch_image""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_HomeController_getFields4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("get_fields")))
  )
  private[this] lazy val controllers_HomeController_getFields4_invoker = createInvoker(
    HomeController_0.getFields(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getFields",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """get_fields""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HomeController_createOperation5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create_operation")))
  )
  private[this] lazy val controllers_HomeController_createOperation5_invoker = createInvoker(
    HomeController_0.createOperation(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "createOperation",
      Seq(classOf[Request]),
      "POST",
      this.prefix + """create_operation""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_HomeController_addField6_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("add_field")))
  )
  private[this] lazy val controllers_HomeController_addField6_invoker = createInvoker(
    HomeController_0.addField(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addField",
      Seq(classOf[Request]),
      "POST",
      this.prefix + """add_field""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_HomeController_modifyFields7_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("modify_fields")))
  )
  private[this] lazy val controllers_HomeController_modifyFields7_invoker = createInvoker(
    HomeController_0.modifyFields(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "modifyFields",
      Seq(classOf[Request]),
      "POST",
      this.prefix + """modify_fields""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_HomeController_deleteFields8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("delete_fields")))
  )
  private[this] lazy val controllers_HomeController_deleteFields8_invoker = createInvoker(
    HomeController_0.deleteFields(fakeValue[Request]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "deleteFields",
      Seq(classOf[Request]),
      "POST",
      this.prefix + """delete_fields""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_HomeController_getOptions9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("get_options")))
  )
  private[this] lazy val controllers_HomeController_getOptions9_invoker = createInvoker(
    HomeController_0.getOptions(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "getOptions",
      Seq(classOf[String]),
      "GET",
      this.prefix + """get_options""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_FileService_getFile10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("renders/"), DynamicPart("file", """[^/]+""",true)))
  )
  private[this] lazy val controllers_FileService_getFile10_invoker = createInvoker(
    FileService_1.getFile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FileService",
      "getFile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """renders/""" + "$" + """file<[^/]+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned11_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_Assets_at12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("app/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at12_invoker = createInvoker(
    Assets_2.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """app/""" + "$" + """file<.+>""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:4
    case controllers_HomeController_app0_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_app0_invoker.call(HomeController_0.app(request))
      }
  
    // @LINE:5
    case controllers_HomeController_app1_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_app1_invoker.call(HomeController_0.app(request))
      }
  
    // @LINE:6
    case controllers_HomeController_getFarms2_route(params@_) =>
      call { 
        controllers_HomeController_getFarms2_invoker.call(HomeController_0.getFarms())
      }
  
    // @LINE:7
    case controllers_HomeController_fetchImage3_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_fetchImage3_invoker.call(HomeController_0.fetchImage(request))
      }
  
    // @LINE:8
    case controllers_HomeController_getFields4_route(params@_) =>
      call(params.fromQuery[Long]("farm", None)) { (farm) =>
        controllers_HomeController_getFields4_invoker.call(HomeController_0.getFields(farm))
      }
  
    // @LINE:9
    case controllers_HomeController_createOperation5_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_createOperation5_invoker.call(HomeController_0.createOperation(request))
      }
  
    // @LINE:10
    case controllers_HomeController_addField6_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_addField6_invoker.call(HomeController_0.addField(request))
      }
  
    // @LINE:11
    case controllers_HomeController_modifyFields7_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_modifyFields7_invoker.call(HomeController_0.modifyFields(request))
      }
  
    // @LINE:12
    case controllers_HomeController_deleteFields8_route(params@_) =>
      call(params.fromQuery[Request]("request", None)) { (request) =>
        controllers_HomeController_deleteFields8_invoker.call(HomeController_0.deleteFields(request))
      }
  
    // @LINE:14
    case controllers_HomeController_getOptions9_route(params@_) =>
      call(params.fromQuery[String]("type", None)) { (_pf_escape_type) =>
        controllers_HomeController_getOptions9_invoker.call(HomeController_0.getOptions(_pf_escape_type))
      }
  
    // @LINE:17
    case controllers_FileService_getFile10_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_FileService_getFile10_invoker.call(FileService_1.getFile(file))
      }
  
    // @LINE:18
    case controllers_Assets_versioned11_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned11_invoker.call(Assets_2.versioned(path, file))
      }
  
    // @LINE:19
    case controllers_Assets_at12_route(params@_) =>
      call(Param[String]("path", Right("/public/js")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at12_invoker.call(Assets_2.at(path, file))
      }
  }
}
