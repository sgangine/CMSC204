/**
 * Custom exception class for password re-entry requirement
 * @author Sai Abhishek Gangineni
 */
public class UnmatchedException extends Exception {

	/**
	 * Creates an UnmatchedException with default message
	 */
	public UnmatchedException() {
		super("Passwords do not match");
	}
	
	/**
	 * Creates an UnmatchedException with custom message
	 * @param message the message that the exception should read out
	 */
	public UnmatchedException(String message) {
		super(message);
	}
}
