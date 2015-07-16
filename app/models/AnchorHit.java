package models;

import java.io.Serializable;

public class AnchorHit implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String href;
	private String referrer;
	private Integer user_id;
	private Long time;
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getReferrer() {
		return referrer;
	}
	public void setReferrer(String referrer) {
		this.referrer = referrer;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Long getTime() {
		return time;
	}
	public void setTime(Long time) {
		this.time = time;
	}
	
	public String toString(){
		return href+" "+referrer+" "+user_id+" "+time;
	}
	
	public AnchorHit fromString(String str) throws Exception{
		String[] tokens = str.split(" ");
		
		if(tokens.length != 4)
			throw new Exception("Unexpected number of tokens");
		
		AnchorHit result = new AnchorHit();
		
		try{result.setHref(tokens[0]);}catch(Exception e){e.printStackTrace();}
		try{result.setReferrer(tokens[1]);}catch(Exception e){e.printStackTrace();}
		try{result.setUser_id(Integer.parseInt(tokens[2]));}catch(Exception e){e.printStackTrace();}
		try{result.setTime(Long.parseLong(tokens[3]));}catch(Exception e){e.printStackTrace();}
		
		return result;
	}
}
