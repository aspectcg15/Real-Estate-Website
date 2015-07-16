package interfaces;

import models.varchar45.varchar45CastException;

public interface IAddress {
	public int getZip_id();
	public void setZip_id(int zip_id);
	public String getZip_code();
	public void setZip_code(String zip_code) throws varchar45CastException;
	public String getCity();
	public void setCity(String city) throws varchar45CastException;
	public String getState();
	public void setState(String state) throws varchar45CastException;
	public String getCountry();
	public void setCountry(String country) throws varchar45CastException;
	/**
	 * This method is called getAddressField to differentiate it from the method that returns the address object that represents an address table entry
	 */
	public String getAddressField();
	/**
	 * This method is called setAddressField to differentiate it from the method that sets the address object that represents an address table entry
	 */
	public void setAddressField(String address) throws varchar45CastException;
}
