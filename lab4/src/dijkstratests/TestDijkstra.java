package dijkstratests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import graph.Graph;
import digraph.DiGraph;
import dijkstra.*;

public class TestDijkstra {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDijkstraZero() {
		Graph<String,TimeAndDistance> g = 
				new DiGraph<String,TimeAndDistance>();
		Graph.Vertex<String,TimeAndDistance> v1 = g.addVertex("a");
		Graph.Vertex<String,TimeAndDistance> v2 = g.addVertex("b");
		g.addEdge(new TimeAndDistance(4,10), v1, v2);
		g.addEdge(new TimeAndDistance(5,7), v1, v2);
		TimeAndDistance result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v1, 
									new DistTimeComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(0,0),result);
	}
	
	@Test
	public void testDijkstraOneEdgeDist() {
		Graph<String,TimeAndDistance> g = 
				new DiGraph<String,TimeAndDistance>();
		Graph.Vertex<String,TimeAndDistance> v1 = g.addVertex("a");
		Graph.Vertex<String,TimeAndDistance> v2 = g.addVertex("b");
		g.addEdge(new TimeAndDistance(4,10), v1, v2);
		g.addEdge(new TimeAndDistance(5,7), v1, v2);
		TimeAndDistance result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v2, 
									new DistTimeComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(5,7),result);
	}
	
	@Test
	public void testDijkstraOneEdgeTime() {
		Graph<String,TimeAndDistance> g = 
				new DiGraph<String,TimeAndDistance>();
		Graph.Vertex<String,TimeAndDistance> v1 = g.addVertex("a");
		Graph.Vertex<String,TimeAndDistance> v2 = g.addVertex("b");
		g.addEdge(new TimeAndDistance(4,10), v1, v2);
		g.addEdge(new TimeAndDistance(5,7), v1, v2);
		TimeAndDistance result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v2, 
									new TimeDistComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(4,10),result);
	}
	
	@Test
	public void testDijkstraSmallCycleTime() {
		Graph<String,TimeAndDistance> g = 
				new DiGraph<String,TimeAndDistance>();
		Graph.Vertex<String,TimeAndDistance> v1 = g.addVertex("a");
		Graph.Vertex<String,TimeAndDistance> v2 = g.addVertex("b");
		g.addEdge(new TimeAndDistance(4,10), v1, v2);
		g.addEdge(new TimeAndDistance(4,10), v2, v1);
		g.addEdge(new TimeAndDistance(5,7), v1, v2);
		g.addEdge(new TimeAndDistance(5,7), v2, v1);
		TimeAndDistance result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v2, 
									new TimeDistComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(4,10),result);
	}
	
	@Test
	public void testDijkstraThreeEdgesTime() {
		Graph<String,TimeAndDistance> g = 
				new DiGraph<String,TimeAndDistance>();
		Graph.Vertex<String,TimeAndDistance> v1 = g.addVertex("a");
		Graph.Vertex<String,TimeAndDistance> v2 = g.addVertex("b");
		Graph.Vertex<String,TimeAndDistance> v3 = g.addVertex("c");
		g.addEdge(new TimeAndDistance(5,7), v1, v2);
		g.addEdge(new TimeAndDistance(2,5), v1, v3);
		g.addEdge(new TimeAndDistance(2,4), v3, v2);
		TimeAndDistance result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v2, 
									new TimeDistComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(4,9),result);
		result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v2, 
									new DistTimeComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(5,7),result);
	}
	
	@Test
	public void testDijkstraFiveEdgesTime() {
		Graph<String,TimeAndDistance> g = 
				new DiGraph<String,TimeAndDistance>();
		Graph.Vertex<String,TimeAndDistance> v1 = g.addVertex("a");
		Graph.Vertex<String,TimeAndDistance> v2 = g.addVertex("b");
		Graph.Vertex<String,TimeAndDistance> v3 = g.addVertex("c");
		Graph.Vertex<String,TimeAndDistance> v4 = g.addVertex("d");
		g.addEdge(new TimeAndDistance(8,10), v1, v2);
		g.addEdge(new TimeAndDistance(2,3), v1, v3);
		g.addEdge(new TimeAndDistance(4,5), v3, v2);
		g.addEdge(new TimeAndDistance(1,2), v3, v4);
		g.addEdge(new TimeAndDistance(1,3), v4, v2);
		TimeAndDistance result = 
			new Dijkstra<String,TimeAndDistance>().shortestPath(g, v1, v2, 
									new TimeDistComparator(), new TimeAndDistanceAdder());
		assertEquals(new TimeAndDistance(4,8),result);
		
	}

}
