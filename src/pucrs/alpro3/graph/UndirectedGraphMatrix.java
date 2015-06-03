package pucrs.alpro3.graph;

public class UndirectedGraphMatrix extends AbstractGraphMatrix implements
		UndirectedGraph {

	@Override
	public void addEdge(String strOrig, String strDest) {
		int posOrig = names.indexOf(strOrig);
		int posDest = names.indexOf(strDest);
		matrix[posOrig][posDest] = true;
		matrix[posDest][posOrig] = true;
	}

}
