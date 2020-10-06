/**
 * Custom exception class for lowercase character requirement
 * @author Sai Abhishek Gangineni
 */
public class NoLowerAlphaException extends Exception {

	/**
	 * Creates a NoLowerAlphaException with default message
	 */
	public NoLowerAlphaException() {
		super("The password must contain at least one lower case alphabetic character");
	}
	
	/**
	 * Creates a NoLowerAlphaException with custom message 
	 * @param message the message that the constructor should read out
	 */
	public NoLowerAlphaException(String message) {
		super(message);
	}
}
