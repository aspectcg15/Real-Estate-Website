package models;

import interfaces.IUsers;
import models.varchar45.varchar45CastException;

public class users implements IUsers {
	protected int	user_id;
	protected varchar45	fname;
	protected varchar45	lname;
	protected varchar45	dob;
	protected varchar45	gender;
	protected varchar45	contact;
	protected varchar45	email;
	protected address	address;
	
	/*public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public varchar45 getFname() {
		return fname;
	}
	public void setFname(varchar45 fname) {
		this.fname = fname;
	}
	public varchar45 getLname() {
		return lname;
	}
	public void setLname(varchar45 lname) {
		this.lname = lname;
	}
	public varchar45 getDob() {
		return dob;
	}
	public void setDob(varchar45 dob) {
		this.dob = dob;
	}
	public varchar45 getGender() {
		return gender;
	}
	public void setGender(varchar45 gender) {
		this.gender = gender;
	}
	public varchar45 getContact() {
		return contact;
	}
	public void setContact(varchar45 contact) {
		this.contact = contact;
	}
	public varchar45 getEmail() {
		return email;
	}
	public void setEmail(varchar45 email) {
		this.email = email;
	}
	public int getAddress_zip_id() {
		return address_zip_id;
	}
	public void setAddress_zip_id(int address_zip_id) {
		this.address_zip_id = address_zip_id;
	}*/
	
	@Override
	public int getUser_id() {
		return user_id;
	}
	@Override
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	@Override
	public String getFname() {
		if(this.fname==null)
			return null;
		return fname.getVarchar45();
	}
	@Override
	public void setFname(String fname) throws varchar45CastException {
		this.fname = new varchar45(fname);
	}
	@Override
	public String getLname() {
		if(this.lname==null)
			return null;
		return this.lname.getVarchar45();
	}
	@Override
	public void setLname(String lname) throws varchar45CastException {
		this.lname = new varchar45(lname);
	}
	@Override
	public String getDob() {
		if(this.dob==null)
			return null;
		return dob.getVarchar45();
	}
	@Override
	public void setDob(String dob) throws varchar45CastException {
		this.dob = new varchar45(dob);
	}
	@Override
	public String getGender() {
		if(this.gender==null)
			return null;
		return gender.getVarchar45();
	}
	@Override
	public void setGender(String gender) throws varchar45CastException {
		this.gender = new varchar45(gender);
	}
	@Override
	public String getContact() {
		if(this.contact==null)
			return null;
		return this.contact.getVarchar45();
	}
	@Override
	public void setContact(String contact) throws varchar45CastException {
		this.contact = new varchar45(contact);
	}
	@Override
	public String getEmail() {
		if(this.email==null)
			return null;
		return this.email.getVarchar45();
	}
	@Override
	public void setEmail(String email) throws varchar45CastException {
		this.email = new varchar45(email);
	}
	@Override
	public int getAddress_zip_id() {
		if(this.address==null)
			return -1;
		return this.address.getZip_id();
	}
	@Override
	public void setAddress_zip_id(int address_zip_id) {
		if(this.address==null)
			this.address=new address();
		this.address.setZip_id(address_zip_id);
	}
	@Override
	public models.address getUsersAddress() {
		return this.address;
	}
	@Override
	public void setUsersAddress(models.address address) {
		this.address = address;
	}
}
