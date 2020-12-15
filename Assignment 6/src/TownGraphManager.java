import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface {
	private Graph townMap;
	
	public TownGraphManager() {
		townMap = new Graph();
	}
	
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		townMap.addEdge(source, destination, weight, roadName);
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		Road output = townMap.getEdge(source, destination);
		return output.getName();
	}

	@Override
	public boolean addTown(String v) {
		Town newTown = new Town(v);
		return townMap.addVertex(newTown);
	}

	@Override
	public Town getTown(String name) {
		return townMap.getVertex(name);
	}

	@Override
	public boolean containsTown(String v) {
		Town place = new Town(v);
		return townMap.containsVertex(place);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		return townMap.containsEdge(source, destination);
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> roads = new ArrayList<String>();
		for (Road r : townMap.edgeSet()) {
			roads.add(r.getName());
		}
		Collections.sort(roads);
		return roads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		Road removed = townMap.getEdge(source, destination);
		Road test = townMap.removeEdge(source, destination, removed.getWeight(), road);
		return (test != null);
	}

	@Override
	public boolean deleteTown(String v) {
		Town removed = new Town(v);
		return townMap.removeVertex(removed);
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> towns = new ArrayList<String>();
		for (Town t : townMap.vertexSet()) {
			towns.add(t.getName());
		}
		Collections.sort(towns);
		return towns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		Town source = new Town(town1);
		Town destination = new Town(town2);
		return townMap.shortestPath(source, destination);
	}

}
