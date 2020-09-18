/**
 * Custom exception class for failing the sequence requirement
 * @author Sai Abhishek Gangineni
 */
public class InvalidSequenceException extends Exception {

	/**
	 * Creates an InvalidSequenceException with default message
	 */
	public InvalidSequenceException() {
		super("The password cannot contain more than two of the same character in sequence");
	}
	
	/**
	 * Creates an InvalidSequenceException with custom message
	 * @param message the message that the exception should read out
	 */
	public InvalidSequenceException(String message) {
		super(message);
	}
}
