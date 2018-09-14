package dataStructures;

import java.lang.reflect.Array;

public class  SingleHashTable <T> {

	// Generic HashTable without separate chaining (no linked lists)
	// Uses prime numbers
	// Uses an underlining array data structure
	
	// the underlining array
	private T[] internalArray;
	
	// counts how many entries are filled
	private int count;
	
	// lets us know the array size
	private int arraySize;
	
	
	@SuppressWarnings("unchecked")
	public SingleHashTable(Class<T> type, int size) {
		
		arraySize = getNextPrime(size);
		
		// Initialize array with the class type
		internalArray = (T[]) Array.newInstance(type, size);
		
		System.out.println("Array size is set to: " + arraySize);
	}
	
	
	// returns the next available prime number
	private int getNextPrime(int size) {
		
		// Keep looping until we are a prime number
		while(true) {
			
			if(isPrime(size)) {
				return size;
			}
			
			// Else increment
			size++;
		}
		
	}
	
	// returns true if prime number
	private boolean isPrime(int num) {
		// Start from 3, and increment by 2 (ignore even numbers)
		for(int i=3; i<num; i+=2) {
			// Check if it can be divided into num
			if(num % i == 0) {
				return false;
			}
		}
		// Must be prime
		return true;
	}
	
	public int getArraySize() {
		return this.arraySize;
	}
	
	public int getCount() {
		return this.count;
	}
}
