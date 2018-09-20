package dataStructures;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Raj
 *
 */
class LinkedHashTableTest {

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
	 * Test method for {@link dataStructures.LinkedHashTable#LinkedHashTable(java.lang.Class, int)}.
	 */
	@Test
	final void testLinkedHashTable() {
		fail("Not yet implemented"); // TODO
	}
	
	@Test
	final void testInsert() {
		// Create a linked list based hash table that stores strings
		LinkedHashTable<String> htWords = new LinkedHashTable<String>(String.class, 5000);
		
		// Insert the word 'Hello'
		//htWords.insert("Hello");
		
		// Check that it exists in the hash table
		//assertEquals(true, htWords.exists("Hello"));
	}

}
