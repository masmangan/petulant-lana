package pucrs.alpro3.graph;

import java.util.ArrayList;

public interface AbstractGraph {
	void addVertice(String vertice);

	void addEdge(String strOrig, String strDest, int peso);
	void addEdge(String strOrig, String strDest);

	int getDegree(String vertice);

	ArrayList<String> getAllAdjacents(String vertice);

	public ArrayList<String> getTraversalWidth(String vertice);

	public ArrayList<String> getTraversalDepth(String vertice);
}