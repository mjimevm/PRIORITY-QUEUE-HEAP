package org.heap;

import java.util.NoSuchElementException;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> heap;

    public VectorHeap() {
        heap = new Vector<>();
    }

    @Override
    public void insert(E item) {
        heap.add(item);
        int current = heap.size() - 1;
        while (current > 0) {
            int parent = (current - 1) / 2;
            if (heap.get(current).compareTo(heap.get(parent)) < 0) {
                swap(current, parent);
                current = parent;
            } else {
                break;
            }
        }
    }

    @Override
    public E removeMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Priority Queue is empty");
        E minItem = heap.get(0);
        E lastItem = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            int current = 0;
            while (true) {
                int left = 2 * current + 1;
                int right = 2 * current + 2;
                int smallest = current;

                if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
                    smallest = left;
                }
                if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
                    smallest = right;
                }
                if (smallest != current) {
                    swap(current, smallest);
                    current = smallest;
                } else {
                    break;
                }
            }
        }
        return minItem;
    }

    @Override
    public E peekMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Priority Queue is empty");
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    @Override
    public int size() {
        return heap.size();
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
}
