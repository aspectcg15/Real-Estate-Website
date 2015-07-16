package interfaces;

import models.address;
import models.property;
import models.propertyphoto;
import models.users;

public interface IPropertylisting {
	public int getListing_id();
	public void setListing_id(int listing_id);
	public propertyphoto getPropertyphoto();
	public void setPropertyphoto(propertyphoto propertyphoto);
	public property getProperty();
	public void setProperty(property property);
	public users getUsers();
	public void setUsers(users users);
	public address getPropertyAddress();
	public void setPropertyAddress(address address);
}
