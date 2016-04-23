package graph_util;
import graph.Graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GraphUtilities {
	public static <V,E> int nbrOfVertices(Graph<V,E> g) {
		int vertices = 0;
		Iterator<Graph.Vertex<V,E>> itr = g.iterator();
		while(itr.hasNext()){
			itr.next();
			vertices++;
		}
		return vertices;
	}
	
	public static <V,E> int nbrOfEdges(Graph<V,E> g, boolean directed) {
		int edges = 0;
		Iterator<Graph.Vertex<V,E>> itr = g.iterator();
		while(itr.hasNext()){
			Iterator<Graph.Edge<V,E>> itr2 = itr.next().iterator();
			while(itr2.hasNext()){
				itr2.next();
				edges++;
			}
		}
		if(!directed){
			edges /= 2;
		}
		return edges;
	}
	
	public static <V,E> boolean edgeBetween(Graph.Vertex<V,E> from, 
										Graph.Vertex<V,E> to) {
		Iterator<Graph.Edge<V,E>> itr = from.iterator();
		while(itr.hasNext()){
			if(itr.next().destination().equals(to)){
				return true;
			}
		}
		return false;
	}
}
