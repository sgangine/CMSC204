import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Student tests for SortedDoubleLinkedList class
 * @author Sai Abhishek Gangineni
 *
 */
class SortedDoubleLinkedList_STUDENT_Test {
	SortedDoubleLinkedList<String> sortedLinkedList;
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
		comparator = new StringComparator();
		sortedLinkedList = new SortedDoubleLinkedList<String>(comparator);
	}

	@AfterEach
	void tearDown() throws Exception {
		comparator = null;
		sortedLinkedList = null;
	}

	@Test
	/**
	 * Should throw an exception for this invalid method
	 */
	void testAddToEnd() {
		try {
			sortedLinkedList.addToEnd("Sai");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	/**
	 * Should throw an exception for this invalid method
	 */
	void testAddToFront() {
		try {
			sortedLinkedList.addToFront("My");
			assertTrue("Did not throw an UnsupportedOperationException", false);
		}
		catch (UnsupportedOperationException e)
		{
			assertTrue("Successfully threw an UnsupportedOperationException", true);
		}
		catch (Exception e)
		{
			assertTrue("Threw an exception other than the UnsupportedOperationException", false);
		}
	}

	@Test
	/**
	 * Tests method of iterator on sorted list
	 */
	void testIterator() {
		//next and hasNext
		sortedLinkedList.add("bananas");
		sortedLinkedList.add("apples");
		sortedLinkedList.add("watermelons");
		sortedLinkedList.add("kiwis");
		ListIterator<String> iterator = sortedLinkedList.iterator();
		assertEquals(true, iterator.hasNext());
		assertEquals("apples", iterator.next());
		assertEquals("bananas", iterator.next());
		assertEquals("kiwis", iterator.next());
		assertEquals(true, iterator.hasNext());
		
		//previous and hasPrevious
		assertEquals(true, iterator.hasPrevious());
		assertEquals("kiwis", iterator.previous());
		assertEquals("bananas", iterator.previous());
		assertEquals("apples", iterator.previous());
	}

	@Test
	/**
	 * Tests if method can add elements in correct order
	 */
	void testAdd() {
		sortedLinkedList.add("bananas");
		sortedLinkedList.add("apples");
		assertEquals("apples", sortedLinkedList.getFirst());
		
	}

	@Test
	/**
	 * Tests if method can remove the correct element
	 */
	void testRemoveTComparatorOfT() {
		sortedLinkedList.add("bananas");
		sortedLinkedList.add("apples");
		sortedLinkedList.add("watermelons");
		sortedLinkedList.add("kiwis");
		//Remove first element
		sortedLinkedList.remove("apples", comparator);
		assertEquals("bananas", sortedLinkedList.getFirst());
		//Remove last element
		sortedLinkedList.add("apples");
		sortedLinkedList.remove("watermelons", comparator);
		assertEquals("kiwis", sortedLinkedList.getLast());
		//Remove middle
		sortedLinkedList.add("watermelons");
		sortedLinkedList.remove("kiwis", comparator);
		assertEquals("apples", sortedLinkedList.getFirst());
		assertEquals("watermelons", sortedLinkedList.getLast());
	}

}
