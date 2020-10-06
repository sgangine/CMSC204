
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.function.Executable;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author Sai Abhishek Gangineni
 *
 */
public class PasswordCheckerSTUDENT_Test {
	ArrayList<String> invalidPasswordsArray;
	String allCaps = "WELCOME";
	String allLower = "welcome";
	String strongPass = "1@mLegendary";
	String weakPass = "1@mLegend";
	String inSeq = "AAApple";
	
	@Before
	public void setUp() throws Exception {
		invalidPasswordsArray = new ArrayList<String>();
		String[] input = {"G0g4e@n", "apple", "C@1culator", "3940192a"};
		invalidPasswordsArray.addAll(Arrays.asList(input));
	}

	@After
	public void tearDown() throws Exception {
		invalidPasswordsArray = null;
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidLength("aksjdh"));
		}catch(LengthException e) {
			e.printStackTrace();
		}
		Throwable exception = Assertions.assertThrows(LengthException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isValidLength("world");
			}			
		});
		assertEquals("The password must be at least 6 characters long", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasUpperAlpha("World"));
		}catch(NoUpperAlphaException e) {
			e.printStackTrace();
		}
		Throwable exception = Assertions.assertThrows(NoUpperAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasUpperAlpha(allLower);
			}			
		});
		assertEquals("The password must contain at least one uppercase alphabetic character", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasLowerAlpha("World"));
		}catch(NoLowerAlphaException e) {
			e.printStackTrace();
		}
		Throwable exception = Assertions.assertThrows(NoLowerAlphaException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasLowerAlpha(allCaps);
			}			
		});
		assertEquals("The password must contain at least one lower case alphabetic character", exception.getMessage());
	}
	/**
	 * Test if the password is valid and has between 6 and 9 characters
	 * This test should throw a WeakPasswordException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
		try {
			assertFalse(PasswordCheckerUtility.isWeakPassword(strongPass));
		}catch(WeakPasswordException e) {
			e.printStackTrace();
		}
		Throwable exception = Assertions.assertThrows(WeakPasswordException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.isWeakPassword(weakPass);
			}			
		});
		assertEquals("The password is OK but weak - it contains fewer than 10 characters.", exception.getMessage());
	}
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasSameCharInSequence(strongPass));
		}catch(InvalidSequenceException e) {
			e.printStackTrace();
		}
		Throwable exception = Assertions.assertThrows(InvalidSequenceException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasSameCharInSequence(inSeq);
			}			
		});
		assertEquals("The password cannot contain more than two of the same character in sequence", exception.getMessage());
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit()
	{
		try {
			assertTrue(PasswordCheckerUtility.hasDigit(strongPass));
		}catch(NoDigitException e) {
			e.printStackTrace();
		}
		Throwable exception = Assertions.assertThrows(NoDigitException.class, new Executable() {
			@Override
			public void execute() throws Throwable {
				PasswordCheckerUtility.hasDigit(allCaps);
			}			
		});
		assertEquals("The password must contain at least one digit", exception.getMessage());
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		try {
			assertTrue(PasswordCheckerUtility.isValidPassword(strongPass));
		}
		catch(LengthException e) {
			e.printStackTrace();
		}
		catch(NoUpperAlphaException e) {
			e.printStackTrace();
		}
		catch(NoLowerAlphaException e) {
			e.printStackTrace();
		}
		catch(NoDigitException e) {
			e.printStackTrace();
		}
		catch(NoSpecialCharacterException e) {
			e.printStackTrace();
		}
		catch(InvalidSequenceException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the invalidPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> result = PasswordCheckerUtility.getInvalidPasswords(invalidPasswordsArray);
		assertEquals(result.size(), 2);
		assertEquals(result.get(0), "apple -> The password must be at least 6 characters long");
		assertEquals(result.get(1), "3940192a -> The password must contain at least one uppercase alphabetic character");
	}
	
}