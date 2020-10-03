import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Tests for the methods of NotationQueue class
 * @author saigangineni
 *
 */
public class NotationQueueTest {
	public NotationQueue<String> stringQ;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleQ
	public NotationQueue<Double> doubleQ;
	// STUDENT: add variables as needed for your student tests
	public Double v=4.5, w=5.6, x=1.2, y=3.7, z=9.2, g=2.2;

	@Before
	public void setUp() throws Exception {
		stringQ = new NotationQueue<String>(5);
		stringQ.enqueue(a);
		stringQ.enqueue(b);
		stringQ.enqueue(c);
		
		//STUDENT: add setup for doubleQ for student tests
		try {
			doubleQ = new NotationQueue<Double>(5);
			doubleQ.enqueue(v);
			doubleQ.enqueue(w);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		stringQ = null;
		doubleQ = null;
	}

	/**
	 * Tests if the queue is empty
	 * First test should not be empty while the second is empty
	 * @throws QueueUnderflowException thrown if dequeue is called on empty queue
	 */
	@Test
	public void testIsEmpty() throws QueueUnderflowException {
		assertEquals(false,stringQ.isEmpty());
		stringQ.dequeue();
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(true, stringQ.isEmpty());
	}

	/**
	 * Public tests if the queue can have elements taken off
	 * After taking 3 elements off the 4th test should throw an exception
	 * @throws QueueUnderflowException thrown if dequeue is called on empty queue
	 */
	@Test
	public void testDequeue() {
		try {
			assertEquals(a, stringQ.dequeue());
			assertEquals(b, stringQ.dequeue());
			assertEquals(c, stringQ.dequeue());
			//Queue is empty, next statement should cause QueueUnderFlowException
			stringQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}
	
	/**
	 * Student tests if the queue can have elements taken off
	 * After taking 2 elements off the 3rd test should throw an exception
	 * @throws QueueUnderflowException thrown if dequeue is called on empty queue
	 */
	@Test
	public void testDequeueStudent() {
		try {
			assertEquals(v, doubleQ.dequeue(), .001);
			assertEquals(w, doubleQ.dequeue(), .001);
			//Queue is empty, next statement should cause QueueUnderFlowException
			doubleQ.dequeue();
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
		catch (QueueUnderflowException e){
			assertTrue("This should have caused an QueueUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueUnderflowException", false);
		}
	}

	/**
	 * Tests the size of the queue
	 * @throws StackUnderflowException thrown if dequeue is called on empty queue
	 * @throws QueueOverflowException thrown is enqueue is called on full queue
	 */
	@Test
	public void testSize() throws QueueUnderflowException, QueueOverflowException {
		assertEquals(3, stringQ.size());
		stringQ.enqueue(d);
		assertEquals(4, stringQ.size());
		stringQ.dequeue();
		stringQ.dequeue();
		assertEquals(2, stringQ.size());
	}

	/**
	 * Public tests if the queue can have elements added on
	 * After adding 3 elements  the 4th test should throw an exception that is caught and handled
	 */
	@Test
	public void testEnqueue() {
		try {
			assertEquals(3, stringQ.size());
			assertEquals(true, stringQ.enqueue(d));
			assertEquals(4, stringQ.size());
			assertEquals(true, stringQ.enqueue(e));
			assertEquals(5, stringQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringQ.enqueue(f);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	/**
	 * Student tests if the queue can have elements added on
	 * After adding 4 elements  the 5th test should throw an exception that is caught and handled
	 */
	@Test
	public void testEnqueueStudent() {
		try {
			assertEquals(2, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(x));
			assertEquals(3, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(y));
			assertEquals(4, doubleQ.size());
			assertEquals(true, doubleQ.enqueue(z));
			assertEquals(5, doubleQ.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleQ.enqueue(g);
			assertTrue("This should have caused an QueueOverflowException", false);
		}
		catch (QueueOverflowException e){
			assertTrue("This should have caused an QueueOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an QueueOverflowException", false);
		}
	}

	/**
	 * Tests if the queue is full
	 * First test should not be full while the second is full
	 * @throws QueueUnderflowException thrown if enqueue is called on full queue
	 */
	@Test
	public void testIsFull() throws QueueOverflowException {
		assertEquals(false, stringQ.isFull());
		stringQ.enqueue(d);
		stringQ.enqueue(e);
		assertEquals(true, stringQ.isFull());
	}

	/**
	 * Public tests if queue can be converted to string format
	 * @throws QueueOverflowException thrown if enqueue is called on full queue
	 */
	@Test
	public void testToString() throws QueueOverflowException {
		assertEquals("abc", stringQ.toString());
		stringQ.enqueue(d);
		assertEquals("abcd", stringQ.toString());
		stringQ.enqueue(e);
		assertEquals("abcde", stringQ.toString());
	}
	
	/**
	 * Student tests if queue can be converted to string format
	 * @throws QueueOverflowException thrown if enqueue is called on full queue
	 */
	@Test
	public void testToStringStudent() throws QueueOverflowException {
		assertEquals("4.55.6", doubleQ.toString());
		doubleQ.enqueue(x);
		assertEquals("4.55.61.2", doubleQ.toString());
		doubleQ.enqueue(y);
		assertEquals("4.55.61.23.7", doubleQ.toString());
	}

	/**
	 * Public tests if queue can be converted to string format with delimiters
	 * @throws QueueOverflowException thrown if enqueue is called on full queue
	 */
	@Test
	public void testToStringDelimiter() throws QueueOverflowException {
		assertEquals("a%b%c", stringQ.toString("%"));
		stringQ.enqueue(d);
		assertEquals("a&b&c&d", stringQ.toString("&"));
		stringQ.enqueue(e);
		assertEquals("a/b/c/d/e", stringQ.toString("/"));
	}

	/**
	 * Public tests if queue can be filled with an arraylist
	 * @throws QueueOverflowException thrown if enqueue is called on full queue
	 */
	@Test
	public void testFill() throws QueueUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringQ = new NotationQueue<String>(fill);
		assertEquals(3,stringQ.size());
		assertEquals("apple", stringQ.dequeue());
		assertEquals("banana", stringQ.dequeue());
		assertEquals("carrot", stringQ.dequeue());		
	}

}