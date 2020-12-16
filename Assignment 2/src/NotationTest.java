import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the methods of Notation
 * @author saigangineni
 *
 */
public class NotationTest {
	public String complexInfix = "(3+(((5*7)-(((8/2)-1)*4))*6))";
	public String complexPostfix =  "357*82/1-4*-6*+";
	public String easyInfix = "(5+4)";
	public String easyPostfix = "54+";
	public String intermediateInfix = "((3*(5+4))+2)";
	public String intermediatePostfix = "354+*2+";

	public String invalidPostfixExpression = "354+*-";
	public String invalidInfixExpression = "(3+5)*4)-2";
	
	public double evalComplexPostfix = 141.0;
	public double evalIntermediatePostfix = 29.0;
	public double evalEasyPostfix = 9.0;

	@Before	
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Complex test for if the method can convert from infix to postfix
	 * This test should succeed in converting the string
	 */
	@Test
	public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(complexInfix);
		assertEquals(complexPostfix, postfixResult);
	}
	
	/**
	 * Intermediate test for if the method can convert from infix to postfix
	 * This test should succeed in converting the string
	 */
	@Test
	public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(intermediateInfix);
		assertEquals(intermediatePostfix, postfixResult);
	}
	
	/**
	 * Easy test for if the method can convert from infix to postfix
	 * This test should succeed in converting the string
	 */
	@Test
	public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
		String postfixResult = Notation.convertInfixToPostfix(easyInfix);
		assertEquals(easyPostfix, postfixResult);
	}
	
	/**
	 * Tests if the method can correctly throw an InvalidNotationFormatException
	 * This test should throw an InvalidNotationFormatExpression
	 */
	@Test
	public void testInvalidInfixExpression() {
		try{
			Notation.convertInfixToPostfix(invalidInfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	/**
	 * Complex test for if the method can convert from postfix to infix
	 * This test should succeed in converting the string
	 */
	@Test
	public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostfixToInfix(complexPostfix);
		assertEquals(complexInfix, infixResult);
	}
	
	/**
	 * Intermediate test for if the method can convert from postfix to infix
	 * This test should succeed in converting the string
	 */
	@Test
	public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostfixToInfix(intermediatePostfix);
		assertEquals(intermediateInfix, infixResult);
	}
	
	/**
	 * Easy test for if the method can convert from postfix to infix
	 * This test should succeed in converting the string
	 */
	@Test
	public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException {
		String infixResult = Notation.convertPostfixToInfix(easyPostfix);
		assertEquals(easyInfix, infixResult);
	}

	/**
	 * Tests if the method can correctly throw an InvalidNotationFormatException
	 * This test should throw an InvalidNotationFormatExpression
	 */
	@Test
	public void testInvalidPostfixExpressionB() {
		try{
			Notation.convertPostfixToInfix(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
	
	/**
	 * Complex test for if the method can evaluate a postfix expression
	 * This test should succeed in evaluating the string
	 */
	@Test
	public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfixExpression(complexPostfix);
		assertEquals(evalComplexPostfix, result, .001);
	}
	
	/**
	 * Intermediate test for if the method can evaluate a postfix expression
	 * This test should succeed in evaluating the string
	 */
	@Test
	public void testIntermediateEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfixExpression(intermediatePostfix);
		assertEquals(evalIntermediatePostfix, result, .001);
	}
	
	/**
	 * Easy test for if the method can evaluate a postfix expression
	 * This test should succeed in evaluating the string
	 */
	@Test
	public void testEasyEvaluatePostfixExpression() throws InvalidNotationFormatException {
		double result = Notation.evaluatePostfixExpression(easyPostfix);
		assertEquals(evalEasyPostfix, result, .001);
	}
	
	/**
	 * Tests if the method can correctly throw an InvalidNotationFormatException
	 * This test should throw an InvalidNotationFormatExpression
	 */
	@Test
	public void testInvalidPostfixExpressionA() {
		try{
			Notation.evaluatePostfixExpression(invalidPostfixExpression);
			assertTrue("This should have thrown an InvalidNotationFormatException",false);
		}
		catch (InvalidNotationFormatException e)
		{
			assertTrue("This should have thrown an InvalidNotationFormatException",true);
		}
	}
}