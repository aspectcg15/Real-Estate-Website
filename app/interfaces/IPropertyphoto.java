package interfaces;

import models.varchar45.varchar45CastException;

public interface IPropertyphoto {
	public int getPhoto_id();
	public void setPhoto_id(int photo_id);
	public String getPhoto_name();
	public void setPhoto_name(String photo_name) throws varchar45CastException;
	public String getPhoto_path();
	public void setPhoto_path(String photo_path) throws varchar45CastException;
}
