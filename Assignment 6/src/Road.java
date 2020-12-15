
public class Road implements Comparable<Road> {
	private Town source, destination;
	private int distance;
	private String name;
	
	public Road(Town source, Town destination, int degrees, String name) {
		this.source = source;
		this.destination = destination;
		distance = degrees;
		this.name = name;
	}
	
	public Road(Town source, Town destination, String name) {
		this.source = source;
		this.destination = destination;
		this.name = name;
		distance = 1;
	}
	
	public boolean contains(Town town) {
		return (source.equals(town) || destination.equals(town));
	}
	
	public String toString() {
		return name + "," + distance + ";" + source + ";" + destination;
	}
	
	public String getName() {
		return name;
	}
	
	public Town getDestination() {
		return destination;
	}
	
	public Town getSource() {
		return source;
	}
	
	public int getWeight() {
		return distance;
	}
	
	public boolean equals(Road r) {
		if (this.source.equals(r.getSource()) || this.source.equals(r.getDestination())) {
			if (this.destination.equals(r.getDestination()) || this.destination.equals(r.getSource())) {
				return true;
			}
		}
		return false;
	}
	@Override
	public int compareTo(Road o) {
		return this.name.compareTo(o.getName());
	}

}
