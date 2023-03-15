package fr.iut.but1.qdev;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

class TestBoundedQueue2 {
	private BoundedQueue test;
	private int capacity; 
	private BoundedQueue testEmpty;
	
	
	@BeforeEach
	void setup() {
		test = new BoundedQueue(10);
		capacity = 10;
		for (int i=0;i<9;i++) {
			test.push(i);
		}
		testEmpty = new BoundedQueue(10);
	}
	
	@Test
	void testCapacity() {
		assertEquals(test.capacity(),this.capacity);
	}

	@Test
	void testIsEmpty() {
		assertTrue(testEmpty.isEmpty());
		test.push(1);
		assertFalse(test.isEmpty());
	}
	
	@Test
	void testIsFull() {
		assertFalse(test.isFull()); 
		test.push(10);
		assertTrue(test.isFull());
	}
	
	@Test
	void testSize() {
		test.push(1);
		assertEquals(test.size(),10);
	}
	
	@Test
	void testPush() {
		int taille = test.size();
		testEmpty.push(0);
		assertFalse(testEmpty.isEmpty());
		assertNotEquals(taille,testEmpty.size());
		//int value = test.pop();
		//assertEquals(value,0);
		
	}
	
	@Test
	void testPop() {
		//v�rifer que la capacit� ne change pas 
		test.push(1);
		assertTrue(test.isFull());
		test.pop();
		assertFalse(test.isFull());
	}
	

}
