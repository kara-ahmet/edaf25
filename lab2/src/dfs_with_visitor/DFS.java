package dfs_with_visitor;
import graph.Graph;


public class DFS {
	

	public  static <V,E> void dfs(Graph.Vertex<V,E> v, VertexVisitor<V,E> visitor) {
		if (visitor.isDone()) {
			return;
		}
		visitor.preVisit(v);
		v.visit();
		for (Graph.Edge<V,E> e : v) {
			Graph.Vertex<V,E> w = e.destination();
			if (!w.isVisited()) {
				dfs(w,visitor);
			}
		}
		visitor.postVisit(v);
	}
}
