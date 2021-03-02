// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mmbay/Work/GrazeScapeServer/conf/routes
// @DATE:Wed Feb 03 13:56:47 CST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:4
package controllers {

  // @LINE:4
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def modifyFields(request:Request): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "modify_fields" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
    // @LINE:6
    def getFarms(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get_farms")
    }
  
    // @LINE:9
    def createOperation(request:Request): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "create_operation" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
    // @LINE:8
    def getFields(farm:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get_fields" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Long]].unbind("farm", farm)))))
    }
  
    // @LINE:7
    def fetchImage(request:Request): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "fetch_image" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
    // @LINE:4
    def app(request:Request): Call = {
    
      (request: @unchecked) match {
      
        // @LINE:4
        case (request)  =>
          
          Call("GET", _prefix + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
      
      }
    
    }
  
    // @LINE:12
    def deleteFields(request:Request): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "delete_fields" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
    // @LINE:10
    def addField(request:Request): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "add_field" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[Request]].unbind("request", request)))))
    }
  
    // @LINE:14
    def getOptions(_pf_escape_type:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "get_options" + play.core.routing.queryString(List(Some(implicitly[play.api.mvc.QueryStringBindable[String]].unbind("type", _pf_escape_type)))))
    }
  
  }

  // @LINE:18
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public/js"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "app/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:18
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:17
  class ReverseFileService(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def getFile(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "renders/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("file", file)))
    }
  
  }


}
