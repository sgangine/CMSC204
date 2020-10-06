/**
 * Custom exception class when an enqueue is called on full queue
 * @author saigangineni
 */
public class QueueOverflowException extends Exception{

	/**
	 * Creates an QueueOverflowException with default message
	 */
	public QueueOverflowException() {
		super("This should have caused an StackOverflowException");
	}
	
	/**
	 * Creates an QueueOverflowException with custom message
	 * @param message the message that the exception should read out
	 */
	public QueueOverflowException(String message) {
		super(message);
	}
}
