import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dataStructures.SingleHashTable;

class SingleHashTableTest {
	
	SingleHashTable<String> singleHT;
	
	@BeforeEach
	public void beforeEach() {
		
		// Setup Hash Table of 100 string objects
		singleHT = new SingleHashTable<String>(String.class, 100);
	}

	@Test
	void testFindWhenInsertedString() {
		
		
		String test = "Hello World";
		
		// Insert a test String object
		singleHT.insert(test);
		
		// we expect it to be true, but its actually whatever the find method returns
		assertEquals(true, singleHT.find(test));
	}

}
