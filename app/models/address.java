package models;

import models.varchar45.varchar45CastException;
import interfaces.IAddress;

public class address implements IAddress{
	protected int zip_id;
	protected varchar45	zip_code;
	protected varchar45	city;
	protected varchar45	state;
	protected varchar45	country;
	protected varchar45	address;
	
	@Override
	public int getZip_id() {
		return zip_id;
	}
	@Override
	public void setZip_id(int zip_id) {
		this.zip_id = zip_id;
	}
	@Override
	public String getZip_code() {
		if(zip_code==null)
			return null;
		return zip_code.contents;
	}
	@Override
	public void setZip_code(String zip_code) throws varchar45CastException {
		this.zip_code = new varchar45(zip_code);
	}
	@Override
	public String getCity() {
		if(city==null)
			return null;
		return city.contents;
	}
	@Override
	public void setCity(String city) throws varchar45CastException {
		this.city = new varchar45(city);
	}
	@Override
	public String getState() {
		if(state==null)
			return null;
		return state.contents;
	}
	@Override
	public void setState(String state) throws varchar45CastException {
		this.state = new varchar45(state);
	}
	@Override
	public String getCountry() {
		if(country==null)
			return null;
		return country.contents;
	}
	@Override
	public void setCountry(String country) throws varchar45CastException {
		this.country = new varchar45(country);
	}
	@Override
	public String getAddressField() {
		if(address==null)
			return null;
		return address.contents;
	}
	@Override
	public void setAddressField(String address) throws varchar45CastException {
		this.address = new varchar45(address);
	}
}
