import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Utility class for methods behind the Password Checker
 * @author Sai Abhishek Gangineni
 */
public class PasswordCheckerUtility {
	
	/**
	 * Compares equality of two passwords
	 * @param password the string to be checked 
	 * @param passwordConfirm the string to be checked against password 
	 * @throws UnmatchedException thrown if not same password (case-sensitive)
	 */
	public static void comparePasswords(String password, String passwordConfirm) throws UnmatchedException {
		if (!password.equals(passwordConfirm)) {
			throw new UnmatchedException();
		}
	}
	
	/**
	 * Compares equality of two passwords
	 * @param password the string to be checked 
	 * @param passwordConfirm the string to be checked against password 
	 * @return true if both same password (case-sensitive)
	 */
	public static boolean comparePasswordsWithReturn(String password, String passwordConfirm) {
		return password.equals(passwordConfirm);
	}
	
	/**
	 * Checks if password length is between 6 and 9 characters
	 * @param password the string to be checked for length
	 * @return true if password has 6 to 9 characters
	 */
	public static boolean hasBetweenSixAndNineChars(String password) {
		if (password.length() >= 6 && password.length() <= 9) {
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * Checks if password contains at least 1 digit
	 * @param password the string to be checked for digits
	 * @return true if contains a digit
	 * @throws NoDigitException thrown if it doesn't meet digit requirement
	 */
	public static boolean hasDigit(String password) throws NoDigitException {
		char[] chars = password.toCharArray();
		for (char c : chars) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		throw new NoDigitException();
	}
	
	/**
	 * Checks if password contains at least 1 lowercase character
	 * @param password the string to be checked for lowercase characters
	 * @return true if contains a lowercase character
	 * @throws NoLowerAlphaException throws if it doesn't meet lowercase character requirement
	 */
	public static boolean hasLowerAlpha(String password) throws NoLowerAlphaException {
		char[] chars = password.toCharArray();
		for (char c : chars) {
			if (Character.isLowerCase(c)) {
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	/**
	 * Checks if password contains at least 1 uppercase character
	 * @param password the string to be checked for uppercase characters
	 * @return true if contains a uppercase character
	 * @throws NoUpperAlphaException throws if it doesn't meet uppercase character requirement
	 */
	public static boolean hasUpperAlpha(String password) throws NoUpperAlphaException {
		char[] chars = password.toCharArray();
		for (char c : chars) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	/**
	 * Checks if password contains more than 2 characters in sequence
	 * @param password the string to be checked for sequences
	 * @return true if it doesn't contain more than 2 characters in sequence
	 * @throws InvalidSequenceException throws if it doesn't meet sequence requirement
	 */
	public static boolean hasSameCharInSequence(String password) throws InvalidSequenceException {
		char[] chars = password.toCharArray();
		for (int i = 0; i < chars.length-2; i++) {
			if (chars[i]==chars[i+1] && chars[i+1]==chars[i+2]) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	/**
	 * Checks if password contains at least 1 special character
	 * @param password the string to be checked for special characters
	 * @return true if it contains at least 1 special character
	 * @throws NoSpecialCharacterException throws if it doesn't meet special character requirement
	 */
	public static boolean hasSpecialChar(String password) throws NoSpecialCharacterException {
		Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
		Matcher matcher = pattern.matcher(password);
		if (!matcher.matches()) {
			return true;
		}else {
			throw new NoSpecialCharacterException();
		}
	}
	
	/**
	 * Checks if password at least 6 characters
	 * @param password the string to be checked for length
	 * @return true if string has at least 6 characters
	 * @throws LengthException throws if it doesn't meet length requirements
	 */
	public static boolean isValidLength(String password) throws LengthException {
		if (password.length() >= 6) {
			return true;
		}else {
			throw new LengthException();
		}
	}
	
	/**
	 * Checks if password meets all requirements
	 * @param password the string to be checked
	 * @return true if it fulfills all requirements
	 * @throws LengthException thrown if length is less than 6 characters
	 * @throws NoUpperAlphaException thrown if it contains no uppercase characters
	 * @throws NoLowerAlphaException thrown if it contains no lowercase characters
	 * @throws NoDigitException thrown if it contains no digits
	 * @throws NoSpecialCharacterException thrown if it contains no special characters
	 * @throws InvalidSequenceException thrown if it has more than 2 of the same character in sequence
	 */
	public static boolean isValidPassword(String password) throws LengthException, NoUpperAlphaException, NoLowerAlphaException, NoDigitException, NoSpecialCharacterException, InvalidSequenceException  {
		isValidLength(password);
		hasUpperAlpha(password);
		hasLowerAlpha(password);
		hasDigit(password);
		hasSpecialChar(password);
		hasSameCharInSequence(password);
		return true;
	}
	
	/**
	 * Checks if password is valid but between 6 and 9 characters
	 * @return false if password length is not from 6 to 9 characters
	 * @throws WeakPasswordException throws if it is a weak password
	 */
	public static boolean isWeakPassword(String password) throws WeakPasswordException {
		try {
			isValidPassword(password);
		}
		catch(LengthException e) {
			System.out.println(e.getMessage());
		}
		catch(NoUpperAlphaException e) {
			System.out.println(e.getMessage());
		}
		catch(NoLowerAlphaException e) {
			System.out.println(e.getMessage());
		}
		catch(NoDigitException e) {
			System.out.println(e.getMessage());
		}
		catch(NoSpecialCharacterException e) {
			System.out.println(e.getMessage());
		}
		catch(InvalidSequenceException e) {
			System.out.println(e.getMessage());
		}
		if(hasBetweenSixAndNineChars(password)) {
			throw new WeakPasswordException();
		}
		return false;
	}
	
	/**
	 * Reads a file of passwords and returns a list of the invalid passwords with the reason why it is invalid
	 * @param passwords the file of passwords to be checked
	 * @return invalidPasswords an ArrayList of invalid passwords with the reason
	 */
	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords){
		ArrayList<String> output = new ArrayList<String>();
		for (String s : passwords) {
			try {
				isValidPassword(s);
			}
			catch(LengthException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoUpperAlphaException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoLowerAlphaException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoDigitException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(NoSpecialCharacterException e) {
				output.add(s+" -> "+e.getMessage());
			}
			catch(InvalidSequenceException e) {
				output.add(s+" -> "+e.getMessage());
			}
		}
		return output;
	}
}
