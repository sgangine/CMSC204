import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * This is the Data Manager class of the courses database
 * @author Sai Abhishek Gangineni
 *
 */
public class CourseDBManager implements CourseDBManagerInterface {
	private CourseDBStructure database = new CourseDBStructure(20);
	
	/**
	 * Adds a course to the database with the given parameters
	 * @param id the Course ID of the class to be added
	 * @param crn the CRN code of the course
	 * @param credits the amount of credits the course is worth
	 * @param roomNum the room number the class is located in
	 * @param instructor the teacher of the course
	 */
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		CourseDBElement element = new CourseDBElement(id, crn, credits, roomNum, instructor);
		database.add(element);
	}

	/**
	 * Returns the course from the database according to the given CRN code
	 * @param crn the CRN code of the course to be returned
	 * @return the class specified by the parameter
	 */
	@Override
	public CourseDBElement get(int crn) {
		try {
			return database.get(crn);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Reads an input file of courses and adds them to the database
	 * @param input the text file of courses to be added
	 * @throws FileNotFoundException thrown if input file does not exist
	 */
	@Override
	public void readFile(File input) throws FileNotFoundException {
		Scanner sc = new Scanner(input);
		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			String[] lineArray = line.split(" ");
			int size = lineArray.length;
			boolean middleName = false;
			String courseID = lineArray[0];
			int crn = Integer.parseInt(lineArray[1]);
			int credits = Integer.parseInt(lineArray[2]);
			for (int i = 0; i < lineArray.length; i++) {
				if (lineArray[i].charAt(lineArray[i].length()-1)=='.' && lineArray[i].length()==2) {
					middleName = true;
				}
			}
			if (!middleName) {
				String roomNum = "";
				for (int i = 3; i < size-2; i++) {
					roomNum += lineArray[i];
				}
				String teacher = lineArray[size-2] + lineArray[size-1];
				this.add(courseID, crn, credits, roomNum, teacher);
			}else {
				String roomNum = "";
				for (int i = 3; i < size-3; i++) {
					roomNum += lineArray[i];
				}
				String teacher = lineArray[size-3] + lineArray[size-2] + lineArray[size-1];
				this.add(courseID, crn, credits, roomNum, teacher);
			}
		}
		
	}

	/**
	 * Displays all the courses in the database
	 * @return the courses in an ArrayList of Strings
	 */
	@Override
	public ArrayList<String> showAll() {
		ArrayList<String> output = new ArrayList<String>();
		for (LinkedList<CourseDBElement> list : database.hashTable) {
			if(list != null) {
				for (int i = 0; i < list.size(); i++) {
					String course = list.get(i).toString();
					output.add(course);
				}
			}
		}
		return output;
	}

}
