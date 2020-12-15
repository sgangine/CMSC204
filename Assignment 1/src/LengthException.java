/**
 * Custom exception class for the length requirement
 * @author Sai Abhishek Gangineni
 */
public class LengthException extends Exception {

	/**
	 * Creates a LengthException with default message
	 */
	public LengthException() {
		super("The password must be at least 6 characters long");
	}
	
	/**
	 * Creates a LengthException with custom message
	 * @param message the message that the exception should read out
	 */
	public LengthException(String message) {
		super(message);
	}
}
