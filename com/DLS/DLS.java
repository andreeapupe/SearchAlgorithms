package DLS;

import java.util.ArrayList;

import Graph.Graphic;
import Graph.Node;

public class DLS {
	private Graphic graphic = new Graphic();
	int position = 0; // not used yet
	boolean found = false;
	boolean limitPassed = false;
	int count = 0;
	int currentLimit = -1;
	ArrayList<Node> stack = new ArrayList<Node>();

	public boolean search(Node root, Node toFind, int limit) {
		ArrayList<Node> childs = root.getChild();
		stack.add(root);
		root.setVisited(true);
		currentLimit++;
		position++;

		System.out.println("Position #" + position + " - current root: " + root);
		System.out.println("Stack " + stack);
		System.out.println("Current limit: " + currentLimit);
		if ((root.toString()).equals(toFind.toString())) {
			System.out.println("Found!" + "\n");
			found = true;
		}

		while (childs.size() != 0 && !found && currentLimit <= limit) {

			graphic.add(root.toString(), childs.get(0).toString(), position);
			System.out.println("child " + childs.get(0));
			graphic.getG();

			Node nodeNext = childs.get(0);
			childs.remove(0);

			if (!nodeNext.isVisited())
				search(nodeNext, toFind, limit);
		}
		stack.remove(root);
		currentLimit--;
		System.out.println("Stack " + stack + "\n");
		System.out.println("Current limit: " + currentLimit);

		return found;
	}
}