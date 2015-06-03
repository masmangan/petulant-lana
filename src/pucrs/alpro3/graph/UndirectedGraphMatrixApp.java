package pucrs.alpro3.graph;

public class UndirectedGraphMatrixApp {
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraphMatrix();
		System.out.println(g);
		g.addVertice("POA");
		g.addVertice("FLP");
		g.addVertice("CWB");
		g.addVertice("SDU");
		g.addVertice("GRU");
		g.addVertice("BHA");

		g.addEdge("POA", "CWB");
		g.addEdge("POA", "FLP");
		g.addEdge("CWB", "SDU");
		g.addEdge("CWB", "GRU");
		g.addEdge("GRU", "BHA");
		
		//
		System.out.println(g);
		
		System.out.println(g.getTraversalWidth("POA"));
		System.out.println(g.getTraversalWidth("CWB"));		
		
		System.out.println(g.getTraversalDepth("POA"));
		System.out.println(g.getTraversalDepth("CWB"));				
	}
}
