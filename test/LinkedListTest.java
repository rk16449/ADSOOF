import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.Cell;
import dataStructures.LinkedList;

/**
 * 
 */

/**
 * @author Raj
 *
 */
class LinkedListTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link dataStructures.LinkedList#empty()}.
	 */
	@Test
	void testEmpty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.LinkedList#cons(java.lang.Object)}.
	 */
	@Test
	void testCons() {
		
		
		// Creates a linked list object order: -> 10, -> 50, -> 100
		LinkedList<Integer> listObjs = LinkedList.createLinkedList(new Integer[] {100, 50, 10});
		
		// Add 10 to the front of the list
		listObjs = listObjs.cons(5);
		
		// Verify it exists
		for(Cell<Integer> ptr = listObjs.getList();  ptr != null; ptr = ptr.getNext()) {
			System.out.println(ptr.getFirst());
		}
		
		
		assertEquals(Integer.valueOf(5), listObjs.getList().getFirst());
	}

	/**
	 * Test method for {@link dataStructures.LinkedList#main(java.lang.String[])}.
	 */
	@Test
	void testMain() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link dataStructures.LinkedList#createLinkedList(T[])}.
	 */
	@Test
	void testCreateLinkedList() {
		fail("Not yet implemented");
	}

}
