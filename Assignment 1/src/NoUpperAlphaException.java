/**
 * Custom exception class for uppercase character requirement
 * @author Sai Abhishek Gangineni
 */
public class NoUpperAlphaException extends Exception {
	
	/**
	 * Creates a NoUpperAlphaException with default message
	 */
	public NoUpperAlphaException() {
		super("The password must contain at least one uppercase alphabetic character");
	}
	
	/**
	 * Creates a NoUpperAlphaException with custom message
	 * @param message the message that the exception should read out
	 */
	public NoUpperAlphaException(String message) {
		super(message);
	}

}
