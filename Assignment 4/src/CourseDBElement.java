/**
 * This is the Data Element class of the database of courses
 * @author Sai Abhishek Gangineni
 *
 */
public class CourseDBElement implements Comparable{
	private String courseID, roomNum, instructor;
	private int crn, credits;
	
	/**
	 * Constructs an empty data element
	 */
	public CourseDBElement() {
		courseID = null;
		roomNum = null;
		instructor = null;
		crn = 0;
		credits = 0;
	}
	
	/**
	 * Constructs a data element with the relevant course information
	 * @param id the Course ID of the class
	 * @param inCRN the unique CRN code of the class
	 * @param numCred the number of credits the class is worth
	 * @param room the room number of the class
	 * @param teacher the instructor of the class
	 */
	public CourseDBElement(String id, int inCRN, int numCred, String room, String teacher) {
		courseID = id;
		crn = inCRN;
		credits = numCred;
		roomNum = room;
		instructor = teacher;
	}
	
	/**
	 * Returns the CRN code of the class 
	 * @return the unique CRN code
	 */
	public int getCRN() {
		return crn;
	}
	
	/**
	 * Sets the CRN code of the class to the given code number
	 * @param input the CRN code that the class should be set to
	 */
	public void setCRN(int input) {
		crn = input;
	}
	
	/**
	 * Returns the hashCode of the data element
	 * Based on the hashCode of the CRN code as a string
	 * @return the hashCode of the data element
	 */
	public int hashCode() {
		String code = Integer.toString(crn);
		return code.hashCode();
	}
	
	/**
	 * Compares two course database elements and returns an int
	 * Negative int if current CRN is smaller than parameter CRN
	 * Positive int if current CRN is bigger than parameter CRN
	 * 0 if both CRN codes are equal
	 * @param element the element to be compared with
	 * @return an integer representing the comparison
	 */
	@Override
	public int compareTo(CourseDBElement element) {
		return this.compareTo(element);
	}
	
	/**
	 * Converts the data element to a String object
	 * @return the element as a string
	 */
	public String toString() {
		return "\nCourse:"+courseID+" CRN:"+crn+" Credits:"+credits+" Instructor:"+instructor+" Room:"+roomNum;
	}

}
