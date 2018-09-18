package dataStructures;

import java.lang.reflect.Array;

public class LLHashTable <T> extends SuperHash{

	// Generic Hash Table that supports separate chaining
	// Uses a prime number as array size
	// Underlining data structure is an array
	
	LinkedList<T>[] myArray;
	
	
	public LLHashTable(Class<T> type, int size) {
		// Make sure its prime sized
		arraySize = getNextPrime(size);
		
		// Initialize the LinkedList array with the size given
		myArray = (LinkedList<T>[]) Array.newInstance(type, size + 1);
		
		count = 0;
	}
	
	
	public void insert(T obj) {
		// calculate hash indexes
		// calculate the step required
		
		
		// check that this node is null
		
		// if it isn't null then we have a linked list, just add it to the linked list
		
		// if its a duplicate, increase the linked list count instead
	}
	
	
	public void delete(T obj) {
		
		// calculate hash/step
		
		
		// check if this index is not null
		
		// if its not null check inside the linkedlist if the value exists
		
		
		// if it exists check the count value, if its 1 then we need to delete it entirely
		
		// if its above 1 just decrement the count instead
	}
	
	
	
	public void update(T obj1, T obj2) {
		// calculate the hash index
		
		// find obj1
		
		// if obj1 is found then remove it entirely, and re-insert obj2 into the linked list
	}
	
	public void updateCount(T obj, int count) {
		// calculate hash/index
		
		// set the value of the count of the obj if found
	}
	
	
}
