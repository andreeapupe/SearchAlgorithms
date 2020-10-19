package BFSearch;

import java.util.ArrayList;

import Graph.Graphic;
import Graph.Node;

public class BFS {
	private ArrayList<Node> queue = new ArrayList<Node>();
	private Graphic graphic = new Graphic();
	boolean found = false;
	int position = 0;

	public boolean search(Node root, Node toFind) {
		ArrayList<Node> childs = root.getChild();
		position++;

		System.out.println("Position #" + position+ " - current root: " + root );	
		for(Node node : childs) {
			graphic.add(root.toString(),node.toString(),position);
			if(node.toString().equals(toFind.toString())) {
				found = true;
				System.out.println("Found!");
				break;
			}
			System.out.println("Child: " + node.toString());
			
			if(!node.isVisited()) {
				queue.add(node);
			}
			
			node.setVisited(true);
		}
		queue.remove(root);

		if(!queue.isEmpty() && !found){ 
			System.out.println("Queue: " + queue);
			graphic.getG();
			search(queue.get(0),toFind);
		}

		return found;
	}
}