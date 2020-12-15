/**
 * Road class that connects Town objects and implements Comparable interface
 * @author Sai Abhishek Gangineni
 *
 */
public class Road implements Comparable<Road> {
	private Town source, destination;
	private int distance;
	private String name;
	
	/**
	 * Constructs a road object based on parameters
	 * @param source one town on the road 
	 * @param destination the other town on the road
	 * @param degrees the distance from one town to another
	 * @param name the name of the road
	 */
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		distance = degrees;
		this.name = name;
	}
	
	/**
	 * Constructs a road with default distance of 1
	 * @param source one town on the road
	 * @param destination the other town on the road
	 * @param name the name of the road
	 */
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		distance = 1;
	}
	
	/**
	 * Checks if the road contains the given town
	 * @param town the town to be checked
	 * @return true if road has town, false if not
	 */
	public boolean contains(Town town) {
		return (source.equals(town) || destination.equals(town));
	}
	
	/**
	 * toString method for Road object
	 */
	public String toString() {
		return name + "," + distance + ";" + source + ";" + destination;
	}
	
	/**
	 * Returns the name of the road
	 * @return the road's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the second town on the road
	 * @return a town on the road
	 */
	public Town getDestination() {
		return destination;
	}
	
	/**
	 * Returns the first town on the road
	 * @return a town on the road
	 */
	public Town getSource() {
		return source;
	}
	
	/**
	 * Returns the distance of the road
	 * @return the distance of the road
	 */
	public int getWeight() {
		return distance;
	}
	
	/**
	 * Equals method for Road object
	 * @param r the road to be compared with
	 * @return true if ends of road are same (irregardless of order)
	 */
	public boolean equals(Road r) {
		if (this.source.equals(r.getSource()) || this.source.equals(r.getDestination())) {
			if (this.destination.equals(r.getDestination()) || this.destination.equals(r.getSource())) {
				return true;
			}
		}
		return false;
	}
	@Override
	/**
	 * Compares two Road objects based on name
	 */
	public int compareTo(Road o) {
		return this.name.compareTo(o.getName());
	}

}
