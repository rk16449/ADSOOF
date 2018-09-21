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
	 * Test method for
	 * {@link dataStructures.LinkedHashTable#LinkedHashTable(java.lang.Class, int)}.
	 */
	@Test
	final void testLinkedHashTable() {
		try {
			new LinkedHashTable<String>(0);
			fail("Exception was expected for 0 input");
		} catch (IllegalArgumentException e) {
		}

		try {
			new LinkedHashTable<String>(-1);
			fail("Exception was expected for negative input");
		} catch (IllegalArgumentException e) {
		}
	}

	@Test
	final void testInsert() {
		// Create a linked list based hash table that stores strings
		LinkedHashTable<String> htWords = new LinkedHashTable<String>(5000);

		// Insert the word 'Hello'
		htWords.insert("Hello");

		// Check that it exists in the hash table
		assertEquals(true, htWords.exists("Hello"));
	}

	@Test
	final void testDelete() {
		LinkedHashTable<String> htWords = new LinkedHashTable<String>(5000);

		// Insert the word 'Hello'
		htWords.insert("Hello");

		// Delete it from the hash table
		htWords.delete("Hello");

		// Check that it no longer exists
		assertEquals(false, htWords.exists("Hello"));
	}

	@Test
	final void testCount() {
		LinkedHashTable<String> htWords = new LinkedHashTable<String>(5000);

		// Insert 500 'Test' strings
		for (int i = 0; i < 500; i++) {
			htWords.insert("Test");
		}

		// check that we have a count of 500 test objects
		assertEquals(500, htWords.getCount("Test"));
	}

}
