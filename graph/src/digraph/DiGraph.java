package digraph;

import graph.Graph;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * Class DiGraph represents a generic directed graph with elements of type V 
 * associated to its vertices and data of type E to its Edges.
*/
public class DiGraph<V, E> implements Graph<V, E> {
	private Set<Graph.Vertex<V,E>> vertices;
	 
	/**
	  * Constructs an empty directed graph
	*/
	public DiGraph() {
		vertices = new HashSet<Graph.Vertex<V,E>>();
	}

	/**
	  * Creates an iterator for the vertices of this graph.
	  */
	public Iterator<Graph.Vertex<V, E>> iterator() {
		return vertices.iterator();
	}

	/**
	  * Inserts a new vertex in the graph.
	  * @param value  The value associated with the newly inserted vertex.
	  * @return	Returns the newly created vertex.
	  */
	public Graph.Vertex<V, E> addVertex(V value) {
		Graph.Vertex<V,E> v = new Vertex<V,E>(value);
		vertices.add(v);
		return v;
		
	}

	/** 
	  * Inserts a new directed edge in this graph.
	  * @param value  The value associated with the newly created edge.
	  * @param source The source vertex of the newly created edge.
	  * @param destination The destination vertex of the newly created Edge.
	  * @throws NoSuchElementException if source or destination is not present in this graph.
	  */
	public void addEdge(E value, Graph.Vertex<V,E> source,
			Graph.Vertex<V, E> destination) {
		if (!vertices.contains(source) || !vertices.contains(destination))
			throw new NoSuchElementException("addEgde: source or destination not in graph");
		Edge<V,E> e = new Edge<V,E>(value, source, destination);
		((DiGraph.Vertex<V,E>)source).addEdge(e);

	}

	/** 
	  * Marks all vertices of this graph as not visited.
	  */
	public void unvisit() {
		for (Graph.Vertex<V,E> v : vertices) {
			v.unvisit();
		}

	}
	
	/**
	  * Returns a String representation of the vertices and edges of the graph. 
	  * @return A String representation of the graph.
	  */
	 public String toString() {
		String s = "";
		for (Graph.Vertex<V,E> v : vertices) {
			s = s+"Vertex " + v.toString() + " outgoing edges\n";
			for (Graph.Edge<V,E> e : v) {
				s = s+ "\t" + e.toString() + " to " + e.destination().toString() + "\n";				
			}
			s = s+"\n";
		}
		return s;
	 }
	 
	 /** 
	  * Nested class representing a vertex of a directed graph.
	  */
	public static class Vertex<V,E> implements Graph.Vertex<V,E> {
		V value;
		Set<Graph.Edge<V,E>> edges;
		boolean visited;

		/** 
		  * Constructs a new Vertex. Initially the vertex has no edges and is marked as unvisited.
		  * @param value The value associated with the newly created vertex.
		*/
		public Vertex(V value) {
			this.value = value;
			visited = false;
			edges = new HashSet<Graph.Edge<V,E>>();
		}

		/**
		  * Returns the value associated with this vertex.
		  * @return The value of the data associated with this vertex.
		*/
		public V getValue() {
			return value;
		}
		
		/**
		  * Sets the value associated with this vertex.
		  * @param value The new value of the data associated with this vertex.
		*/
		public void setValue(V value) {
			this.value = value;
		}
		
		/*
		  * Adds an edge to the set of outgoing edges of this vertex.
		  * Used internally in the package.
	    */
		private void addEdge(Graph.Edge<V,E> e)  {
			edges.add(e);
		}

		/** 
		  * Marks the vertex as not visited.
		*/	
		public void unvisit() {
			visited = false;
		}
		
		/**
		  * Marks this vertex as visited.
		*/
		public void visit() {
			visited = true;
		}
		
		/** 
		  * Returns true if this vertex is visited, otherwise false.
		  * @return true if this vertex is visted, otherwise false.
		*/
		public boolean isVisited() {
			return visited;
		}

		/**
		  * Creates an iterator over the outgoing edges of this vertex.
		  * @return An iterator of the outgoing edges.
		*/
		public Iterator<Graph.Edge<V,E>> iterator() {
			return edges.iterator();
		}
		
		/**
		  * Returns a String representation of the data associated with this vertex.
		  * @return a String representation of the data associated with this vertex.
		*/
		public String toString() {
			return value.toString();
		}
	}
	
	 /** 
	   * Inner class representing an edge of a directed graph.
	   */
	public static class Edge<V,E> implements Graph.Edge<V,E> {
		E value;
		Graph.Vertex<V,E> source, destination;
		
		/**
		  * Constructs an edge from source to destination.
		  * @param value The data associated to the edge.
		  * @param source  The source vertex of the edge.
		  * @param destination The destination vertex of the edge
		*/
		Edge(E value, Graph.Vertex<V,E> source, 
							Graph.Vertex<V,E> destination) {
			this.value = value;
			this.source = source;
			this.destination = destination;
		}
		
		/**
		  * Returns the value associated with this edge.
		  * @return The value associated with this edge.
		*/
		public E getValue() {
			return value;
		}

		/**
		  * Sets the value associated with this edge.
		  * @param value The new value associated with this edge.
		*/
		public void setValue(E value) {
			this.value = value;
		}
		
		/**
		  * Returns the source vertex of this edge.
		  * @return The source vertex of this edge.
		*/
		public Graph.Vertex<V,E> source() {
			return source;
		}
		
		/**
		  * Returns the destination vertex of this edge.
		  * @return The destination vertex of this edge.
		*/	
		public Graph.Vertex<V,E> destination() {
			return destination;
		}
		

		/**
		  * Returns a String representation of the data associated with this edge.
		  * @return A String representation of the data associated with this edge.
		*/
		public String toString() {
			return value.toString();
		}
			
	}

}
