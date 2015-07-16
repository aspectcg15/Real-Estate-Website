package interfaces;

import models.address;
import models.longtext.longtextCastException;
import models.varchar45.varchar45CastException;

public interface IProperty {
	public int getProp_id();
	public void setProp_id(int prop_id);
	public double getPrice();
	public void setPrice(double price);
	public String getSize();
	public void setSize(String size) throws varchar45CastException;
	public int getBed();
	public void setBed(int bed);
	public int getBath();
	public void setBath(int bath);
	public String getDescription();
	public void setDescription(String description) throws longtextCastException;
	public String getType();
	public void setType(String type) throws varchar45CastException;
	public int getAddress_zip_id_1();
	public void setAddress_zip_id_1(int address_zip_id_1);
	public address getPropertyAddress();
	public void setPropertyAddress(address address);
}
