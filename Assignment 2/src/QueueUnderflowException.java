/**
 * Custom exception class when an dequeue is called on empty queue
 * @author saigangineni
 */
public class QueueUnderflowException extends Exception{
	
	/**
	 * Creates an QueueUnderflowException with default message
	 */
	public QueueUnderflowException() {
		super("This should have caused an StackOverflowException");
	}
	
	/**
	 * Creates an QueueUnderflowException with custom message
	 * @param message the message that the exception should read out
	 */
	public QueueUnderflowException(String message) {
		super(message);
	}

}
