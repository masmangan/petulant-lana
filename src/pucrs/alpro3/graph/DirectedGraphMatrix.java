package pucrs.alpro3.graph;

import java.util.ArrayList;

public class DirectedGraphMatrix extends AbstractGraphMatrix implements
		DirectedGraph {

	@Override
	public void addEdge(String strOrig, String strDest) {
		int posOrig = names.indexOf(strOrig);
		int posDest = names.indexOf(strDest);
		matrix[posOrig][posDest] = true;
	}

	private int getTotalSaidas(int n) {
		return getAllAdjacents(names.get(n)).size();
	}

	private int getTotalEntradas(int n) {
		int entradas = 0;
		for (int j = 0; j < names.size(); j++)
			if (matrix[j][n] == true)
				entradas++;
		return entradas;
	}

	@Override
	public ArrayList<String> getSources() {
		ArrayList<String> r = new ArrayList<>();
		for (int i = 0; i < names.size(); i++)
			if (getTotalSaidas(i) > 0 && getTotalEntradas(i) == 0)
				r.add(names.get(i));
		return r;
	}

	@Override
	public ArrayList<String> getSinks() {
		ArrayList<String> r = new ArrayList<>();
		for (int i = 0; i < names.size(); i++)
			if (getTotalSaidas(i) == 0 && getTotalEntradas(i) > 0)
				r.add(names.get(i));
		return r;
	}

}
