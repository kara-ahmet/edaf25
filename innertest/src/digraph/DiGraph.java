package digraph;
import java.util.*;

public class DiGraph<V,E> implements Iterable<DiGraph<V,E>.Vertex> {
	private Set<Vertex> vertices;
		 
	/**
	  * Constructs an empty directed graph
	*/
	 public DiGraph() {
		vertices = new HashSet<Vertex>();
	 } 
	 
		 
	/**
	  * Inserts a new vertex in the graph.
	  * @param value  The value associated with the newly inserted vertex.
	  * @return	Returns the newly created vertex.
	  */
	 public Vertex addVertex(V value) {
		Vertex v = new Vertex(value);
		vertices.add(v);
		return v;
	 }
	 
	/** 
	  * Inserts a new directed edge in this graph.
	  * @param value  The value associated with the newly created edge.
	  * @param source The source vertex of the newly created edge.
	  * @param destination The destination edge of the newly created Edge.
	  * @throws NoSuchElementException if source or destination is not present in this graph.
	  */
	 public void addEdge(E value, Vertex source, Vertex destination) throws NoSuchElementException {
		if (!vertices.contains(source) || !vertices.contains(destination))
			throw new NoSuchElementException("addEgde: source or destination not in graph");
		Edge edge = new Edge(value, source, destination);
		source.addEdge(edge);
	 }
	 
	/**
	  * Creates an iterator for the vertices of this graph.
	  */
	public Iterator<Vertex> iterator() {
		return vertices.iterator();
	 }
		
	/** 
	  * Marks all vertices of this graph as not visited.
	  */
	 public void unvisit() {
		for (Vertex v : vertices)
			v.unvisit();		
	 }
	 
	/**
	  * Returns a String representation of the vertices and edges of the graph. 
	  */
	 public String toString() {
		String s = "";
		for (Vertex v : vertices) {
			s = s+"Vertex " + v.toString() + " outgoing edges\n";
			for (Edge e : v.edges) {
				s = s+ "\t" + e.toString() + " to " + e.getDestination().toString() + "\n";				
			}
			s = s+"\n";
		}
		return s;
	 }
	 
	/** 
	  * Inner class representing a vertex of a directed graph.
	  */
	 public class Vertex implements Iterable<Edge> {
		V value;
		Set<Edge> edges;
		boolean visited;
	
		/** 
		  * Constructs a new Vertex. Initially the vertex has no edges and is marked as unvisited.
		  * @param value The value associated with the newly created vertex.
		*/
		Vertex(V value) {
			this.value = value;
			visited = false;
			edges = new HashSet<Edge>();
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
		void addEdge(Edge edge) {
			edges.add(edge);
		}
	
		/**
		  * Creates an iterator over the outgoing edges of this vertex.
		  * @return An iterator of the outgoing edges.
		*/
		public Iterator<Edge> iterator() {
			return edges.iterator();
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
		  * Marks the vertex as not visited.
		*/	
		public void unvisit() {
			visited = false;
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
	 public class Edge {
		E value;
		Vertex source, destination;
	
		/**
		  * Constructs an edge from source to destination.
		  * @param value The data associated to the edge.
		  * @param source  The source vertex of the edge.
		  * @param destination The destination vertex of the edge
		*/
		Edge(E value, Vertex source, Vertex destination) {
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
		public Vertex getSource() {
			return source;
		}
	
		/**
		  * Returns the destination vertex of this edge.
		  * @return The destination vertex of this edge.
		*/	
		public Vertex getDestination() {
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

