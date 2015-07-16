package models;

public class longtext {
	protected String contents;

	public longtext(String longtext) throws longtextCastException{
		this.setString(longtext);
	}
	
	public String getString() {
		return contents;
	}

	//constraints on longtext are unknown at this point
	public void setString(String longtext) throws longtextCastException {
		this.contents = longtext;
	}
	
	public static class longtextCastException extends Exception{
		private static final long serialVersionUID = 1L;
		
		public longtextCastException(){
			super("the parameter given did not meet the requirements to assign to a longtext");
		}
	}
}
