import java.util.ArrayList;
/**
 * Generic class for a generic stack data structure
 * @author saigangineni
 *
 * @param <T> data type
 */
public class NotationStack<T> implements StackInterface<T> {
	private T[] data;
	private int defaultSize = 5;
	private int index;
	
	//Constructors
	/**
	 * Initializes a NotationStack object with a default size of 5
	 */
	public NotationStack() {
		data = (T[]) new Object[defaultSize];
	}
	
	/**
	 * Initializes a NotationStack object with a custom size
	 * @param size the size of the NotationStack
	 */
	public NotationStack(int size) {
		data = (T[]) new Object[size];
	}
	
	/**
	 * Initializes a NotationStack object and fills it with the elements of an ArrayList
	 * @param input the list to be inputted
	 */
	public NotationStack(ArrayList<T> input) {
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
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	public boolean isEmpty() {
		return index==0;
	}

	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	public boolean isFull() {
		return index==data.length;
	}

	/**
	 * Deletes and returns the element at the top of the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException throws if the stack is empty
	 */
	public T pop() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}else {
			T output = data[index-1];
			data[index-1] = null;
			index--;
			return output;
		}
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 * @throws StackUnderflowException throws if the stack is empty
	 */
	public T top() throws StackUnderflowException {
		if(isEmpty()) {
			throw new StackUnderflowException();
		}else {
			return data[index-1];
		}
	}

	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	public int size() {
		return index;
	}
	
	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 * @throws StackOverflowException throws if the stack is full
	 */
	public boolean push(T e) throws StackOverflowException {
		if (isFull()) {
			throw new StackOverflowException();
		}else {
			data[index] = e;
			index++;
			return true;
		}
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return a string which represent the Objects in the Stack from bottom to top
	 */
	public String toString() {
		String output = "";
		for (int i = 0; i < index; i++) {
			output += data[i];
		}
		return output;
	}

	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	public String toString(String delimiter) {
		String output = "";
		for (int i = 0; i < index-1; i++) {
			output += data[i] + delimiter;
		}
		output += data[index-1];
		return output;
	}
}
