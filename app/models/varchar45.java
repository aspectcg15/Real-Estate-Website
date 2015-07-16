package models;

import java.io.Serializable;

/**
 * This class's responsibility is to ensure that the string provided fits within a varchar[45] field of MySQL
 * @author skinsella
 *
 */

public class varchar45 implements Serializable {

	protected static final long serialVersionUID = 1L;
	
	protected String	contents = null;

	public varchar45(String contents) throws varchar45CastException{
		this.setVarchar45(contents);
	}
	
	public String getVarchar45() {
		return contents;
	}

	public void setVarchar45(String varchar) throws varchar45CastException {
		if(varchar.length() > 45)
			throw new varchar45CastException();
		this.contents = varchar;
	}
	
	public static class varchar45CastException extends Exception{

		private static final long serialVersionUID = 1L;

		public varchar45CastException(){
			super("input String must not exceed 45 characters in length");
		}
	}
}
