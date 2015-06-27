package core;

public class UnavailableException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnavailableException(String string) {
		super(string);
	}
	
	public UnavailableException() {
		this("Sorry, this document is unavailable.");
	}

}
