package GreedyBFS;

import java.util.ArrayList;

import Graph.Node;
import Graph.Tree;

public class GBFS {
	private ArrayList<Node> extended = new ArrayList<Node>();
	private Tree tree = new Tree();
	private boolean found = false;

	public boolean search(Node root) {
		ArrayList<Node> childs = root.getChild();
		System.out.println("Current root is " + root + " with heuristic: " + root.getHeuristic());

		for (Node n : childs) {
			tree.add(root.toString(), n.toString(), root.getDistancePlusHeuristic(), n.getDistancePlusHeuristic());
		}

		extended.addAll(childs);
		extended.remove(root);
		System.out.print("\n" + "Extended nodes:"  + "\n");
		for (Node n : extended) {
			System.out.print(n);
			System.out.print(" - ");
			System.out.print(n.getHeuristic() + "\n");
		}
		System.out.println("-----------------------------------------" + "\n");
		Node nextRoot = findSmallestHeuristic(extended);
		if (nextRoot.getHeuristic() == 0) {
			System.out.println("Found " + nextRoot);
			found = true;
			return found;
		} else {
			search(nextRoot);
		}
		return found;
	}

	private Node findSmallestHeuristic(ArrayList<Node> nodes) {
		Node smallest = nodes.get(0);
		for (Node n : nodes) {
			if (n.getHeuristic() < smallest.getHeuristic()) {
				smallest = n;
			}
		}
		return smallest;
	}
}
