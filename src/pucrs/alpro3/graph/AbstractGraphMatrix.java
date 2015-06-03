package pucrs.alpro3.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public abstract class AbstractGraphMatrix {

	protected boolean[][] matrix;
	protected List<String> names;

	public AbstractGraphMatrix() {
		matrix = new boolean[7][7];
		names = new ArrayList<String>();
	}

	public void addVertice(String vertice) {
		if (vertice == null)
			throw new IllegalArgumentException("O vertice nao pode ser null");

		if (vertice.trim().isEmpty())
			throw new IllegalArgumentException("O vertice nao pode ser vazio");

		if (names.contains(vertice))
			throw new IllegalArgumentException(
					"O vertice ja se encontra cadastrado: " + vertice);

		names.add(vertice);
	}

	public int getDegree(String vertice) {
		return getAllAdjacents(vertice).size();
	}

	public ArrayList<String> getAllAdjacents(String vertice) {
		ArrayList<String> r = new ArrayList<>();
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		// for (int i = 0; i < matrix.length; i++)
		for (int i = 0; i < names.size(); i++)
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

	public ArrayList<String> getTraversalWidth(String vertice) {
		// 1. Visite um nodo arbitr�rio
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		ArrayList<String> r = new ArrayList<>();
		r.add(names.get(pos)); // r.add(vertice);
		// 2. Marque o nodo e coloque-o em uma fila Q
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(pos);
		// 3. Enquanto a fila Q n�o estiver vazia
		while (!queue.isEmpty()) {
			// 4. Retire um elemento N de Q
			int current = queue.remove();
			// 5. Para cada nodo M (n�o marcado) adjacente a N
			List<String> adjs = getAllAdjacents(names.get(current));
			for (String a : adjs) {
				if (!r.contains(a)) {
					// 6. Visite M
					r.add(a);
					// 7. Coloque M na fila Q
					queue.add(names.indexOf(a));
					// 8. Marque M
				}
			}
		}
		return r;
	}

	public ArrayList<String> getTraversalDepth(String vertice) {
		// 1. Visite um nodo arbitr�rio
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		ArrayList<String> r = new ArrayList<>();
		r.add(names.get(pos)); // r.add(vertice);
		// 2. Marque o nodo e coloque-o em uma pilha S
		Stack<Integer> pilha = new Stack<Integer>();
		pilha.push(pos);
		// 3. Enquanto a pilha S n�o estiver vazia
		while (!pilha.isEmpty()) {
			// 4. Retire um elemento N de S
			int current = (int) pilha.pop();
			// 5. Para cada nodo M (n�o marcado) adjacente a N
			List<String> adjs = getAllAdjacents(names.get(current));
			for (String a : adjs) {
				if (!r.contains(a)) {
					// 6. Visite M
					r.add(a);
					// 7. Coloque N na pilha S
					pilha.push(current);
					// 8. Marque M
					// 9. Fa�a N = M
					pilha.push(names.indexOf(a));
					break;
				}
			}
		}
		return r;
	}

}