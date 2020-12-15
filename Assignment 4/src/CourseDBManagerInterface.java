

import java.io.*;
import java.util.*;
/**
 * This is the interface of the CourseDBManager class
 * @author ralexander
 *
 */
public interface CourseDBManagerInterface {

	/**
	 * Adds an element to the database according to parameters
	 * First, creates a CourseDBElement based on parameters, then adds it
	 * @param id the Course ID of the class
	 * @param crn the CRN code of the course
	 * @param credits the credits the class is worth
	 * @param roomNum the room number of the course
	 * @param instructor the teacher of the class
	 */
	public void add(String id, int crn, int credits, String roomNum, String instructor);
	
	/**
	 * Returns the specified course
	 * Uses the CourseDBStucture add method
	 * @param crn the CRN code of the course to be retrieved
	 * @return the specified course
	 */
	public CourseDBElement get(int crn);
	
	/**
	 * Reads an text file of courses and adds them to a database
	 * @param input the text file of courses to be read
	 * @throws FileNotFoundException thrown if file does not exist
	 */
	public void readFile(File input) throws FileNotFoundException;

	/**
	 * Displays all courses in database
	 * @return the courses as an ArrayList of Strings 
	 */
	public ArrayList<String> showAll();

}