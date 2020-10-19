package IDAStarS;

import Graph.Node;

public class Main {

	public static void main(String[] args) {
		IDAStarS bfs = new IDAStarS();
		Node n1 = new Node("Arad", 366);
		Node n2 = new Node("Bucharest", 0);
		Node n3 = new Node("Craiova", 160);
		Node n4 = new Node("Drobeta", 242);
		Node n5 = new Node("Fagaras", 176);
		Node n6 = new Node("Lugoj", 244);
		Node n7 = new Node("Mehadia", 241);
		Node n8 = new Node("Oradea", 380);
		Node n9 = new Node("Pitesti", 100);
		Node n10 = new Node("Ramnicu Vilcea", 193);
		Node n11 = new Node("Sibiu", 253);
		Node n12 = new Node("Timisoara", 329);
		Node n13 = new Node("Zerind", 374);
		n1.add(n12, 118.0);
		n1.add(n11, 140.0);
		n1.add(n13, 75.0);
		n13.add(n1, 75.0);
		n13.add(n8, 71.0);
		n8.add(n13, 71.0);
		n8.add(n11, 151.0);
		n11.add(n1, 140.0);
		n11.add(n5, 99.0);
		n11.add(n10, 80.0);
		n11.add(n8, 151.0);
		n5.add(n11, 99.0);
		n5.add(n2, 271.0);
		n10.add(n11, 80.0);
		n10.add(n3, 145.0);
		n10.add(n9, 97.0);
		n9.add(n2, 101.0);
		n9.add(n10, 97.0);
		n9.add(n3, 138.0);
		n12.add(n1, 118.0);
		n12.add(n6, 111.0);
		n6.add(n12, 111.0);
		n6.add(n7, 70.0);
		n7.add(n6, 70.0);
		n7.add(n4, 75.0);
		n4.add(n7, 75.0);
		n4.add(n3, 120.0);
		n3.add(n4, 120.0);
		n3.add(n10, 145.0);
		n3.add(n9, 138.0);
		if (!bfs.search(n1)) {
			System.out.println("NOT FOUND!");
		}
	}
}
