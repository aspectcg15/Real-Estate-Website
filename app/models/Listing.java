package models;

import models.longtext.longtextCastException;
import models.varchar45.varchar45CastException;
import interfaces.IAddress;
import interfaces.IProperty;
import interfaces.IPropertylisting;
import interfaces.IPropertyphoto;
import interfaces.IUsers;

public class Listing extends propertylisting implements
												IAddress,
												IProperty,
												IPropertylisting,
												IPropertyphoto,
												IUsers
												{

	@Override
	public int getPhoto_id() {
		if(this.propertyphoto==null)
			this.propertyphoto=new propertyphoto();
		return this.propertyphoto.getPhoto_id();
	}

	@Override
	public void setPhoto_id(int photo_id) {
		if(this.propertyphoto==null)
			this.propertyphoto=new propertyphoto();
		this.propertyphoto.setPhoto_id(photo_id);
	}

	@Override
	public String getPhoto_name() {
		if(this.propertyphoto==null)
			this.propertyphoto=new propertyphoto();
		return this.propertyphoto.getPhoto_name();
	}

	@Override
	public void setPhoto_name(String photo_name) throws varchar45CastException {
		if(this.propertyphoto==null)
			this.propertyphoto=new propertyphoto();
		this.propertyphoto.setPhoto_name(photo_name);
	}

	@Override
	public String getPhoto_path() {
		if(this.propertyphoto==null)
			this.propertyphoto=new propertyphoto();
		return this.propertyphoto.getPhoto_path();
	}

	@Override
	public void setPhoto_path(String photo_path) throws varchar45CastException {
		if(this.propertyphoto==null)
			this.propertyphoto=new propertyphoto();
		this.propertyphoto.setPhoto_path(photo_path);
	}

	@Override
	public int getProp_id() {
		if(this.property==null)
			this.property=new property();
		return this.property.getProp_id();
	}

	@Override
	public void setProp_id(int prop_id) {
		if(this.property==null)
			this.property=new property();
		this.property.setProp_id(prop_id);
	}

	@Override
	public double getPrice() {
		if(this.property==null)
			this.property=new property();
		return this.property.getPrice();
	}

	@Override
	public void setPrice(double price) {
		if(this.property==null)
			this.property=new property();
		this.property.setPrice(price);
	}

	@Override
	public String getSize() {
		if(this.property==null)
			this.property=new property();
		return this.property.getSize();
	}

	@Override
	public void setSize(String size) throws varchar45CastException {
		if(this.property==null)
			this.property=new property();
		this.property.setSize(size);
	}

	@Override
	public int getBed() {
		if(this.property==null)
			this.property=new property();
		return this.property.getBed();
	}

	@Override
	public void setBed(int bed) {
		if(this.property==null)
			this.property=new property();
		this.property.setBed(bed);
	}

	@Override
	public int getBath() {
		if(this.property==null)
			this.property=new property();
		return this.property.getBath();
	}

	@Override
	public void setBath(int bath) {
		if(this.property==null)
			this.property=new property();
		this.property.setBath(bath);
	}

	@Override
	public String getDescription() {
		if(this.property==null)
			this.property=new property();
		return this.property.getDescription();
	}
	
	@Override
	public void setDescription(String description) throws longtextCastException {
		if(this.property==null)
			this.property=new property();
		this.property.setDescription(description);
	}

	@Override
	public String getType() {
		if(this.property==null)
			this.property=new property();
		return this.property.getType();
	}

	@Override
	public void setType(String type) throws varchar45CastException {
		if(this.property==null)
			this.property=new property();
		this.property.setType(type);
	}

	@Override
	public int getAddress_zip_id_1() {
		if(this.property==null)
			this.property=new property();
		return this.property.getAddress_zip_id_1();
	}

	@Override
	public void setAddress_zip_id_1(int address_zip_id_1) {
		if(this.property==null)
			this.property=new property();
		this.property.setAddress_zip_id_1(address_zip_id_1);
	}

	@Override
	public int getZip_id() {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		return this.users.address.getZip_id();
	}

	@Override
	public void setZip_id(int zip_id) {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		this.users.address.setZip_id(zip_id);
	}

	@Override
	public String getZip_code() {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		return this.users.address.getZip_code();
	}

	@Override
	public void setZip_code(String zip_code) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		this.users.address.setZip_code(zip_code);
	}

	@Override
	public String getCity() {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		return this.users.address.getCity();
	}

	@Override
	public void setCity(String city) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		this.users.address.setCity(city);
	}

	@Override
	public String getState() {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		return this.users.address.getState();
	}

	@Override
	public void setState(String state) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		this.users.address.setState(state);
	}

	@Override
	public String getCountry() {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		return this.users.address.getCountry();
	}

	@Override
	public void setCountry(String country) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		this.users.address.setCountry(country);
	}

	@Override
	public String getAddressField() {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		return this.users.address.getAddressField();
	}

	@Override
	public void setAddressField(String address) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		if(this.users.address==null)
			this.users.address=new address();
		this.users.address.setAddressField(address);
	}

	@Override
	public int getUser_id() {
		if(this.users==null)
			this.users=new users();
		return this.users.getUser_id();
	}

	@Override
	public void setUser_id(int user_id) {
		if(this.users==null)
			this.users=new users();
		this.users.setUser_id(user_id);
	}

	@Override
	public String getFname() {
		if(this.users==null)
			this.users=new users();
		return this.users.getFname();
	}

	@Override
	public void setFname(String fname) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		this.users.setFname(fname);
	}

	@Override
	public String getLname() {
		if(this.users==null)
			this.users=new users();
		return this.users.getLname();
	}

	@Override
	public void setLname(String lname) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		this.users.setLname( lname);
	}

	@Override
	public String getDob() {
		if(this.users==null)
			this.users=new users();
		return this.users.getDob();
	}

	@Override
	public void setDob(String dob) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		this.users.setDob( dob);
	}

	@Override
	public String getGender() {
		if(this.users==null)
			this.users=new users();
		return this.users.getGender();
	}

	@Override
	public void setGender(String gender) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		this.users.setGender( gender);
	}

	@Override
	public String getContact() {
		if(this.users==null)
			this.users=new users();
		return this.users.getContact();
	}

	@Override
	public void setContact(String contact) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		this.users.setContact( contact);
	}

	@Override
	public String getEmail() {
		if(this.users==null)
			this.users=new users();
		return this.users.getEmail();
	}

	@Override
	public void setEmail(String email) throws varchar45CastException {
		if(this.users==null)
			this.users=new users();
		this.users.setEmail( email);
	}

	@Override
	public int getAddress_zip_id() {
		if(this.users==null)
			this.users=new users();
		return this.users.getAddress_zip_id();
	}

	@Override
	public void setAddress_zip_id(int address_zip_id) {
		if(this.users==null)
			this.users=new users();
		this.users.setAddress_zip_id( address_zip_id);
	}

	@Override
	public address getUsersAddress() {
		if(this.users==null)
			this.users=new users();
		return this.users.getUsersAddress();
	}

	@Override
	public void setUsersAddress(address address) {
		if(this.users==null)
			this.users=new users();
		this.users.setUsersAddress(address);
	}

	@Override
	public address getPropertyAddress() {
		if(this.property==null)
			this.property=new property();
		return this.property.getPropertyAddress();
	}

	@Override
	public void setPropertyAddress(address address) {
		if(this.property==null)
			this.property=new property();
		this.property.setPropertyAddress(address);
	}
}
