package dfs_tests;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import digraph.DiGraph;
import graph.Graph;
import dfs_applications.DFS;


public class TestNbrOfComponents {
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testOneVertex() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		g.addVertex("a");
		assertTrue(DFS.nbrOfComponents(g) == 1);
	}
	
	@Test
	public final void testTwoVerticesTwoComponents() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		g.addVertex("a");
		g.addVertex("b");
		assertTrue(DFS.nbrOfComponents(g) == 2);
	}
	
	@Test
	public final void testTwoVerticesOneComponent() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		assertTrue(DFS.nbrOfComponents(g) == 1);
	}
	
	@Test
	public final void testThreeVerticesOneComponent() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v1,v3);
		g.addEdge(1,v3,v1);
		assertTrue(DFS.nbrOfComponents(g) == 1);
	}
	
	@Test
	public final void testThreeVerticesTwoComponents() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v2,v3);
		g.addEdge(1,v3,v2);
		assertTrue(DFS.nbrOfComponents(g) == 2);
	}
	
	@Test
	public final void testFiveVerticesOneComponent() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		Graph.Vertex<String,Integer> v4 =g.addVertex("d");
		Graph.Vertex<String,Integer> v5 =g.addVertex("e");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v1,v3);
		g.addEdge(1,v3,v1);
		g.addEdge(1,v2,v3);
		g.addEdge(1,v3,v2);
		g.addEdge(1,v1,v4);
		g.addEdge(1,v4,v1);
		g.addEdge(1,v4,v5);
		g.addEdge(1,v5,v4);
		assertTrue(DFS.nbrOfComponents(g) == 1);
	}
	
	@Test
	public final void testFiveVerticesTwoComponents() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		Graph.Vertex<String,Integer> v4 =g.addVertex("d");
		Graph.Vertex<String,Integer> v5 =g.addVertex("e");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v1,v3);
		g.addEdge(1,v3,v1);
		g.addEdge(1,v2,v3);
		g.addEdge(1,v3,v2);
		g.addEdge(1,v5,v4);
		g.addEdge(1,v4,v5);
		assertTrue(DFS.nbrOfComponents(g) == 2);
	}
	@Test
	public final void testFiveVerticesFiveComponents() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		assertTrue(DFS.nbrOfComponents(g) == 5);
	}



}
