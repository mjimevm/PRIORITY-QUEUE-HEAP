package org.heap;

import java.util.NoSuchElementException;
import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    private Vector<E> heap;
    /**
     * Constructor para inicializar el heap como un Vector vacío.
     */
    public VectorHeap() {
        heap = new Vector<>();
    }
    /**
     * Método para insertar un nuevo elemento en el heap. El elemento se agrega al final del Vector y luego se ajusta la posición del nuevo elemento hacia arriba (heapify up) para mantener la propiedad de heap.
     * @param item El elemento a insertar en el heap. Debe implementar la interfaz Comparable para poder comparar prioridades.
     */
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
    /**
     * Método para eliminar y retornar el elemento con la mayor prioridad (el mínimo) del heap. El método reemplaza el elemento raíz con el último elemento del Vector, lo elimina y luego ajusta la posición del nuevo elemento raíz hacia abajo (heapify down) para mantener la propiedad de heap. Si el heap está vacío, se lanza una excepción NoSuchElementException.
     * @return El elemento con la mayor prioridad (el mínimo) que fue eliminado del heap
     */
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
    /**
     * Método para retornar el elemento con la mayor prioridad (el mínimo) del heap sin eliminarlo. Si el heap está vacío, se lanza una excepción NoSuchElementException.
     * @return El elemento con la mayor prioridad (el mínimo) del heap sin eliminarlo
     */
    @Override
    public E peekMin() {
        if (heap.isEmpty()) throw new NoSuchElementException("Priority Queue is empty");
        return heap.get(0);
    }
    /**
     * Método para verificar si el heap está vacío. Retorna true si el heap no contiene elementos, de lo contrario retorna false.
     * @return true si el heap está vacío, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    /**
     * Método para retornar el número de elementos actualmente almacenados en el heap.
     * @return El número de elementos en el heap
     */
    @Override
    public int size() {
        return heap.size();
    }
    /**
     * Método para intercambiar dos elementos en el heap.
     * @param i Índice del primer elemento
     * @param j Índice del segundo elemento
     */
    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
}
