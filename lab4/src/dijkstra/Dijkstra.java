package dijkstra;
import graph.Graph;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


public class Dijkstra<V,E> {
	Comparator<E> cmp;
	public E shortestPath(Graph<V, E> g, Graph.Vertex<V, E> from,
			Graph.Vertex<V, E> to, Comparator<E> cmp, Adder<E> adder) {
		this.cmp = cmp;
		
		PrioQueueEntryComparator p = new PrioQueueEntryComparator();
		PriorityQueue<PrioQueueEntry> pq = new PriorityQueue<PrioQueueEntry>(
				11111, p);
		Map<Graph.Vertex<V, E>, E> vertexMap = new HashMap<Graph.Vertex<V, E>, E>();
		Set<PrioQueueEntry> done = new HashSet<PrioQueueEntry>();
		pq.offer(new PrioQueueEntry(from, adder.getZero()));
		vertexMap.put(from, adder.getZero());
		while (!pq.isEmpty()) {
			PrioQueueEntry act = pq.poll();
			if (act.vertex == to) {
				return act.distance;
			}
			if (!done.contains(act)) {
				done.add(act);

				for (Graph.Edge<V, E> e : act.vertex) {
					Graph.Vertex<V, E> w = e.destination();
					E newDistance = adder.add(act.distance, e.getValue());
					if (!vertexMap.containsKey(w)
							|| cmp.compare(vertexMap.get(w), newDistance) > 0) {
						pq.offer(new PrioQueueEntry(w, newDistance));
						vertexMap.put(w, newDistance);
					}
				}
			}
		}
		return null;
	}
	private class PrioQueueEntry{
		Graph.Vertex<V, E> vertex;
		E distance;
		public PrioQueueEntry(Graph.Vertex<V, E> vertex, E distance){
			this.vertex = vertex;
			this.distance = distance;
		}
	}
	public class PrioQueueEntryComparator implements
					Comparator<PrioQueueEntry>{
		public int compare(Dijkstra<V, E>.PrioQueueEntry arg0, 
						Dijkstra<V, E>.PrioQueueEntry arg1){
			return cmp.compare(arg0.distance, arg1.distance);
		}
	}
}
