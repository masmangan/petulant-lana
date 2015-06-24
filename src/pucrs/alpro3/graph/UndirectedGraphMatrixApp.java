package pucrs.alpro3.graph;

import java.util.Arrays;

public class UndirectedGraphMatrixApp {
	public static void main(String[] args) {
		AbstractGraph g = new UndirectedGraphMatrix();
		System.out.println(g);
		g.addVertice("POA");
		g.addVertice("FLP");
		g.addVertice("CWB");
		g.addVertice("SDU");
		g.addVertice("GRU");
		g.addVertice("BHA");

		g.addEdge("POA", "CWB", 15);
		g.addEdge("POA", "FLP", 10);
		g.addEdge("CWB", "SDU", 7);
		g.addEdge("CWB", "GRU", 8);
		g.addEdge("GRU", "BHA", 25);
		
		//
		System.out.println(g);
		
//		System.out.println(g.getTraversalWidth("POA"));
//		System.out.println(g.getTraversalWidth("CWB"));		
//		
//		System.out.println(g.getTraversalDepth("POA"));
//		System.out.println(g.getTraversalDepth("CWB"));
		int d[][] = g.assp();
		for (int[] line : d) {
			System.out.println(Arrays.toString(line));
		}
		
		System.out.println(Arrays.toString(g.sssp("BHA")));
		
	}


}
