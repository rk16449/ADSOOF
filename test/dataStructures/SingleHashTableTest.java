package dataStructures;
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
		assertEquals(true, singleHT.exists(word));
	}
	
	@Test
	void testUpdateString() {
		
		// Insert word into hash table
		singleHT.insert(word);
		
		// confirm it exists
		assertEquals(true, singleHT.exists(word));
		
		String replacement = "Test";
		
		// update the word
		singleHT.update(word, replacement);
		
		// confirm that word no longer exists
		assertEquals(false, singleHT.exists(word));
	
		// check that the replacement word exists
		assertEquals(true, singleHT.exists(replacement));
	}
	
	@Test
	void testFindWhenDeletedString() {
		// Insert the word into the HT
		singleHT.insert(word);
		
		// Test that it exists
		assertEquals(true, singleHT.exists(word));
		
		// Delete it from the HT
		singleHT.delete(word);
		
		// Test that it no longer exists
		assertEquals(false, singleHT.exists(word));
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
	
	
	@Test
	void testFindWhenHashTableResized() {
		
		String[] words = {"Hello", "World", "Apple", "Bear", "Cow", "Horse", "Water"};
		
		
		// Insert and check if they exist
		for(int i=0; i<words.length; i++) {
			singleHT.insert(words[i]);
			assertEquals(true, singleHT.exists(words[i]));
		}
		
		
		// Check how many was actually filled
		assertEquals(7, singleHT.getEntries());
		
		// Resize the Hash Table
		singleHT.resize(1000000);
		
		// Check that our size changed (next prime number is 1000003)
		assertEquals(1000003, singleHT.getArraySize());
		
		// Check if values still exist
		for(int i=0; i<words.length; i++) {
			assertEquals(true, singleHT.exists(words[i]));
		}
		
		// Check that there is still 7
		assertEquals(7, singleHT.getEntries());
				
		// Insert more words (7 * 10000)
		for(int z=0; z<10000; z++) {
			for(int i=0; i<words.length; i++) {
				singleHT.insert(words[i] + " i: " + i);
			}
		}
		
		// Check that there is now 7 + (7 * 10000) words
		assertEquals(7 + (7*10000), singleHT.getEntries());
	}
}
