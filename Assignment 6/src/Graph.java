import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/**
 * Graph structure that holds towns and roads that connect them
 * Implements GraphInterface 
 * @author Sai Abhishek Gangineni
 *
 */
public class Graph implements GraphInterface<Town, Road> {
	private Set<Town> towns;
	private Set<Road> roads;
	private Map<String, Town> prevVertex;
	
	/**
	 * Default Constructor for Graph class
	 */
	public Graph() {
		towns = new HashSet<Town>();
		roads = new HashSet<Road>();
		prevVertex = new HashMap<String, Town>();
	}
	
	@Override
	/**
	 * Returns a road from Graph if it exists
	 * Otherwise, it returns null
	 * @param sourceVertex the first town on the road
	 * @param destinationVertex the second town on the road
	 * @return the edge if found, otherwise null
	 */
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for (Road r : roads) {
			if ((sourceVertex.equals(r.getSource()) || sourceVertex.equals(r.getDestination())) && 
					(destinationVertex.equals(r.getDestination()) || destinationVertex.equals(r.getSource()))) {
				return r;
			}
		}
		return null;
	}
	
	/**
	 * Returns a town from Graph based on name
	 * @param name the name of the town
	 * @return the town if found, otherwise null
	 */
	public Town getVertex(String name) {
		for (Town t : towns) {
			if (t.getName().equals(name)) {
				return t;
			}
		}
		return null;
	}

	@Override
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
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
	 /**
     * Adds the specified vertex to this graph if not already present. 
     * @param v vertex to be added to this graph.
     * @return true if this graph did not already contain the specified vertex.
     * @throws NullPointerException if the specified vertex is null.
     */
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
	/**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex.
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @return true if this graph contains the specified edge.
     */
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
	/**
     * Returns true if this graph contains the specified vertex
     * @param v vertex whose presence in this graph is to be tested.
     * @return true if this graph contains the specified vertex.
     */
	public boolean containsVertex(Town v) {
		for (Town t : towns) {
			if (t.equals(v)) {
				return true;
			}
		}
		return false;
	}

	@Override
	/**
     * Returns a set of the edges contained in this graph.
     * @return a set of the edges contained in this graph.
     */
	public Set<Road> edgeSet() {
		return roads;
	}

	@Override
	/**
     * Returns a set of all edges touching the specified vertex
     * If no edges are touching the specified vertex returns an empty set.
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     * @return a set of all edges touching the specified vertex.
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
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
	/**
     * Removes an edge going from source vertex to target vertex, if such vertices and such edge exist in this graph. 
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     * @return The removed edge, or null if no edge removed.
     */
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
	 /**
     * Removes the specified vertex from this graph including all its touching edges if present.
     * @param v vertex to be removed from this graph, if present.
     * @return true if the graph contained the specified vertex, false otherwise.
     */
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
	/**
     * Returns a set of the vertices contained in this graph.
     * @return a set view of the vertices contained in this graph.
     */
	public Set<Town> vertexSet() {
		return towns;
	}

	@Override
	/**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     */   
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
	/**
     * Dijkstra's Shortest Path Method.
     * @param sourceVertex the vertex to find shortest path from
     */
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
