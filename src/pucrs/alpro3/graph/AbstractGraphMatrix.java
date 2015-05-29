package pucrs.alpro3.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractGraphMatrix {

	protected boolean[][] matrix;
	protected List<String> names;

	public AbstractGraphMatrix() {
		matrix = new boolean[5][5];
		names = new ArrayList<String>();
	}

	public void addVertice(String vertice) {
		if (vertice == null)
			throw new IllegalArgumentException("O vertice nao pode ser null");
	
		if (vertice.trim().isEmpty())
			throw new IllegalArgumentException("O vertice nao pode ser vazio");
			
		if (names.contains(vertice))
			throw new IllegalArgumentException("O vertice ja se encontra cadastrado: " + vertice);
		
		names.add(vertice);
	}

	public int getDegree(String vertice) {
		return getAllAdjacents(vertice).size();
	}

	public ArrayList<String> getAllAdjacents(String vertice) {
		ArrayList<String> r = new ArrayList<>();
		int pos = names.indexOf(vertice);
		for (int i = 0; i < matrix.length; i++)
			if (matrix[pos][i] == true)
				r.add(names.get(i));
		return r;
	}
	public abstract void addEdge(String strOrig, String strDest);

	public String toString() {
		String r = "";
		r += names.toString();
		for (int i = 0; i < matrix.length; i++)
			r += "\n" + Arrays.toString(matrix[i]);
		return r;
	}

}