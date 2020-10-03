/**
 * Custom exception class when an push is called on full stack
 * @author saigangineni
 */
public class StackOverflowException extends Exception {
	
	/**
	 * Creates an StackOverflowException with default message
	 */
	public StackOverflowException() {
		super("This should have caused an StackOverflowException");
	}
	
	/**
	 * Creates an StackOverflowException with custom message
	 * @param message the message that the exception should read out
	 */
	public StackOverflowException(String message) {
		super(message);
	}

}
