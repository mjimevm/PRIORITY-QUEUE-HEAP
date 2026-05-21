package org.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class VectorHeapTest {
    private VectorHeap<Integer> heap;
    @BeforeEach
    public void setUp() {
        heap = new VectorHeap<>();
    }
    @Test
    public void testInsertAndRemove() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        assertEquals(1, heap.removeMin());
        assertEquals(3, heap.removeMin());
        assertEquals(5, heap.removeMin());
        assertEquals(8, heap.removeMin());
    }
    @Test
    public void testPeek() {
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);
        assertEquals(1, heap.peekMin());
        assertEquals(1, heap.removeMin());
        assertEquals(3, heap.peekMin());
    }
    @Test
    public void testIsEmpty() {        
        assertTrue(heap.isEmpty());
        heap.insert(5);
        assertFalse(heap.isEmpty());
        heap.removeMin();
        assertTrue(heap.isEmpty());
    }
    @Test
    public void testRemoveFromEmpty() {
        assertThrows(java.util.NoSuchElementException.class, () -> {
            heap.removeMin();
        });
    }
}
