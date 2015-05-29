package pucrs.alpro3.graph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

public class UndirectedGraphMatrixTest {

	@Test
	public void testDegreePOA() {
		UndirectedGraph g = new UndirectedGraphMatrix();
		g.addVertice("POA");
		g.addVertice("SDU");
		g.addVertice("CWB");
		g.addEdge("POA", "CWB");
		g.addEdge("POA", "SDU");
		int expected = 2;
		int actual = g.getDegree("POA");
		assertEquals(expected, actual);
	}

	@Test
	public void testAllAdjacentsPOA() {
		UndirectedGraph g = new UndirectedGraphMatrix();
		g.addVertice("POA");
		g.addVertice("SDU");
		g.addVertice("CWB");
		g.addEdge("POA", "CWB");
		g.addEdge("POA", "SDU");
		ArrayList<String> actual = g.getAllAdjacents("POA");
		assertEquals(2, actual.size());
		assertTrue(actual.contains("CWB"));
		assertTrue(actual.contains("SDU"));
	}

}
