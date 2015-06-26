package pucrs.alpro3.graph;

import java.util.Arrays;

public class PrimApp {
	public static void main(String[] args) {
		AbstractGraph g = new UndirectedGraphMatrix();
		System.out.println(g);
		g.addVertice("A");
		g.addVertice("B");
		g.addVertice("C");
		g.addVertice("D");
		
		g.addEdge("A", "B", 5);
		g.addEdge("A", "D", 10);
		g.addEdge("A", "C", 5);
		g.addEdge("B", "C", 5);
		g.addEdge("B", "D", 5);
		g.addEdge("C", "D", 10);
		
		System.out.println(g);
		
		System.out.println(g.prim("A"));

	}


}
