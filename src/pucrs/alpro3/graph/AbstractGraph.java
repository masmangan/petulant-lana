package pucrs.alpro3.graph;

import java.util.ArrayList;
import java.util.Map;

public interface AbstractGraph {
	void addVertice(String vertice);

	void addEdge(String strOrig, String strDest, int peso);
	void addEdge(String strOrig, String strDest);

	int getDegree(String vertice);

	ArrayList<String> getAllAdjacents(String vertice);

	public ArrayList<String> getTraversalWidth(String vertice);

	public ArrayList<String> getTraversalDepth(String vertice);
	
	public ArrayList<String> Path(String strOrig, String strDest);
	
	
	int countNodesReachable(String v); 
	ArrayList<String> getTwoLevelsAhead(String v);
	
	
	public int[][] assp();
	public int[] sssp(String v);

	public Map<String, String> prim(String r);
	
	
}