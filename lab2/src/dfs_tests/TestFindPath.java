package dfs_tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import digraph.DiGraph;
import graph.Graph;
import dfs_applications.DFS;


public class TestFindPath {
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
		List<Graph.Vertex<String,Integer>> path = 
									DFS.findPath(g,v,v);
		assertTrue("Wrong size of path", path.size() == 1);
		assertTrue(path.get(0) == v);
	}
	
	@Test
	public final void testTwoVerticesNoPath() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		List<Graph.Vertex<String,Integer>> path = 
									DFS.findPath(g,v1,v2);
		assertTrue("Path should be empty", path.isEmpty());
	}
	
	@Test
	public final void testPathOfTwoVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		List<Graph.Vertex<String,Integer>> path = 
							DFS.findPath(g,v1,v2);
		assertTrue("Wrong nbr of vertices on path", path.size() == 2);
		if (path.size() > 1){
			assertTrue("Wrong first element of path",path.get(0) == v1);
			assertTrue("Wrong second element of path",path.get(1) == v2);	
		}
	}
	
	@Test
	public final void testPathOfThreeVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v1,v3);
		g.addEdge(1,v3,v1);
		List<Graph.Vertex<String,Integer>> path = 
			DFS.findPath(g,v2,v3);
		assertTrue("Wrong nbr of vertices on path", path.size() == 3);
		if (path.size() == 3){
			assertTrue("Wrong first element of path",path.get(0) == v2);
			assertTrue("Wrong second element of path",path.get(1) == v1);
			assertTrue("Wrong third element of path",path.get(2) == v3);
		}
	}
	
	
	
	@Test
	public final void testPathOfFiveVertices() {
		Graph<String,Integer> g = 
			new DiGraph<String,Integer>();
		Graph.Vertex<String,Integer> v1 = g.addVertex("a");
		Graph.Vertex<String,Integer> v2 =g.addVertex("b");
		Graph.Vertex<String,Integer> v3 =g.addVertex("c");
		Graph.Vertex<String,Integer> v4 =g.addVertex("d");
		Graph.Vertex<String,Integer> v5 =g.addVertex("e");
		g.addEdge(1,v1,v2);
		g.addEdge(1,v2,v1);
		g.addEdge(1,v2,v3);
		g.addEdge(1,v3,v2);
		g.addEdge(1,v3,v4);
		g.addEdge(1,v4,v3);
		g.addEdge(1,v4,v5);
		g.addEdge(1,v5,v4);
		
		List<Graph.Vertex<String,Integer>> path = 
			DFS.findPath(g,v5,v1);
		assertTrue("Wrong nbr of vertices on path", path.size() == 5);
		if (path.size() == 3){
			assertTrue("Wrong first element of path",path.get(0) == v5);
			assertTrue("Wrong second element of path",path.get(1) == v4);
			assertTrue("Wrong third element of path",path.get(2) == v3);
			assertTrue("Wrong fourth element of path",path.get(3) == v2);
			assertTrue("Wrong fifth element of path",path.get(4) == v1);
		}
	}
	


}
