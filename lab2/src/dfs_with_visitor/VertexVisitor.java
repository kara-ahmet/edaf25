package dfs_with_visitor;
import graph.Graph;

public class VertexVisitor<V, E> {
	public boolean isDone() {
		return false;
	}
	
	public void preVisit(Graph.Vertex<V,E> v) {}
	
	public void postVisit(Graph.Vertex<V,E> v) {}

}
