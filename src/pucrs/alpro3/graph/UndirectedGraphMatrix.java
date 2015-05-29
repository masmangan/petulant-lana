package pucrs.alpro3.graph;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphMatrix implements UndirectedGraph {

	private boolean[][] matrix;
	private List<String> names;

	public UndirectedGraphMatrix() {
		// TODO inicializar matrix e lista names
	}

	@Override
	public void addVertice(String vertice) {
		// TODO acrescentar o nome na lista names, caso o nome não exista
	}

	@Override
	public void addEdge(String strOrig, String strDest) {
		// TODO consultar a posição do nome de strOrig
		// TODO consultar a posição do nome de strDest
		// TODO na matriz, marcar como true a coordenada [pos(strOrig)][pos(strDest)]
	}

	@Override
	public int getDegree(String vertice) {
		// TODO obter adjacentes do vertice
		// TODO retornar o número de adjacentes
		return 0;
	}

	@Override
	public ArrayList<String> getAllAdjacents(String vertice) {
		// TODO consultar posicao do vertice
		// TODO percorrer a linha da posição do vertice
		// TODO colocar o nome de cada vertice na lista
		// TODO retornar a lista
		return null;
	}

	@Override
	public String toString() {
		// TODO apresentar matriz e lista
		return super.toString();
	}

}
