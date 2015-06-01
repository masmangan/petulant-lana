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

	@Override
	public ArrayList<String> getSources() {
		ArrayList<String> r = new ArrayList<>();
		for (int i = 0; i < names.size(); i++) {
			if (!getAllAdjacents(names.get(i)).isEmpty()) {
				int entradas = 0;
				for (int j = 0; j < names.size(); j++) {
					if (matrix[j][i] == true) {
						entradas++;
					}
				}
				if (entradas == 0) {
					r.add(names.get(i));
				}
			}
		}
		return r;
	}

	@Override
	public ArrayList<String> getSinks() {
		ArrayList<String> r = new ArrayList<>();
		// TODO para cada vertice
		// TODO encontrar linha vazia, a coluna não pode estar vazia
		// TODO acrescentar nome do vertice aa resposta
		return r;
	}

}
