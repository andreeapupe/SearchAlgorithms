package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


// General functions

public class Node {
	private ArrayList<Node> child = new ArrayList<Node>();

	private String id;
	private boolean visited = false;
	private double heuristic;
	private double distance = 0;

	public Node(String id) {
		this.id = id;
	}

	public Node(String id, double heuristic) {
		this.id = id;
		this.heuristic = heuristic;
	}

	public void add(Map<Node, Double> map) {
		childWithDistance.putAll(map);
	}

	public void add(Node n) {
		child.add(n);
	}

	public ArrayList<Node> getChild() {
		return child;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public String toString() {
		return id;
	}

	public double getHeuristic() {
		return heuristic;
	}

	public void setHeuristic(double heuristic) {
		this.heuristic = heuristic;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void add(Node node, Double distance) {
		this.child.add(node);
		childWithDistance.put(node, distance);
	}

	public double getDistancePlusHeuristic() {
		return (this.distance + this.heuristic);
	}

	public Map<Node, Double> getChildWithDistance() {
		return childWithDistance;
	}
	
	//remember node value and node key
	private Map<Node, Double> childWithDistance = new HashMap<Node, Double>();

}
