package GreedyBFS;

import Graph.Node;

public class Main {

	public static void main(String[] args) {
		GBFS bfs = new GBFS();
		Node n1 = new Node("Arad", 366);
		Node n2 = new Node("Bucharest", 0);
		Node n3 = new Node("Craiova", 160);
		Node n4 = new Node("Drobeta", 242);
		Node n5 = new Node("Fagaras", 176);
		Node n6 = new Node("Lugoj", 244);
		Node n7 = new Node("Mehadia", 241);
		Node n8 = new Node("Oradea", 380);
		Node n9 = new Node("Pitesti", 10);
		Node n10 = new Node("Ramnicu Vilcea", 193);
		Node n11 = new Node("Sibiu", 253);
		Node n12 = new Node("Timisoara", 329);
		Node n13 = new Node("Zerind", 374);
		n1.add(n12);
		n1.add(n11);
		n1.add(n13);
		n13.add(n1);
		n13.add(n8);
		n8.add(n13);
		n8.add(n11);
		n11.add(n1);
		n11.add(n5);
		n11.add(n10);
		n11.add(n8);
		n5.add(n11);
		n5.add(n2);
		n10.add(n11);
		n10.add(n3);
		n10.add(n9);
		n9.add(n2);
		n9.add(n10);
		n9.add(n3);
		n12.add(n1);
		n12.add(n6);
		n6.add(n12);
		n6.add(n7);
		n7.add(n6);
		n7.add(n4);
		n4.add(n7);
		n4.add(n3);
		n3.add(n4);
		n3.add(n10);
		n3.add(n9);
		if (!bfs.search(n1)) {
			System.out.println("NOT FOUND!");
		}
	}
}
