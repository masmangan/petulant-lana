package pucrs.alpro3.graph;

import java.util.ArrayList;

public interface DirectedGraph extends AbstractGraph {
	ArrayList<String> getSources();
	ArrayList<String> getSinks();
}
