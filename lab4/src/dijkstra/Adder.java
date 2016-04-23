package dijkstra;

public interface Adder<E> {
	E add(E x, E y);
	E getZero();
}
