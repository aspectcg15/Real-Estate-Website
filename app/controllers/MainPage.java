package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Listing;
import play.mvc.Result;
import play.mvc.Results;

public class MainPage {

	public Result index() {
//		List<ListingShort> 	
		List<Listing>	listings = new ArrayList<Listing>();
		return Results.ok(views.html.mainPage.render());
	}
}
