/**
 * Custom exception class for incorrect notation format
 * @author saigangineni
 */
public class InvalidNotationFormatException extends Exception {
	
	/**
	 * Creates an InvalidNotationFormatException with default message
	 */
	public InvalidNotationFormatException() {
		super("This should have thrown an InvalidNotationFormatException");
	}
	
	/**
	 * Creates an InvalidNotationFormatException with custom message
	 * @param message the message that the exception should read out
	 */
	public InvalidNotationFormatException(String message) {
		super(message);
	}

}
