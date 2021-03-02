// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mmbay/Work/GrazeScapeServer/conf/routes
// @DATE:Wed Feb 03 13:56:47 CST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:4
package controllers.javascript {

  // @LINE:4
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def modifyFields: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.modifyFields",
      """
        function(request0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "modify_fields" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
        }
      """
    )
  
    // @LINE:6
    def getFarms: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getFarms",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "get_farms"})
        }
      """
    )
  
    // @LINE:9
    def createOperation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.createOperation",
      """
        function(request0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "create_operation" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
        }
      """
    )
  
    // @LINE:8
    def getFields: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getFields",
      """
        function(farm0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "get_fields" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Long]].javascriptUnbind + """)("farm", farm0)])})
        }
      """
    )
  
    // @LINE:7
    def fetchImage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.fetchImage",
      """
        function(request0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "fetch_image" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
        }
      """
    )
  
    // @LINE:4
    def app: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.app",
      """
        function(request0) {
        
          if (true) {
            return _wA({method:"GET", url:"""" + _prefix + """" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
          }
        
        }
      """
    )
  
    // @LINE:12
    def deleteFields: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.deleteFields",
      """
        function(request0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delete_fields" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
        }
      """
    )
  
    // @LINE:10
    def addField: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addField",
      """
        function(request0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "add_field" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[Request]].javascriptUnbind + """)("request", request0)])})
        }
      """
    )
  
    // @LINE:14
    def getOptions: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.getOptions",
      """
        function(type0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "get_options" + _qS([(""" + implicitly[play.api.mvc.QueryStringBindable[String]].javascriptUnbind + """)("type", type0)])})
        }
      """
    )
  
  }

  // @LINE:18
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:19
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "app/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
    // @LINE:18
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:17
  class ReverseFileService(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:17
    def getFile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FileService.getFile",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "renders/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0))})
        }
      """
    )
  
  }


}
