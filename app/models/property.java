package models;

import models.longtext.longtextCastException;
import models.varchar45.varchar45CastException;
import interfaces.IProperty;

public class property implements IProperty{
	protected int	prop_id;
	protected double	price;
	protected varchar45	size;
	protected int bed;
	protected int bath;
	protected longtext	description;
	protected varchar45	type;
	protected int	address_zip_id_1;
	protected address	address;
	
	public int getProp_id() {
		return prop_id;
	}
	public void setProp_id(int prop_id) {
		this.prop_id = prop_id;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getSize() {
		if(size==null)
			return null;
		return size.contents;
	}
	public void setSize(String size) throws varchar45CastException {
		this.size = new varchar45(size);
	}
	public int getBed() {
		return bed;
	}
	public void setBed(int bed) {
		this.bed = bed;
	}
	public int getBath() {
		return bath;
	}
	public void setBath(int bath) {
		this.bath = bath;
	}
	public String getDescription() {
		if(description==null)
			return null;
		return this.description.contents;
	}
	public void setDescription(String description) throws longtextCastException {
		this.description = new longtext(description);
	}
	public String getType() {
		if(type==null)
			return null;
		return type.contents;
	}
	public void setType(String type) throws varchar45CastException {
		this.type = new varchar45(type);
	}
	public int getAddress_zip_id_1() {
		return address_zip_id_1;
	}
	public void setAddress_zip_id_1(int address_zip_id_1) {
		this.address_zip_id_1 = address_zip_id_1;
	}
	@Override
	public models.address getPropertyAddress() {
		return this.address;
	}
	@Override
	public void setPropertyAddress(models.address address) {
		this.address = address;
	}
}
