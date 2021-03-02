// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mmbay/Work/GrazeScapeServer/conf/routes
// @DATE:Wed Feb 03 13:56:47 CST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
