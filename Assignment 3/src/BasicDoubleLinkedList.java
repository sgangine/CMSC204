import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {
	protected Node head, tail;
	protected int size;
	
	/**
	 * Constructs a generic double singly linked list
	 */
	public BasicDoubleLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}
	
	/**
	 * Returns the size of the linked list
	 * @return size the number of elements in the list
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * Adds an element to the end of the linked list
	 * @param data the data to be added
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data) {
		Node newNode = new Node(data);
		if (size==0) {
			head = tail = newNode;
		}
		tail.next = newNode;
		newNode.next = head;
		tail = newNode;
		size++;
		return this;
	}
	
	/**
	 * Adds an element to the front of the linked list
	 * @param data the element to be added
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> addToFront(T data) {
		Node newNode = new Node(data);
		if (size==0) {
			head = tail = newNode;
		}
		tail.next = newNode;
		newNode.next = head;
		head = newNode;
		size++;
		return this;
	}
	
	/**
	 * Returns without removing the first element of the linked list
	 * @return the data element or null if empty
	 */
	public T getFirst() {
		return head.data;
	}
	
	/**
	 * Returns without removing the last element of the linked list
	 * @return the data element or null if empty
	 */
	public T getLast() {
		return tail.data;
	}
	
	/**
	 * Removes the first instance of the target data from the linked list
	 * @param targetData the data to be removed
	 * @param comparator the comparator to determine the target
	 * @return reference to the current object
	 */
	public BasicDoubleLinkedList<T> remove(T targetData, Comparator<T> comparator){
		Node curr = head;
		Node prev = tail;
		while (comparator.compare(targetData, curr.data)!=0) {
			curr = curr.next;
			prev = prev.next;
		}	
		if (curr==head) {
			tail.next = head.next;
			head = head.next;
		}else if (curr==tail) {
			prev.next = curr.next;
			tail = prev;
		}else {
			prev.next = curr.next;
			curr = null;
		}
		size--;
		return this;
	}
	
	/**
	 * Removes and returns the first element of the linked list
	 * @return the data element or null if list is empty
	 */
	public T retrieveFirstElement() {
		T output = head.data;
		tail.next = head.next;
		head = head.next;
		size--;
		return output;
	}
	
	/**
	 * Removes and returns the last element of the linked list
	 * @return the data element or null if list is empty
	 */
	public T retrieveLastElement() {
		T output = tail.data;
		Node temp = head;
		while(temp.next!=tail) {
			temp = temp.next;
		}
		temp.next = head;
		tail = temp;
		size--;
		return output;
	}
	
	/**
	 * Returns an arraylist of all the elements in the linked list
	 * @return an arraylist of items in the list
	 */
	public ArrayList<T> toArrayList(){
		ArrayList<T> output = new ArrayList<T>(size);
		Node temp = head;
		do {
			output.add(temp.data);
			temp = temp.next;
		}while (temp != head);
		return output;
	}
	
	/**
	 * Creates an iterator to iterate through the linked list
	 * @throws UnsupportedOperationException throws if unnecessary methods such as remove or add are called
	 * @throws NoSuchElementException throws if next or previous is called when at ends of the list
	 */
	public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
		return new listIterator<T>();
	}
	
	/**
	 * Inner class that implements ListIterator and defines its methods
	 * @author saigangineni
	 *
	 * @param <T>
	 */
	protected class listIterator<T> implements ListIterator<T> {
		private int count;
		private Node curr;
		private Node prev;
		
		listIterator(){
			count = 0;
			curr = head;
			prev = tail;
		}
		
		@Override
		public boolean hasNext() {
			return count < size;
		}

		@Override
		public T next() {
			T output = (T) curr.data;
			if (!hasNext()) {
				throw new NoSuchElementException();
			}else {
				curr = curr.next;
				prev = prev.next;
				count++;
			}
			return output;
		}

		@Override
		public boolean hasPrevious() {
			return count > 0;
		}

		@Override
		public T previous() {
			T output = (T) prev.data;
			if (!hasPrevious()) {
				throw new NoSuchElementException();
			}else {
				curr = prev;
				Node temp = head;
				while(temp.next != prev) {
					temp = temp.next;
				}
				prev = temp;
				count--;
			}
			return output;
		}

		@Override
		public int nextIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public int previousIndex() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(T e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(T e) {
			throw new UnsupportedOperationException();
		}
		
	}
	
	/**
	 * Inner class that defines a Node of the linked list
	 * @author saigangineni
	 *
	 */
	protected class Node {
		T data;
		Node next;
		
		Node(T d){
			data = d;
			next = null;
		}
	}
}
