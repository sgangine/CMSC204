import java.util.List;
/**
 * Town class that holds the name of the town and list of adjacent towns
 * Implements Comparable interface
 * @author Sai Abhishek Gangineni
 *
 */
public class Town implements Comparable<Town> {
	private String name;
	private List<Town> adjTowns;
	
	/**
	 * Constructs a town based on given name
	 * @param name the name of the town
	 */
	public Town(String name) {
		this.name = name;
	}
	
	/**
	 * Copy constructor
	 * @param templateTown the town to be copied
	 */
	public Town(Town templateTown) {
		this.name = templateTown.getName();
	}
	
	/**
	 * Returns the name of the town
	 * @return the town's name as a String
	 */
	public String getName() {
		return name;
	}
	
	@Override
	/**
	 * Compares two towns based on name
	 * @return 0 if names are equal, positive/negative if unequal
	 */
	public int compareTo(Town o) {
		return name.compareTo(o.getName());
	}
	
	/**
	 * toString method that prints name of town
	 * @return the name of town
	 */
	public String toString() {
		return name;
	}
	
	/**
	 * HashCode method for Town object
	 * @return the hashCode for the name of the town
	 */
	public int hashCode() {
		return name.hashCode();
	}
	
	/**
	 * Equals method for Town object
	 * @param obj town to be compared with
	 * @return true if names are equal, false if not
	 */
	public boolean equals(Town obj) {
		return this.name.equals(obj.getName());
	}

}
