/**
 * Custom exception class for weak password length check
 * @author Sai Abhishek Gangineni
 */
public class WeakPasswordException extends Exception {

	/**
	 * Creates a WeakPasswordException with default message
	 */
	public WeakPasswordException() {
		super("The password is OK but weak - it contains fewer than 10 characters.");
	}
	
	/**
	 * Creates a WeakPasswordException with custom message
	 * @param message the message that the exception should read out
	 */
	public WeakPasswordException(String message) {
		super(message);
	}
}
