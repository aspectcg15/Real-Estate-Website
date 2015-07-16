package models;

import models.varchar45.varchar45CastException;
import interfaces.IPropertyphoto;

/**
 * the class/field names break java naming/capitalization convention to keep consistent with the names as defined in the database
 * 
 * @author skinsella shane.kinsella@aspect.com
 */
public class propertyphoto implements IPropertyphoto {
	protected int photo_id;
	protected varchar45 photo_name;
	protected varchar45 photo_path;
	
	public int getPhoto_id() {
		return photo_id;
	}
	public void setPhoto_id(int photo_id) {
		this.photo_id = photo_id;
	}
	public String getPhoto_name() {
		if(photo_name==null)
			return null;
		return photo_name.contents;
	}
	public void setPhoto_name(String photo_name) throws varchar45CastException {
		this.photo_name = new varchar45(photo_name);
	}
	public String getPhoto_path() {
		if(photo_path==null)
			return null;
		return photo_path.contents;
	}
	public void setPhoto_path(String photo_path) throws varchar45CastException {
		this.photo_path = new varchar45(photo_path);;
	}
}
