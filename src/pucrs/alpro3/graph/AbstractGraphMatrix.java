package pucrs.alpro3.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public abstract class AbstractGraphMatrix {

	protected int[][] matrix;
	protected List<String> names;

	public AbstractGraphMatrix() {
		matrix = new int[7][7];
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
		int pos = getVerticeNumber(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		// for (int i = 0; i < matrix.length; i++)
		for (int i = 0; i < names.size(); i++)
			if (matrix[pos][i] != 0)
				r.add(getVerticeName(i));
		return r;
	}

	public void addEdge(String strOrig, String strDest) {
		addEdge(strOrig, strDest, 1);
	}

	public abstract void addEdge(String strOrig, String strDest, int peso);

	public String toString() {
		String r = "";
		r += names.toString();
		for (int i = 0; i < matrix.length; i++)
			r += "\n" + Arrays.toString(matrix[i]);
		return r;
	}

	public ArrayList<String> getTraversalWidth(String vertice) {
		// 1. Visite um nodo arbitrário
		int pos = getVerticeNumber(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		ArrayList<String> r = new ArrayList<>();
		r.add(getVerticeName(pos)); // r.add(vertice);
		// 2. Marque o nodo e coloque-o em uma fila Q
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(pos);
		// 3. Enquanto a fila Q não estiver vazia
		while (!queue.isEmpty()) {
			// 4. Retire um elemento N de Q
			int current = queue.remove();
			// 5. Para cada nodo M (não marcado) adjacente a N
			List<String> adjs = getAllAdjacents(getVerticeName(current));
			for (String a : adjs) {
				if (!r.contains(a)) {
					// 6. Visite M
					r.add(a);
					// 7. Coloque M na fila Q
					queue.add(getVerticeNumber(a));
					// 8. Marque M
				}
			}
		}
		return r;
	}

	public ArrayList<String> getTraversalDepth(String vertice) {
		// 1. Visite um nodo arbitrário
		int pos = getVerticeNumber(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		ArrayList<String> r = new ArrayList<>();
		r.add(getVerticeName(pos)); // r.add(vertice);
		// 2. Marque o nodo e coloque-o em uma pilha S
		Stack<Integer> pilha = new Stack<Integer>();
		pilha.push(pos);
		// 3. Enquanto a pilha S não estiver vazia
		while (!pilha.isEmpty()) {
			// 4. Retire um elemento N de S
			int current = (int) pilha.pop();
			// 5. Para cada nodo M (não marcado) adjacente a N
			List<String> adjs = getAllAdjacents(getVerticeName(current));
			for (String a : adjs) {
				if (!r.contains(a)) {
					// 6. Visite M
					r.add(a);
					// 7. Coloque N na pilha S
					pilha.push(current);
					// 8. Marque M
					// 9. Faça N = M
					pilha.push(getVerticeNumber(a));
					break;
				}
			}
		}
		return r;
	}

	private boolean marked[];

	public ArrayList<String> Path(String strOrig, String strDest) {
		int posOrig = getVerticeNumber(strOrig);
		int posDest = getVerticeNumber(strDest);
		// TODO: verificar se os nodos foram encontrados
		ArrayList<String> r = new ArrayList<>();

		marked = new boolean[names.size()];

		Path(posOrig, posDest, r);
		Collections.reverse(r);
		return r;

	}

	private void Path(int posOrig, int posDest, ArrayList<String> r) {
		marked[posOrig] = true;
		if (posOrig == posDest) {
			r.add(getVerticeName(posDest));
		} else {
			for (int i = 0; i < names.size(); i++) {
				if (matrix[posOrig][i] != 0 && !marked[i])
					Path(i, posDest, r);
				if (!r.isEmpty()) {
					r.add(getVerticeName(posOrig));
					break;
				}
			}
		}
	}

	public int countNodesReachable(String v) {
		return getTraversalDepth(v).size();
	}

	public ArrayList<String> getTwoLevelsAhead(String v) {
		int pos = getVerticeNumber(v);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + 0);
		ArrayList<String> r = new ArrayList<>();
		getTwoLevelsAhead(r, 0, v);
		return r;
	}

	private void getTwoLevelsAhead(ArrayList<String> r, int depth, String v) {
		int pos = getVerticeNumber(v);
		r.add(getVerticeName(pos));
		if (depth >= 2)
			return;

		List<String> adjs = getAllAdjacents(getVerticeName(pos));
		for (String a : adjs) {
			if (!r.contains(a)) {
				getTwoLevelsAhead(r, depth + 1, a);
			}
		}
	}

	public int[] sssp(String v) {
		// Dijkstra
		int pos = getVerticeNumber(v);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + 0);

		int[] d = new int[names.size()];
		for (int i = 0; i < names.size(); i++) {
			d[i] = Integer.MAX_VALUE / 4;
		}
		d[pos] = 0;

		LinkedList<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < names.size(); i++) {
			queue.add(i);
		}

		while (!queue.isEmpty()) {
			int current = remove(queue, d);
			for (Integer a : getAllAdjacentsByNumber(current)) {
				if (queue.contains(a)) {
					d[a] = Math.min(d[a], d[current] + matrix[current][a]);
				}
			}
		}

		return d;
	}

	private int remove(LinkedList<Integer> queue, int[] d) {
		int e = queue.peek();
		for (int i : queue) {
			if (d[e] > d[i]) {
				e = i;
			}
		}
		queue.remove(new Integer(e));
		// queue.remove(e);

		return e;
	}

	public int[][] assp() {

		int[][] d = new int[matrix.length][matrix.length];

		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if (matrix[i][j] == 0 && i != j)
					d[i][j] = Integer.MAX_VALUE / 4;
				else
					d[i][j] = matrix[i][j];
			}
		}

		for (int k = 0; k < d.length; k++) {
			for (int i = 0; i < d.length; i++) {
				for (int j = 0; j < d.length; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
		return d;
	}

	public Map<String, String> prim(String node) {
		int r = getVerticeNumber(node);
		if (r == -1)
			throw new IllegalArgumentException("Vertice invalido: " + 0);

		Map<String, String> A = new HashMap<>();

		// Prim, linhas 2,3,5
		int[] chave = new int[names.size()];
		for (int i = 0; i < names.size(); i++) {
			chave[i] = Integer.MAX_VALUE / 4;
		}
		chave[r] = 0;

		// Prim, linha 6
		LinkedList<Integer> Q = new LinkedList<Integer>();
		for (int i = 0; i < names.size(); i++) {
			Q.add(i);
		}

		// Prim, linha 7
		while (!Q.isEmpty()) {
			// Prim, linha 8
			int u = remove(Q, chave);
			// Prim, linha 9
			for (Integer v : getAllAdjacentsByNumber(u)) {
				if (Q.contains(v)) {
					// Prim, linha 10
					if (w(u, v) < chave[v]) {
						// Prim, linha 12
						chave[v] = w(u, v);
						A.put(getVerticeName(v), getVerticeName(u));
					}
				}
			}
		}

		// Prim, linha 13
		return A;

	}

	private int w(int u, Integer v) {
		return matrix[u][v];
	}

	private List<Integer> getAllAdjacentsByNumber(int u) {
		ArrayList<Integer> r = new ArrayList<>();
		int pos = u;
		for (int i = 0; i < names.size(); i++)
			if (matrix[pos][i] != 0)
				r.add(i);
		return r;
	}

	private int getVerticeNumber(String v) {
		return names.indexOf(v);
	}

	private String getVerticeName(int u) {
		return names.get(u);
	}

	public void kruskal() {

	}

	public void fordFulkerson(int s, int t) {

	}

}
