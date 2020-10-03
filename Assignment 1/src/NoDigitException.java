/**
 * Custom exception class for digit requirement
 * @author Sai Abhishek Gangineni
 */
public class NoDigitException extends Exception {

	/**
	 * Creates a NoDigitException with default message
	 */
	public NoDigitException() {
		super("The password must contain at least one digit");
	}
	
	/**
	 * Creates a NoDigitException with custom message
	 * @param message the message that the exception should read out
	 */
	public NoDigitException(String message) {
		super(message);
	}
}
