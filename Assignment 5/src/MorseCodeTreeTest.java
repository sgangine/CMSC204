import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * Test class for MorseCodeTree class
 * @author Sai Abhishek Gangineni
 *
 */
class MorseCodeTreeTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	/**
	 * Tests if class can accurately return the root of tree
	 */
	void testGetRoot() {
		MorseCodeTree test = new MorseCodeTree();
		String result = test.getRoot().getData();
		assertEquals("", result);
	}

	@Test
	/**
	 * Tests if class can accurately set the root of the tree
	 */
	void testSetRoot() {
		MorseCodeTree test = new MorseCodeTree();
		test.setRoot(new TreeNode<String>("hello"));
		String result = test.getRoot().getData();
		assertEquals("hello", result);
	}

	@Test
	/**
	 * Tests if class can accurately fetch a letter based on given code
	 */
	void testFetch() {
		MorseCodeTree test = new MorseCodeTree();
		String result = test.fetch("....");
		assertEquals("h", result);
	}

	@Test
	/**
	 * Tests if tree is built correctly by ordering the elements in 
	 * LNR order via the toArrayList method
	 */
	void testToArrayList() {
		MorseCodeTree test = new MorseCodeTree();
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("h");
		expected.add("s");
		expected.add("v");
		expected.add("i");
		expected.add("f");
		expected.add("u");
		expected.add("e");
		expected.add("l");
		expected.add("r");
		expected.add("a");
		expected.add("p");
		expected.add("w");
		expected.add("j");
		expected.add("");
		expected.add("b");
		expected.add("d");
		expected.add("x");
		expected.add("n");
		expected.add("c");
		expected.add("k");
		expected.add("y");
		expected.add("t");
		expected.add("z");
		expected.add("g");
		expected.add("q");
		expected.add("m");
		expected.add("o");
		ArrayList<String> result = test.toArrayList();
		for (int i = 0; i < result.size(); i++) {
			assertEquals(expected.get(i), result.get(i));
		}
	}

}
