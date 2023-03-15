package fr.iut.but1.qdev;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestQueue{

    BoundedQueue f0, f1, f2, f3;

    @BeforeEach
    public void setUp(){
        f0 = new BoundedQueue(3);
        f1 = new BoundedQueue(10);
        f2 = new BoundedQueue(0);
        f3 = new BoundedQueue(2);

        f3.push(4);
    }


    @Test
    public void testIsEmpty() {
        assertTrue(f0.isEmpty());
        assertFalse(f3.isEmpty());
    }

    @Test
    public void testPush() {
        assertTrue(f0.isEmpty());
        f0.push(2);
        assertFalse(f0.isEmpty());
    }

    @Test
    public void testPushAndPop() {
        assertTrue(f0.isEmpty());
        f0.push(2);
        int popped = f0.pop();
        assertEquals(2, popped);
    }

    @Test
    public void testSize() {
        assertTrue(f0.isEmpty());
        f0.push(2);
        assertEquals(1, f0.size());
    }

    @Test
    public void testCapacity() {
        assertEquals(10, f1.capacity());
    }

    @Test
    public void testPopFailed(){
        int tmpSize = f2.size();
        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            f2.pop();
        });


        assertEquals(tmpSize, f2.size());
        assertEquals("already empty", exception.getMessage());
    }

    @Test
    public void testPushOversize() {
        Throwable exception = assertThrows(IllegalStateException.class, () -> {
            f2.push(3);
        });
        assertEquals("Maximum size reached", exception.getMessage());
    }

    @Test
    public void testOrder() {
        assertTrue(f1.isEmpty());
        for(int i = 0; i < 10; i++){
            f1.push(i);
        }

        for(int j = 9; j < 0; j++){
            assertEquals(j, f1.pop());
        }
    }

    @Test
    public void testIsFull(){
        for(int i = 0; i < 10; i++){
            f1.push(i);
        }
        assertTrue(f1.isFull());
    }

}