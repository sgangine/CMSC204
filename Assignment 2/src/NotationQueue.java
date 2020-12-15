import java.util.ArrayList;
/**
 * Generic class for Queue data structure that implements QueueInterface
 * @author saigangineni
 *
 * @param <T> data type
 */

public class NotationQueue<T> implements QueueInterface<T> {
	//private ArrayList<T> data;
	private T[] data;
	private int defaultSize = 5;
	private int index;
	
	//Constructors
	/**
	 * Initializes a new NotationQueue Object with a default size of 5
	 */
	public NotationQueue() {
		data = (T[]) new Object[defaultSize];
	}
	
	/**
	 * Initializes a new NotationQueue Object with a custom size
	 * @param size the required size of the NotationQueue
	 */
	public NotationQueue(int size) {
		data = (T[]) new Object[size];
	}
	
	/**
	 * Initializes a new NotationQueue Object and fills it with the elements of an ArrayList
	 * @param input the list to be inputted
	 */
	public NotationQueue(ArrayList<T> input) {
		ArrayList<T> copy = new ArrayList<T>(input.size());
		for (T x : input) {
			copy.add(x);
		}
		data = (T[]) new Object[copy.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = copy.get(i);
			index++;
		}
	}
	
	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	public boolean isEmpty() {
		return (index == 0);
	}

	/**
	 * Determines of the Queue is empty
	 * @return true if Queue is full, false if not
	 */
	public boolean isFull() {
		return index == data.length;
	}

	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 * @throws QueueUnderflowException thrown if queue is empty
	 */
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		}else {
			T output = data[0];
			for (int i = 0; i < data.length-1; i++) {
				data[i] = data[i+1];
			}
			index--;
			return output;
		}
	}

	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	public int size() {
		return index;
	}

	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 * @throws QueueOverflowException throws if queue is full
	 */
	public boolean enqueue(T e) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		}else {
			data[index] = e;
			index++;
			return true;
		}
	}
	
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < index; i++) {
			output += data[i];
		}
		return output;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	public String toString(String delimiter) {
		String output = "";
		for (int i = 0; i < index-1; i++) {
			output += data[i] + delimiter;
		}
		output += data[index-1];
		return output;
	}

	/**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * @param list elements to be added to the Queue
	  */
	public void fill(ArrayList<T> list) {
		ArrayList<T> copy = new ArrayList<T>(list.size());
		for (T x : list) {
			copy.add(x);
		}
		data = (T[]) new Object[copy.size()];
		for (int i = 0; i < data.length; i++) {
			data[i] = copy.get(i);
			index++;
		}
	}

}
