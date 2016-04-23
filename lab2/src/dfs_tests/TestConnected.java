package dfs_tests;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import digraph.DiGraph;
import graph.Graph;

import dfs_applications.DFS;

public class TestConnected {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testIsConnectedOneVertex() {
		DiGraph<String,Integer> g = 
			new DiGraph<String,Integer>();
		g.addVertex("a");
		assertTrue(DFS.isConnected(g));
	}
	
	@Test
	public final void testNotConnectedTwoVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		g.addVertex("a");
		g.addVertex("b");
		assertFalse(DFS.isConnected(g));
	}
	
	@Test
	public final void testConnectedTwoVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		assertTrue(DFS.isConnected(g));
	}
	
	@Test
	public final void testConnectedThreeVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v1,v3);
		g.addEdge(1,v3,v1);
		assertTrue(DFS.isConnected(g));
	}
	
	@Test
	public final void testNotConnectedThreeVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v2,v3);
		g.addEdge(1,v3,v2);
		assertFalse(DFS.isConnected(g));
	}
	
	@Test
	public final void testConnectedFiveVertices() {
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
		assertTrue(DFS.isConnected(g));
	}
	
	@Test
	public final void testNotConnectedFiveVertices() {
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
		assertFalse(DFS.isConnected(g));
	}


}

