import java.util.ArrayList;
import java.util.Collections;
/**
 * Manager structure that holds a Graph object
 * @author Sai Abhishek Gangineni
 *
 */
public class TownGraphManager implements TownGraphManagerInterface {
	private Graph townMap;
	
	/**
	 * Constructs a TownGraphManager
	 */
	public TownGraphManager() {
		townMap = new Graph();
	}
	
	@Override
	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		townMap.addEdge(source, destination, weight, roadName);
		return true;
	}

	@Override
	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	public String getRoad(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		Road output = townMap.getEdge(source, destination);
		return output.getName();
	}

	@Override
	/**
	 * Adds a town to the graph
	 * @param v the town's name 
	 * @return true if the town was successfully added, false if not
	 */
	public boolean addTown(String v) {
		Town newTown = new Town(v);
		return townMap.addVertex(newTown);
	}

	@Override
	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	public Town getTown(String name) {
		return townMap.getVertex(name);
	}

	@Override
	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	public boolean containsTown(String v) {
		Town place = new Town(v);
		return townMap.containsVertex(place);
	}

	@Override
	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1
	 * @param town2 name of town 2
	 * @return true if the road is in the graph, false if not
	 */
	public boolean containsRoadConnection(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		return townMap.containsEdge(source, destination);
	}

	@Override
	/**
	 * Creates a sorted arraylist of all road titles
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<String>();
		for (Road r : townMap.edgeSet()) {
			roads.add(r.getName());
		}
		Collections.sort(roads);
		return roads;
	}

	@Override
	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 
	 * @param town2 name of town 2 
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		Road removed = townMap.getEdge(source, destination);
		Road test = townMap.removeEdge(source, destination, removed.getWeight(), road);
		return (test != null);
	}

	@Override
	/**
	 * Deletes a town from the graph
	 * @param v name of town 
	 * @return true if the town was successfully deleted, false if not
	 */
	public boolean deleteTown(String v) {
		Town removed = new Town(v);
		return townMap.removeVertex(removed);
	}

	@Override
	/**
	 * Creates a sorted arraylist of all towns 
	 * @return an arraylist of all towns in alphabetical order 
	 */
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<String>();
		for (Town t : townMap.vertexSet()) {
			towns.add(t.getName());
		}
		Collections.sort(towns);
		return towns;
	}

	@Override
	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 
	 * @param town2 name of town 2
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	public ArrayList<String> getPath(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		return townMap.shortestPath(source, destination);
	}

}
