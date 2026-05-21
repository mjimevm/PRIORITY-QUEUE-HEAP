package org.heap;

public interface PriorityQueue<E extends Comparable<E>> {
    void insert(E item);
    E removeMin();
    E peekMin();
    boolean isEmpty();
    int size();
}