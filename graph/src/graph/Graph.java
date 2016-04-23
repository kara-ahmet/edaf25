package graph;

/**
 * This interface represents a graph. It provides operations for building
 * the graph, graph traverals and for marking/unmarking vertices. 
 * There are two nested interfaces representing vertices and edges
 * in the graph.
 * @param <V>The type of elements associated with vertices in the graph
 * @param <E>The type of elements associated with edges in the graph
 */
public interface Graph<V,E> extends Iterable<Graph.Vertex<V,E>> {
	
	/**
	 * Represents a vertex in  a graph. 
	 * @param <V>The type of elements associated with vertices in the graph
	 * @param <E>The type of elements associated with edges in the graph
	 */	
	interface Vertex<V,E> extends Iterable<Edge<V,E>>{
		/**
		  * Returns the value associated with this vertex.
		  * @return The value of the data associated with this vertex.
		*/
		V getValue();
		
		/**
		  * Sets the value associated with this vertex.
		  * @param value The new value of the data associated with this vertex.
		*/
		void setValue(V value);
		
		/** 
		  * Marks the vertex as  visited.
		*/	
		void visit();
		
		/** 
		  * Returns true if this vertex is visited, otherwise false.
		  * @return true if this vertex is visted, otherwise false.
		*/
		boolean isVisited();
		
		/** 
		  * Marks the vertex as not visited.
		*/	
		void unvisit();
	}
	
	/**
	 * Represents an edge in a graph. 
	 * @param <V>The type of elements associated with vertices in the graph
	 * @param <E>The type of elements associated with edges in the graph
	 */	
	interface Edge<V,E> {

		/**
		  * Returns the value associated with this edge.
		  * @return The value associated with this edge.
		*/
		E getValue();
		
		/**
		  * Sets the value associated with this edge.
		  * @param value The new value associated with this edge.
		*/
		void setValue(E value);
		
		/**
		  * Returns the source vertex of this edge.
		  * @return The source vertex of this edge.
		*/
		Vertex<V,E> source();
		

		/**
		  * Returns the destination vertex of this edge.
		  * @return The destination vertex of this edge.
		*/	
		Vertex<V,E> destination();
	}
	
	/**
	  * Inserts a new vertex in the graph.
	  * @param value  The value associated with the newly inserted vertex.
	  * @return	Returns the newly created vertex.
	  */
	public Vertex<V,E> addVertex(V value);
	
	/** 
	  * Inserts a new directed edge in this graph.
	  * @param value  The value associated with the newly created edge.
	  * @param source The source vertex of the newly created edge.
	  * @param destination The destination vertex of the newly created Edge.
	  * @throws NoSuchElementException if source or destination is not present in this graph.
	  */
	public void addEdge(E value, Vertex<V,E> source, Vertex<V,E> destination);
	
	/** 
	  * Marks all vertices of this graph as not visited.
	  */
	public void unvisit();

}
