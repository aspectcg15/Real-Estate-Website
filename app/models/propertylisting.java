package models;

import interfaces.IPropertylisting;

public class propertylisting implements IPropertylisting{
	protected int	listing_id;
	/*protected int	propertyphoto_photo_id;
	protected int	property_prop_id;
	protected int	users_user_id;
	
	public int getListing_id() {
		return listing_id;
	}
	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}
	public int getPropertyphoto_photo_id() {
		return propertyphoto_photo_id;
	}
	public void setPropertyphoto_photo_id(int propertyphoto_photo_id) {
		this.propertyphoto_photo_id = propertyphoto_photo_id;
	}
	public int getProperty_prop_id() {
		return property_prop_id;
	}
	public void setProperty_prop_id(int property_prop_id) {
		this.property_prop_id = property_prop_id;
	}
	public int getUsers_user_id() {
		return users_user_id;
	}
	public void setUsers_user_id(int users_user_id) {
		this.users_user_id = users_user_id;
	}*/
	
	protected propertyphoto	propertyphoto;
	protected property	property;
	protected users	users;
	
	@Override
	public int getListing_id() {
		return listing_id;
	}
	@Override
	public void setListing_id(int listing_id) {
		this.listing_id = listing_id;
	}
	@Override
	public propertyphoto getPropertyphoto() {
		return propertyphoto;
	}
	@Override
	public void setPropertyphoto(propertyphoto propertyphoto) {
		this.propertyphoto = propertyphoto;
	}
	@Override
	public property getProperty() {
		return property;
	}
	@Override
	public void setProperty(property property) {
		this.property = property;
	}
	@Override
	public users getUsers() {
		return users;
	}
	@Override
	public void setUsers(users users) {
		this.users = users;
	}
	@Override
	public address getPropertyAddress() {
		if(property==null)
			return null;
		return this.property.getPropertyAddress();
	}
	@Override
	public void setPropertyAddress(address address) {
		if(property==null)
			this.property = new property();
		this.property.setPropertyAddress(address);
	}
}
