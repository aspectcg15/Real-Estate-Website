package controllers;

import play.mvc.Controller;
import play.mvc.Result;

public class TestLocationObject extends Controller{
	public Result handleRequest(){
		return ok(views.html.viewTestLocationObject.render("/assets/javascript/TestLocationObject.js", "redirect()"));
		//return ok(views.html.viewTestLocationObject("", ""));
		//return ok();
	}
}
