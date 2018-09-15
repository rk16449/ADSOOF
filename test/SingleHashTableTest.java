import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import dataStructures.SingleHashTable;

class SingleHashTableTest {
	
	SingleHashTable<String> singleHT;
	String word;
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	
	@BeforeEach
	public void beforeEach() {
		// Setup Hash Table of 100 string objects
		singleHT = new SingleHashTable<String>(String.class, 100);
		
		// Setup the test word
		word = "Hello";
	}

	@Test
	void testFindWhenInsertedString() {
		// Insert a test String object
		singleHT.insert(word);
		
		// we expect it to be true, but its actually whatever the find method returns
		assertEquals(true, singleHT.find(word));
	}
	
	@Test
	void testUpdateString() {
		
		// Insert word into hash table
		singleHT.insert(word);
		
		// confirm it exists
		assertEquals(true, singleHT.find(word));
		
		String replacement = "Test";
		
		// update the word
		singleHT.update(word, replacement);
		
		// confirm that word no longer exists
		assertEquals(false, singleHT.find(word));
	
		// check that the replacement word exists
		assertEquals(true, singleHT.find(replacement));
	}
	
	@Test
	void testFindWhenDeletedString() {
		// Insert the word into the HT
		singleHT.insert(word);
		
		// Test that it exists
		assertEquals(true, singleHT.find(word));
		
		// Delete it from the HT
		singleHT.delete(word);
		
		// Test that it no longer exists
		assertEquals(false, singleHT.find(word));
	}
	
	@Test
	void throwsIndexOutOfBoundsOnHashTableFull() {
		// Tests the index out of bounds if we try to insert more than the hash table has
		@SuppressWarnings("unused")
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> {
			for(int i=0; i<singleHT.getArraySize() + 100; i++) {
				singleHT.insert(word + i);
			}
	    });
	}

}
