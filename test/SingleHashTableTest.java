import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructures.SingleHashTable;

class SingleHashTableTest {

	@Test
	void testConstructor() {
		
		// Setup Hash Table of 100 string objects
		SingleHashTable<String> singleHT = new SingleHashTable<String>(String.class, 100);
		
	}

}
