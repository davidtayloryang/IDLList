package classes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDLListTest {

	@Test
	void testAdd() {
		IDLList<Integer> a = new IDLList<Integer>();
		assertEquals(true, a.add(0));
		assertEquals(true, a.add(2));
		assertEquals(true, a.add(3));
	}
	
	@Test
	void testAppend() {
		IDLList<Integer> a = new IDLList<Integer>();
		assertEquals(true, a.append(3));
		assertEquals(true, a.append(4));
		assertEquals(true, a.append(5));
		assertEquals(true, a.append(6));
		assertEquals(true, a.append(7));
	}
	
	@Test
	void testRemove() {
		IDLList<Integer> a = new IDLList<Integer>();
		a.add(1);
		assertEquals(false, a.remove(3).toString());
		assertEquals(false, a.remove(6).toString());
		assertEquals(false, a.remove(5).toString());
		assertEquals(true, a.remove(1).toString());
	}
	
	@Test
	void testGetHead() {
		IDLList<Integer> a = new IDLList<Integer>();
		a.add(1);
		assertEquals(1, a.getHead().toString());
		a.add(2);
		assertEquals(2, a.getHead().toString());
		
	}
	
	@Test
	void testGet() {
		IDLList<Integer> a = new IDLList<Integer>();
		a.add(1);
		a.add(1);
		a.add(1);
		assertEquals(1, a.get(1).toString());
		assertEquals(1, a.get(2).toString());
		assertEquals(1, a.get(0).toString());
	}
	
	@Test
	void testGetLast() {
		IDLList<Integer> a = new IDLList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		assertEquals(1, a.getLast().toString());
		a.add(4);
		assertEquals(1, a.getLast().toString());
		a.add(5);
		assertEquals(1, a.getLast().toString());
	}

	@Test
	void testRemoveLast() {
		IDLList<Integer> a = new IDLList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		assertEquals(3, a.removeLast().toString());
		a.add(4);
		assertEquals(1, a.removeLast().toString());
		a.add(5);
		assertEquals(1, a.removeLast().toString());
	}
	
}
