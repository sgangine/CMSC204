import java.io.IOException;
import java.util.LinkedList;
/**
 * This is the Data Structure class of the course database
 * @author Sai Abhishek Gangineni
 *
 */
public class CourseDBStructure implements CourseDBStructureInterface{
	protected LinkedList<CourseDBElement>[] hashTable;
	
	/**
	 * Constructs an array of linkedLists of given size to create a hashTable
	 * @param size the size of the constructed data structure
	 */
	public CourseDBStructure(int size) {
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Constructs an array of linkedLists of given size to create a hashTable
	 * Specifically for testing only
	 * @param testing specifies that this data structure is created ony for testing
	 * @param size the size of the constructed data structure
	 */
	public CourseDBStructure(String testing, int size) {
		hashTable = new LinkedList[size];
	}
	
	/**
	 * Adds an element to the hashTable based on its hashCode index
	 * New linkedList is created if index is empty, otherwise added to existing linkedList
	 * @param element the element to be added
	 */
	@Override
	public void add(CourseDBElement element) {
		int index = element.hashCode()%hashTable.length;
		if (hashTable[index] == null) {
			LinkedList<CourseDBElement> input = new LinkedList<CourseDBElement>();
			input.add(element);
			hashTable[index] = input;
		}else {
			hashTable[index].add(element);
		}
	}

	/**
	 * Returns the database element based on the given CRN course code
	 * @param crn the CRN course code to be returned
	 * @return the course from the database based on the CRN
	 * @throws IOException thrown if requested course code is not part of database
	 */
	@Override
	public CourseDBElement get(int crn) throws IOException {
		String code = Integer.toString(crn);
		int index = code.hashCode()%hashTable.length;
		if (hashTable[index]==null) {
			throw new IOException();
		}else {
			for (int i = 0; i < hashTable[index].size(); i++) {
				if (hashTable[index].get(i).getCRN()==crn) {
					return hashTable[index].get(i);
				}
			}
			throw new IOException();
		}
	}

	/**
	 * Returns the number of indexes in the data structure
	 * @return the length of the array of linkedLists
	 */
	@Override
	public int getTableSize() {
		return hashTable.length;
	}

}
