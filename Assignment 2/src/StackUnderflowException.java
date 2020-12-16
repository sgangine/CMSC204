/**
 * Custom exception class when an pop is called on empty stack
 * @author saigangineni
 */
public class StackUnderflowException extends Exception {
	
	/**
	 * Creates an StackUnderflowException with default message
	 */
	public StackUnderflowException() {
		super("This should have caused an StackUnderflowException");
	}
	
	/**
	 * Creates an StackUnderflowException with custom message
	 * @param message the message that the exception should read out
	 */
	public StackUnderflowException(String message) {
		super(message);
	}

}
