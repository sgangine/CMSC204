import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the methods of NotationStack class
 * @author saigangineni
 *
 */
public class NotationStackTest {
	public NotationStack<String> stringS;
	public String a="a", b="b", c="c", d="d", e="e", f="f";
	public ArrayList<String> fill = new ArrayList<String>();
	
	// STUDENT: student tests will use the doubleS
	public NotationStack<Double> doubleS;
	// STUDENT: add variables as needed for your student tests
	public Double v=4.5, w=5.6, x=1.2, y=3.7, z=9.2, g=2.2;
	
	@Before
	public void setUp() throws Exception {
		try {
			stringS = new NotationStack<String>(5);
			stringS.push(a);
			stringS.push(b);
			stringS.push(c);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//STUDENT: add setup for doubleS for student tests
		try {
			doubleS = new NotationStack<Double>(5);
			doubleS.push(v);
			doubleS.push(w);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@After
	public void tearDown() throws Exception {
		stringS = null;
		doubleS = null;
	}

	/**
	 * Tests if the stack is empty
	 * First test should not be empty while the second is empty
	 * @throws StackUnderflowException thrown if pop is called on empty stack
	 */
	@Test
	public void testIsEmpty() throws StackUnderflowException {
		assertEquals(false,stringS.isEmpty());
		stringS.pop();
		stringS.pop();
		stringS.pop();
		assertEquals(true, stringS.isEmpty());
	}

	/**
	 * Tests if the stack is full
	 * First test should not be full while the second is full
	 * @throws StackUnderflowException thrown if push is called on full stack
	 */
	@Test
	public void testIsFull() throws StackOverflowException {
		assertEquals(false, stringS.isFull());
		stringS.push(d);
		stringS.push(e);
		assertEquals(true, stringS.isFull());
	}

	/**
	 * Public tests if the stack can have elements popped off
	 * After popping 3 elements the 4th test should throw an exception
	 * @throws StackUnderflowException thrown if pop is called on empty stack
	 */
	@Test
	public void testPop() {
		try {
			assertEquals(c, stringS.pop());
			assertEquals(b, stringS.pop());
			assertEquals(a, stringS.pop());
			//Stack is empty, next statement should cause QueueUnderFlowException
			stringS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}

	/**
	 * Student tests if the stack can have elements popped off
	 * After popping 2 elements the 3rd test should throw an exception
	 * @throws StackUnderflowException thrown if pop is called on empty stack
	 */
	@Test
	public void testPopStudent() {
		try {
			assertEquals(w, doubleS.pop(), .001);
			assertEquals(v, doubleS.pop(), .001);
			//Stack is empty, next statement should cause QueueUnderFlowException
			doubleS.pop();
			assertTrue("This should have caused an StackUnderflowException", false);
		}
		catch (StackUnderflowException e){
			assertTrue("This should have caused an StackUnderflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackUnderflowException", false);
		}
	}
	
	/**
	 * Tests if the stack can return top element
	 * @throws StackUnderflowException thrown if top is called on empty stack
	 */
	@Test
	public void testTop() throws StackOverflowException, StackUnderflowException {
		assertEquals(c, stringS.top());
		stringS.push(d);
		assertEquals(d, stringS.top());
		stringS.pop();
		stringS.pop();
		assertEquals(b, stringS.top());		
	}

	/**
	 * Tests the size of the stack
	 * @throws StackUnderflowException thrown if pop is called on empty stack
	 */
	@Test
	public void testSize() throws StackUnderflowException, StackOverflowException {
		assertEquals(3, stringS.size());
		stringS.push(d);
		assertEquals(4, stringS.size());
		stringS.pop();
		stringS.pop();
		assertEquals(2, stringS.size());
	}

	/**
	 * Public tests if the stack can have elements pushed in
	 * After pushing 3 elements the 4th test should throw an exception
	 * @throws StackUnderflowException thrown if push is called on full stack
	 */
	@Test
	public void testPush() {
		try {
			assertEquals(3, stringS.size());
			assertEquals(true, stringS.push(d));
			assertEquals(4, stringS.size());
			assertEquals(true, stringS.push(e));
			assertEquals(5, stringS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			stringS.push(f);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}

	/**
	 * Student tests if the stack can have elements pushed in
	 * After pushing 4 elements the 5th test should throw an exception
	 * @throws StackUnderflowException thrown if push is called on full stack
	 */
	@Test
	public void testPushStudent() {
		try {
			assertEquals(2, doubleS.size());
			assertEquals(true, doubleS.push(x));
			assertEquals(3, doubleS.size());
			assertEquals(true, doubleS.push(y));
			assertEquals(4, doubleS.size());
			assertEquals(true, doubleS.push(z));
			assertEquals(5, doubleS.size());
			//Queue is full, next statement should cause QueueOverFlowException
			doubleS.push(g);
			assertTrue("This should have caused an StackOverflowException", false);
		}
		catch (StackOverflowException e){
			assertTrue("This should have caused an StackOverflowException", true);
		}
		catch (Exception e){
			assertTrue("This should have caused an StackOverflowException", false);
		}
	}
	
	/**
	 * Public tests if stack can be converted to string format
	 * @throws StackOverflowException thrown if push is called on full stack
	 */
	@Test
	public void testToString() throws StackOverflowException {
		assertEquals("abc", stringS.toString());
		stringS.push(d);
		assertEquals("abcd", stringS.toString());
		stringS.push(e);
		assertEquals("abcde", stringS.toString());
	}

	/**
	 * Student tests if stack can be converted to string format
	 * @throws StackOverflowException thrown if push is called on full stack
	 */
	@Test
	public void testToStringStudent() throws StackOverflowException {
		assertEquals("4.55.6", doubleS.toString());
		doubleS.push(x);
		assertEquals("4.55.61.2", doubleS.toString());
		doubleS.push(y);
		assertEquals("4.55.61.23.7", doubleS.toString());
	}
	
	/**
	 * Public tests if stack can be converted to string format with delimiters
	 * @throws StackOverflowException thrown if push is called on full stack
	 */
	@Test
	public void testToStringDelimiter() throws StackOverflowException {
		assertEquals("a%b%c", stringS.toString("%"));
		stringS.push(d);
		assertEquals("a&b&c&d", stringS.toString("&"));
		stringS.push(e);
		assertEquals("a/b/c/d/e", stringS.toString("/"));
	}

	/**
	 * Public tests if stack can be filled with an arraylist
	 * @throws StackOverflowException thrown if push is called on full stack
	 */
	@Test
	public void testFill() throws StackUnderflowException {
		fill.add("apple");
		fill.add("banana");
		fill.add("carrot");
		//start with an empty queue
		stringS = new NotationStack<String>(fill);
		assertEquals(3,stringS.size());
		assertEquals("carrot", stringS.pop());
		assertEquals("banana", stringS.pop());
		assertEquals("apple", stringS.pop());		
	}

}