package controllers;

import models.Listing;
import play.mvc.Controller;
import play.mvc.Result;
import play.twirl.api.Html;
import util.QueryHelper;

public class DetailedPageController extends Controller {

	public Result handleRequest(Integer user_id, Integer listing_id){
		if(listing_id < 0){
			flash("invalid listing_id");
			return redirect("/");
		}
		
		Listing result = QueryHelper.getListing(listing_id);
		
		if(result == null){
			flash("unknown listing_id");
			return redirect("/");
		}
		
		return ok(views.html.main.render(result.getPropertyAddress().getAddressField()+" "+result.getPropertyAddress().getCity(),views.html.displayInDetailListing.render(result, user_id, listing_id)));
	}
}
