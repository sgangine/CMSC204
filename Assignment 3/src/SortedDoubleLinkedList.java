import java.util.Comparator;
import java.util.ListIterator;

public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {
	//private Node head, tail;
	//private int size;
	private Comparator<T> comp;
	
	/**
	 * Creates an empty sorted linked list associated with the given comparator
	 * @param comparator2 the comparator to compare the data elements
	 */
	public SortedDoubleLinkedList(Comparator<T> comparator2){
		head = null;
		tail = null;
		size = 0;
		comp = comparator2;
	}
	
	/**
	 * Adds the specified element at the correct position in the sorted list
	 * @param data the data to be added
	 * @return reference to the current object
	 */
	public SortedDoubleLinkedList<T> add(T data) {
		Node newNode = new Node(data);
		Node curr = head;
		if (curr == null) {
			newNode.next = newNode;
			head = tail = newNode;
		}else if(comp.compare(data, curr.data)<=0) {
			while(curr.next != head) {
				curr = curr.next;
			}
			curr.next = newNode;
			newNode.next = head;
			head = newNode;
			tail = curr;
		}else {
			while (curr.next != head && comp.compare(data, curr.next.data)>0) {
				curr = curr.next;
			}
			if(curr.next==head) {
				curr.next = newNode;
				newNode.next = head;
				tail = newNode;
			}else {
				newNode.next = curr.next;
				curr.next = newNode;
			}
		}
		size++;
		return this;
	}
	
	/**
	 * This operation is invalid for a sorted list, so it will throw an exception
	 * @throws UnsupportedOperationException thrown if method is called
	 */
	public BasicDoubleLinkedList<T> addToEnd(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * This operation is invalid for a sorted list, so it will throw an exception
	 * @throws UnsupportedOperationException thrown if method is called
	 */
	public BasicDoubleLinkedList<T> addToFront(T data){
		throw new UnsupportedOperationException("Invalid operation for sorted list");
	}
	
	/**
	 * Implements the super class iterator method
	 */
	public ListIterator<T> iterator(){
		return super.iterator();
	}
	
	/**
	 * Implements the super class remove method
	 */
	public SortedDoubleLinkedList<T> remove(T data, Comparator<T> comparator) {
		return (SortedDoubleLinkedList<T>) super.remove(data, comparator);
	}
}
