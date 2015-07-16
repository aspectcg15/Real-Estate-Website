package models;

public class Rating {
	protected Integer user_id;
	protected Integer product_id;
	protected Double rating;

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}
	
	public Integer getUser_id() {
		return user_id;
	}
	public Integer getProduct_id() {
		return  product_id;
	}
	public Double getRating() {
		return rating;
	}
	
	public String toString(){
		return user_id + " " + product_id + " "+ rating;
	}
	
	public Rating fromString(String str) throws Exception{
		String[] tokens = str.split(" ");
		
		if(tokens.length != 3)
			throw new Exception("Unexpected number of tokens");

		Rating result = new Rating();
		
		try{result.setUser_id(Integer.parseInt(tokens[0]));}catch(Exception e){e.printStackTrace();}
		try{result.setProduct_id(Integer.parseInt(tokens[1]));}catch(Exception e){e.printStackTrace();}
		try{result.setRating(Double.parseDouble(tokens[2]));}catch(Exception e){e.printStackTrace();}
		
		return result;
	}
}
