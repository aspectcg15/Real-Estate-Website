package interfaces;

import models.address;
import models.varchar45.varchar45CastException;

public interface IUsers {
	public int getUser_id();
	public void setUser_id(int user_id);
	public String getFname();
	public void setFname(String fname) throws varchar45CastException;
	public String getLname();
	public void setLname(String lname) throws varchar45CastException;
	public String getDob();
	public void setDob(String dob) throws varchar45CastException;
	public String getGender();
	public void setGender(String gender) throws varchar45CastException;
	public String getContact();
	public void setContact(String contact) throws varchar45CastException;
	public String getEmail();
	public void setEmail(String email) throws varchar45CastException;
	public int getAddress_zip_id();
	public void setAddress_zip_id(int address_zip_id);
	public address getUsersAddress();
	public void setUsersAddress(address address);
}
