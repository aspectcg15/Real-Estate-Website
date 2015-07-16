package controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import play.Logger;
import play.db.DB;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;
import play.twirl.api.Html;
import scala.collection.immutable.Seq;
import util.QueryHelper;
import models.Listing;
import models.users;
import models.varchar45;

public class MainPageController extends Controller {

	private static final String PRINT_LISTINGS_SQL = "SELECT * FROM ";
	private static final String PRINT_USERS_SQL = "SELECT fname, lname FROM users";
	
	@Deprecated
	public static void main(String[] args){
		Listing	listing = new Listing();
		//listing.getPicture();
		listing.getDescription();
		
		//DB.
	}
	
	/*public Result printListings(){
		try(Connection conn = DB.getConnection();){
			preparedStatement = conn.prepareStatement(PRINT_LISTINGS_SQL);
		}
		
	}*/
	
	public Result handleRequest(){
		if(flash().containsKey("flash key"))
			Logger.info(flash().get("flash key"));
		List<Listing> temp = QueryHelper.getListingFromRange(0,25);
		//TODO
		List<Listing> tempReco = new ArrayList<Listing>();
		try{tempReco.add(temp.get(3));}catch(Exception e){Logger.error(e.getMessage());}
		try{tempReco.add(temp.get(7));}catch(Exception e){Logger.error(e.getMessage());}
		try{tempReco.add(temp.get(10));}catch(Exception e){Logger.error(e.getMessage());}
		try{tempReco.add(temp.get(19));}catch(Exception e){Logger.error(e.getMessage());}
		try{tempReco.add(temp.get(2));}catch(Exception e){Logger.error(e.getMessage());}
		//Test
		return Results.ok(printDemoPage1(temp, tempReco));
	}

	@Deprecated
	public Result printUsers(){
		long start = System.nanoTime();
		long totalTime = 0L;

		//String resultHtml = printUsersQuery();
		Html resultHtml = printSiteHeader();
		
		List<Html> appender = new ArrayList<Html>();
		appender.add(new Html(totalTime/1000000.0+"ms\n"));
		appender.add(resultHtml);
		
		Html aggregated =  new Html(scala.collection.JavaConversions.asScalaBuffer(appender).toList());
		
		totalTime = System.nanoTime()-start;
		return Results.ok(views.html.main.render("this is the title",aggregated));
	}

	public static String printUsersQuery() {
		String resultHtml = "";
		try(Connection conn = DB.getConnection();){
			PreparedStatement preparedStatement = conn.prepareStatement(PRINT_USERS_SQL);
			ResultSet results = preparedStatement.executeQuery();
			
			while(results.next()){
				try{
					users user = new users();
					user.setFname(results.getString("fname"));
					user.setLname(results.getString("lname"));
					String temp = views.html.formatUser.render(user).body();
					Logger.info(temp);
					System.out.println(temp);
					resultHtml += temp +"\n";
				}catch(varchar45.varchar45CastException e){
					e.printStackTrace();
					resultHtml += "varchar45InputException\n";
				}catch(Exception e){
					e.printStackTrace();
					resultHtml += "Error\n";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultHtml;
	}
	
	public static Html printSiteHeader() {
		//views.html.play20.welcome.render(null,null).toString()
		return views.html.siteHeader.render();
	}
	
	public static Html printDemoPage1(List<Listing> allListings, List<Listing> recommendedListings){
		return views.html.demoPage1.render("Real Estate Website", allListings, recommendedListings);
	}
	
	public static Html printDemoPage2(Listing listing){
		return views.html.main.render("Real Estate Website", views.html.demoPage2.render(listing));
	}
}
