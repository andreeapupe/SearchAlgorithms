package AStar;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import Graph.Node;
import Graph.Tree2;

public class AStar {
	private ArrayList<Node> extended = new ArrayList<Node>();
	private Tree2 tree = new Tree2();
	boolean found = false;

	public boolean search(Node root) {
		Map<Node, Double> children = root.getChildWithDistance();

		System.out.println("Current root: " + root);

		for (Entry<Node, Double> entry : children.entrySet()) {
			Node key = entry.getKey();
			tree.add(root.toString(), key.toString());
		}

		extended.remove(root);
		for (Entry<Node, Double> entry : children.entrySet()) {
			Node key = entry.getKey();
			Double value = entry.getValue();
			Node newNode = new Node(key.toString(), key.getHeuristic());
			newNode.add(key.getChildWithDistance());
			newNode.setDistance(root.getDistance() + value);
			extended.add(newNode);
		}

		System.out.print("\n" + "Extended nodes: ");
		for (Node n : extended) {
			System.out.print("\n");
			System.out.print(n);
			System.out.print(" - ");
			System.out.print(n.getDistancePlusHeuristic() + " = ");
			System.out.print(n.getDistance() + " + ");
			System.out.print(n.getHeuristic() + " ");
		}

		System.out.println();
		System.out.println("-----------------------------------------");
		Node nextRoot = findSmallest(extended);
		if (nextRoot.getHeuristic() == 0 && theSmallest(nextRoot, extended)) {
			System.out.println("found " + nextRoot);
			found = true;
			return found;
		} else {
			search(nextRoot);
		}
		return found;
	}

	private boolean theSmallest(Node nextRoot, ArrayList<Node> nodes) {
		Node smallest = nodes.get(0);
		for (Node n : nodes) {
			if (n.getDistancePlusHeuristic() < smallest.getDistancePlusHeuristic()) {
				smallest = n;
			}
		}
		return (smallest.getDistancePlusHeuristic() == nextRoot.getDistancePlusHeuristic());
	}

	private Node findSmallest(ArrayList<Node> nodes) {
		Node smallest = nodes.get(0);
		for (Node n : nodes) {
			if (n.getDistancePlusHeuristic() < smallest.getDistancePlusHeuristic()) {
				smallest = n;
			}
		}
		return smallest;
	}

}
