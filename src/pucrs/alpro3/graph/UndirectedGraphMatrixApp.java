package pucrs.alpro3.graph;

public class UndirectedGraphMatrixApp {
	public static void main(String[] args) {
		UndirectedGraph g = new UndirectedGraphMatrix();
		System.out.println(g);
		g.addVertice("POA");
		System.out.println(g);
		g.addVertice("SDU");
		System.out.println(g);
		g.addVertice("CWB");
		System.out.println(g);
		g.addEdge("POA", "CWB");
		System.out.println(g);
		g.addEdge("POA", "SDU");
		System.out.println(g);
		
		System.out.println(g.getTraversalWidth("POA"));
		System.out.println(g.getTraversalWidth("CWB"));		
	}
}
