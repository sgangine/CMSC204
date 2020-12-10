/**
 * Custom exception class for special character requirement
 * @author Sai Abhishek Gangineni
 */
public class NoSpecialCharacterException extends Exception {

	/**
	 * Creates a NoSpecialCharacterException with default message
	 */
	public NoSpecialCharacterException() {
		super("The password must contain at least one special character");
	}
	
	/**
	 * Creates a NoSpecialCharacterException with custom message
	 * @param message the message that the exception should read out
	 */
	public NoSpecialCharacterException(String message) {
		super(message);
	}
}
