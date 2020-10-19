package DFS;

import java.util.ArrayList;

import Graph.Graphic;
import Graph.Node;

public class DFS {
	private Graphic graphic = new Graphic();
	int position = 0;
	boolean found = false;
	ArrayList<Node> stack = new ArrayList<Node>();

	public boolean search(Node root, Node toFind) {
		ArrayList<Node> childs = root.getChild();
		stack.add(root);
		position++;
		root.setVisited(true);
		System.out.println("position #" + position + " root " + root);
		System.out.println("stack " + stack);
		if ((root.toString()).equals(toFind.toString())) {
			System.out.println("Found!" + "\n");
			found = true;
		}

		while (childs.size() != 0 && !found) {
			//
			graphic.add(root.toString(), childs.get(0).toString(), position);
			System.out.println("Child " + childs.get(0));
			graphic.getG();
			//

			Node nodeNext = childs.get(0);
			childs.remove(0);
			if (!nodeNext.isVisited())
				search(nodeNext, toFind);
		}
		stack.remove(root);
		System.out.println("Stack " + stack);
		return found;
	}
}