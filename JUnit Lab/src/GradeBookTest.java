import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradeBookTest {

	private GradeBook g1, g2;
	
	@BeforeEach
	void setUp() throws Exception {
		g1 = new GradeBook(5);
		g2 = new GradeBook(5);
		g1.addScore(50);
		g1.addScore(85);
		g1.addScore(90);
		g2.addScore(70);
		g2.addScore(80);
		g2.addScore(100);
	}

	@AfterEach
	void tearDown() throws Exception {
		g1 = null;
		g2 = null;
	}

	@Test
	void testAddScore() {
		String test1 = "50.0 85.0 90.0"; //Expected scores for g1
		String test2 = "70.0 80.0 100.0"; //Expected scores for g1
		assertTrue(test1.equals(g1.toString()));
		assertTrue(test2.equals(g2.toString()));
		assertEquals(3, g1.getScoreSize());
		assertEquals(3, g2.getScoreSize());
	}

	@Test
	void testSum() {
		assertEquals(225.0, g1.sum());
		assertEquals(250.0, g2.sum());
	}

	@Test
	void testMinimum() {
		assertEquals(50.0, g1.minimum());
		assertEquals(70.0, g2.minimum());
	}

	@Test
	void testFinalScore() {
		assertEquals(175.0, g1.finalScore());
		assertEquals(180.0, g2.finalScore());
	}

}
