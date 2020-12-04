import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student tests for BasicDoubleLinkedList class
 * @author Sai Abhishek Gangineni
 *
 */
class BasicDoubleLinkedList_STUDENT_Test {
	BasicDoubleLinkedList<String> linkedList;
	StringComparator comparator;
	
	/**
	 * Inner class to create a comparator to compare strings
	 * @author Sai Abhishek Gangineni
	 *
	 */
	private class StringComparator implements Comparator<String>
	{

		@Override
		/**
		 * Overrides compare method with custom one
		 * @param arg0 the first string being compared
		 * @param arg1 the second string being compared
		 */
		public int compare(String arg0, String arg1) {
			return arg0.compareTo(arg1);
		}
		
	}
	
	@BeforeEach
	void setUp() throws Exception {
		linkedList = new BasicDoubleLinkedList<String>();
		linkedList.addToEnd("name");
		linkedList.addToEnd("is");
		comparator = new StringComparator();
	}

	@AfterEach
	void tearDown() throws Exception {
		linkedList = null;
		comparator = null;
	}

	@Test
	/**
	 * Tests if correct size of list is returned
	 */
	void testGetSize() {
		assertEquals(2,linkedList.getSize());
	}

	@Test
	/**
	 * Tests if element can be correctly added to end of list
	 */
	void testAddToEnd() {
		assertEquals("is", linkedList.getLast());
		linkedList.addToEnd("Sai");
		assertEquals("Sai", linkedList.getLast());
	}

	@Test
	/**
	 * Tests if element can be correctly added to front of list
	 */
	void testAddToFront() {
		assertEquals("name", linkedList.getFirst());
		linkedList.addToFront("My");
		assertEquals("My", linkedList.getFirst());
	}

	@Test
	/**
	 * Tests if method can return first element correctly
	 */
	void testGetFirst() {
		assertEquals("name", linkedList.getFirst());
		linkedList.addToFront("First");
		assertEquals("First", linkedList.getFirst());
	}

	@Test
	/**
	 * Tests if method can return last element correctly
	 */
	void testGetLast() {
		assertEquals("is", linkedList.getLast());
		linkedList.addToEnd("Last");
		assertEquals("Last", linkedList.getLast());
	}

	@Test
	/**
	 * Tests if method can remove element correctly
	 */
	void testRemove() {
		//Remove first element
		linkedList.addToFront("My");
		linkedList.remove("My", comparator);
		assertEquals("name", linkedList.getFirst());
		//Remove last element
		linkedList.addToEnd("Sai");
		linkedList.remove("Sai", comparator);
		assertEquals("is", linkedList.getLast());
		//Remove middle element
		linkedList.addToFront("My");
		linkedList.remove("name", comparator);
		assertEquals("My", linkedList.getFirst());
		assertEquals("is", linkedList.getLast());
	}

	@Test
	/**
	 * Tests if method can remove and return first element
	 */
	void testRetrieveFirstElement() {
		linkedList.addToFront("My");
		assertEquals("My", linkedList.getFirst());
		assertEquals("My", linkedList.retrieveFirstElement());
		assertEquals("name", linkedList.getFirst());
	}

	@Test
	/**
	 * Tests if method can remove and return last element
	 */
	void testRetrieveLastElement() {
		linkedList.addToEnd("Sai");
		assertEquals("Sai", linkedList.getLast());
		assertEquals("Sai", linkedList.retrieveLastElement());
		assertEquals("is", linkedList.getLast());
	}

	@Test
	/**
	 * Tests if method can convert list to ArrayList
	 */
	void testToArrayList() {
		ArrayList<String> list;
		linkedList.addToFront("My");
		linkedList.addToEnd("Sai");
		list = linkedList.toArrayList();
		assertEquals("My",list.get(0));
		assertEquals("name",list.get(1));
		assertEquals("is",list.get(2));
		assertEquals("Sai",list.get(3));
	}

	@Test
	/**
	 * Tests if iterator works correctly
	 */
	void testIterator() {
		linkedList.addToFront("My");
		linkedList.addToEnd("Sai");
		ListIterator<String> iterator = linkedList.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("My", iterator.next());
		assertEquals("name", iterator.next());
		assertEquals("is", iterator.next());
		assertEquals(true, iterator.hasNext());
		assertEquals("Sai", iterator.next());
		assertEquals(true, iterator.hasPrevious());
		assertEquals("Sai", iterator.previous());
		assertEquals("is", iterator.previous());
		assertEquals("name", iterator.previous());
		assertEquals("My", iterator.previous());
	}

}
