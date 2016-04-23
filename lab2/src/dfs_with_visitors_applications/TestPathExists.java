package dfs_with_visitors_applications;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import digraph.DiGraph;
import graph.Graph;



public class TestPathExists {
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
		Graph.Vertex<String,Integer> v = g.addVertex("a");
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v,v));
	}
	
	@Test
	public final void testTwoVerticesNoPath() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v1,v2));
	}
	
	@Test
	public final void testTwoVerticesPathExists() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v1,v2));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v2,v1));
	}
	
	@Test
	public final void testThreeVerticesPathsExist() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v1,v3);
		g.addEdge(1,v3,v1);
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v1,v2));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v2,v3));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v3,v1));
	}
	
	@Test
	public final void testThreeVerticesNoPath() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v2,v3);
		g.addEdge(1,v3,v2);
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v1,v2));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v1,v3));
	}
	
	@Test
	public final void testFiveVerticesPathsExist() {
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
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v1,v2));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v2,v3));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v3,v4));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v4,v5));
		assertTrue(DFS_With_Visitors_Applications.pathExists(g,v5,v1));
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
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v1,v4));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v2,v4));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v3,v4));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v5,v1));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v5,v2));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v5,v3));
	}
	@Test
	public final void testFiveVerticesFiveComponents() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		Graph.Vertex<String,Integer> v4 =g.addVertex("d");
		Graph.Vertex<String,Integer> v5 =g.addVertex("e");
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v1,v2));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v2,v3));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v3,v4));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v4,v5));
		assertFalse(DFS_With_Visitors_Applications.pathExists(g,v5,v1));
	}


}
