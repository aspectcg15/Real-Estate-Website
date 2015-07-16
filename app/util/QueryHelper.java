package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import play.Logger;
import play.db.DB;
import models.Listing;
import models.address;
import models.longtext.longtextCastException;
import models.property;
import models.propertylisting;
import models.propertyphoto;
import models.users;
import models.varchar45.varchar45CastException;

public class QueryHelper {

	public static List<Listing> getListingFromRange(int i, int j) {
		FullListingQuery query = new FullListingQuery("listing_id BETWEEN "+i+" AND "+j);
		
		List<Listing> result = runQuery(query.toString(), (a) -> { return parseListing(a);});
		
		return result;
	}
	
	public static Listing getListing(int i){
		FullListingQuery query = new FullListingQuery("listing_id="+i);
		
		List<Listing> result = runQuery(query.toString(), (a) -> { return parseListing(a);});
		
		if(result.size() != 1){
			return null;
		}else{
			return result.get(0);
		}
	}
	
	/**
	 * Note: resultSet needs to be still open for this method to work
	 * I suggest using as a lambda: (a) -> {return parseListing(a);}
	 * @param resultSet
	 * @return
	 */
	private static List<Listing> parseListing(ResultSet resultSet) {
		if(resultSet == null){
			return null;
		}
		
		List<Listing>	result = new ArrayList<Listing>();
		
		try {
			while(resultSet.next()){
				
				Listing tempListing = new Listing();
				
				property tempProperty = new property();
				propertyphoto tempPropertyphoto = new propertyphoto();
				users tempUsers = new users();

				address tempPropertyAddress = new address();
				address tempUsersAddress = new address();

				tempProperty.setPropertyAddress(tempPropertyAddress);
				tempUsers.setUsersAddress(tempUsersAddress);
				
				tempListing.setProperty(tempProperty);
				tempListing.setPropertyphoto(tempPropertyphoto);
				tempListing.setUsers(tempUsers);
				
				//address
				try{
					tempPropertyAddress.setZip_id(resultSet.getInt("zip_id"));
				}catch(SQLException e){
					e.printStackTrace();
				}
				try{
					tempPropertyAddress.setZip_code(resultSet.getString("zip_code"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempPropertyAddress.setCity(resultSet.getString("city"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempPropertyAddress.setState(resultSet.getString("state"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempPropertyAddress.setCountry(resultSet.getString("country"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempPropertyAddress.setAddressField(resultSet.getString("address"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				//end address
				//property
				try{
					tempProperty.setProp_id(resultSet.getInt("prop_id"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setPrice(resultSet.getDouble("price"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setSize(resultSet.getString("size"));
				}catch(SQLException | varchar45CastException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setBed(resultSet.getInt("bed"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setBath(resultSet.getInt("bath"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setDescription(resultSet.getString("description"));
				}catch(SQLException | longtextCastException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setType(resultSet.getString("type"));
				}catch(SQLException | varchar45CastException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setAddress_zip_id_1(resultSet.getInt("address_zip_id1"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				//end property
				//propertylisting
				try{
					tempListing.setListing_id(resultSet.getInt("listing_id"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempPropertyphoto.setPhoto_id(resultSet.getInt("propertyphoto_photo_id"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempProperty.setProp_id(resultSet.getInt("property_prop_id"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				try{
					tempUsers.setUser_id(resultSet.getInt("users_user_id"));
				}catch(SQLException e){
					Logger.info(e.getMessage());
				}
				//end propertylisting
				//propertyphoto
				try{
					tempPropertyphoto.setPhoto_id(resultSet.getInt("photo_id"));
				}catch(SQLException e){
					e.printStackTrace();
				}
				try{
					tempPropertyphoto.setPhoto_name(resultSet.getString("photo_name"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempPropertyphoto.setPhoto_path(resultSet.getString("photo_path"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				//end propertyphoto
				//users
				try{
					tempUsers.setUser_id(resultSet.getInt("user_id"));
				}catch(SQLException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setFname(resultSet.getString("fname"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setLname(resultSet.getString("lname"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setDob(resultSet.getString("dob"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setGender(resultSet.getString("gender"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setContact(resultSet.getString("contact"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setEmail(resultSet.getString("email"));
				}catch(SQLException | varchar45CastException e){
					e.printStackTrace();
				}
				try{
					tempUsers.setAddress_zip_id(resultSet.getInt("address_zip_id"));
				}catch(SQLException e){
					e.printStackTrace();
				}
				//end users
				
				result.add(tempListing);
			}
		} catch (SQLException e) {
			Logger.info(e.getMessage());
		}
		
		return result;
	}

	private static <T> T runQuery(FullListingQuery query, Function<ResultSet, T> parser) {
		return runQuery(query.toString(), parser);
	}
	
	private static <T> T runQuery(String query, Function<ResultSet, T> parser) {
		T result = null;
		try(Connection conn = DB.getConnection();){
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			ResultSet resultSet = preparedStatement.executeQuery();
			result = parser.apply(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	private static class FullListingQuery {
		//TODO
		private String query = "SELECT a.*, b.*, c.*, d.*, e.*, f.* FROM propertylisting a, property b, propertyphoto c, address d, users e, address f WHERE a.property_prop_id=b.prop_id AND a.propertyphoto_photo_id=c.photo_id AND b.address_zip_id1=d.zip_id AND a.users_user_id=e.user_id AND e.address_zip_id=f.zip_id";
		
		private FullListingQuery(){
			query += ";";
		}
		
		private FullListingQuery(String where){
			query += " AND "+ where+ ";";
		}
		
		public String toString(){
			return query;
		}
	}
}
