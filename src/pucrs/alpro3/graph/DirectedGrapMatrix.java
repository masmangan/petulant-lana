package pucrs.alpro3.graph;

import java.util.ArrayList;

public class DirectedGrapMatrix extends AbstractGraphMatrix implements DirectedGraph {

	@Override
	public void addEdge(String strOrig, String strDest) {
		int posOrig = names.indexOf(strOrig);
		int posDest = names.indexOf(strDest);
		matrix[posOrig][posDest] = true;
	}

	@Override
	public ArrayList<String> getSources() {
		// TODO para cada vertice
		// TODO encontrar coluna vazia, a coluna não pode estar vazia
		// TODO acrescentar nome do vertice aa resposta
		return null;
	}

	@Override
	public ArrayList<String> getSinks() {
		// TODO para cada vertice
		// TODO encontrar coluna vazia, a linha não pode estar vazia
		// TODO acrescentar nome do vertice aa resposta
		return null;
	}

}
