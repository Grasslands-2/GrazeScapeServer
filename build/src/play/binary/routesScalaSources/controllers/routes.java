// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mmbay/Work/GrazeScapeServer/conf/routes
// @DATE:Wed Feb 03 13:56:47 CST 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseFileService FileService = new controllers.ReverseFileService(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseFileService FileService = new controllers.javascript.ReverseFileService(RoutesPrefix.byNamePrefix());
  }

}
