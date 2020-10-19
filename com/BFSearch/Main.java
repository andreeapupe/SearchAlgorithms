package BFSearch;

import Graph.Node;

public class Main {

	public static void main(String[] args) {
		BFS bfs = new BFS();
		Node n1 = new Node("A");
		Node n2 = new Node("B");
		Node n3 = new Node("C");
		Node n4 = new Node("D");
		Node n5 = new Node("E");
		Node n6 = new Node("F");
		Node n7 = new Node("G");
		Node n8 = new Node("H");
		n1.add(n2);
		n1.add(n3);
		n2.add(n4);
		n3.add(n4);
		n3.add(n5);
		n3.add(n6);
		n4.add(n7);
		n4.add(n8);
		if (!bfs.search(n1, n8)) {
			System.out.println("NOT FOUND!");
		}
	}
}
