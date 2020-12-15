import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road> {
	private Set<Town> towns;
	private Set<Road> roads;
	private Map<String, Town> prevVertex;
	
	public Graph() {
		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
		prevVertex = new HashMap<String, Town>();
	}
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for (Road r : roads) {
			if ((sourceVertex.equals(r.getSource()) || sourceVertex.equals(r.getDestination())) && 
					(destinationVertex.equals(r.getDestination()) || destinationVertex.equals(r.getSource()))) {
				return r;
			}
		}
		return null;
	}
	
	public Town getVertex(String name) {
		for (Town t : towns) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex==null || destinationVertex==null) {
			throw new NullPointerException();
		}
		if (!containsVertex(sourceVertex) || !containsVertex(destinationVertex)) {
			throw new IllegalArgumentException();
		}
		if (containsEdge(sourceVertex, destinationVertex)) {
			return null;
		}
		Road newRoad = new Road(sourceVertex, destinationVertex, weight, description);
		roads.add(newRoad);
		return newRoad;
	}

	@Override
	public boolean addVertex(Town v) {
		if (v == null) {
			throw new NullPointerException();
		}
		if (containsVertex(v)) {
			return false;
		}
		towns.add(v);
		return true;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for (Road r : roads) {
			if ((sourceVertex.equals(r.getSource()) || sourceVertex.equals(r.getDestination())) && 
					(destinationVertex.equals(r.getSource()) || destinationVertex.equals(r.getDestination()))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for (Town t : towns) {
			if (t.equals(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> output = new HashSet<Road>();
		if (vertex==null) {
			throw new NullPointerException();
		}
		if (!containsVertex(vertex)) {
			throw new IllegalArgumentException();
		}
		for (Road r : roads) {
			if (r.getSource().equals(vertex) || r.getDestination().equals(vertex)) {
				output.add(r);
			}
		}
		return output;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road removedRoad = new Road(sourceVertex, destinationVertex, weight, description);
		for (Road r : roads) {
			if (r.equals(removedRoad)) {
				roads.remove(r);
				return removedRoad;
			}
		}
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		for (Town t : towns) {
			if (t.equals(v)) {
				Set<Road> edges = edgesOf(t);
				for (Road r : edges) {
					roads.remove(r);
				}
				towns.remove(t);
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> output = new ArrayList<String>();
		dijkstraShortestPath(sourceVertex);
		Town next = destinationVertex;
		while (!next.equals(sourceVertex)) {
			if (!prevVertex.containsKey(next.getName())) {
				output.clear();
				break;
			}
			Town prevTown = prevVertex.get(next.getName());
			Road edge = getEdge(prevTown, next);
			output.add(0, prevTown.getName() + " via " + edge.getName() + " to " + next.getName() + " " + edge.getWeight());
			next = prevTown;
		}
		return output;
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		Set<Town> settled = new HashSet<Town>();
		ArrayList<Town> unsettled = new ArrayList<Town>();
		HashMap<String, Integer> distance = new HashMap<String, Integer>();
		prevVertex.clear();
		for (Town t : towns) {
			unsettled.add(t);
			distance.put(t.getName(), Integer.MAX_VALUE);
			prevVertex.put(t.getName(), null);
		}
		distance.put(sourceVertex.getName(), 0);
		while (!unsettled.isEmpty()) {
			int shortest = 0;
			for (int i = 0; i < unsettled.size(); i++) {
				Town unsetVertex = unsettled.get(i);
				if (distance.get(unsettled.get(shortest).getName()) > distance.get(unsetVertex)){
					shortest = i;
				}
			}
			Town closestTown = unsettled.remove(shortest);
			settled.add(closestTown);
			if (distance.get(closestTown.getName())==Integer.MAX_VALUE) {
				return;
			}
			for (Road r : edgesOf(closestTown)) {
				Town adjacent = r.getDestination();
				if (adjacent.equals(closestTown)) {
					adjacent = r.getSource();
				}
				if (settled.contains(adjacent)) {
					continue;
				}
				int adjDist = distance.get(closestTown.getName()) + r.getWeight();
				if (adjDist < distance.get(adjacent.getName())) {
					distance.put(adjacent.getName(), adjDist);
					prevVertex.put(adjacent.getName(), closestTown);
				}
			}
		}
	}

}
