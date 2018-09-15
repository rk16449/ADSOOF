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
		
		// Initialize array with the class type (+1) needed to keep array size correct
		internalArray = (T[]) Array.newInstance(type, size + 1);
		
		System.out.println("Array size is set to: " + arraySize);
		System.out.println("Actual array size is set to: " + internalArray.length);
	}
	
	public void delete(T object) {
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);
		
		while(internalArray[hashIndex] != null) {
			
			// check if its the same object
			if(internalArray[hashIndex].equals(object)) {
				// Make it equal to null (let gc handle the rest)
				internalArray[hashIndex] = null;
				count--;
				break;
			}
			
			hashIndex += step;
			hashIndex %= arraySize;
		}
	}
	
	public boolean find(T object) {
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);
		
		while(internalArray[hashIndex] != null) {
			
			// check if its the same object
			if(internalArray[hashIndex].equals(object)) {
				return true;
			}
			
			hashIndex += step;
			hashIndex %= arraySize;
		}
		return false;
	}
	
	// inserts a generic object into the generic array
	public void insert(T object) throws IndexOutOfBoundsException{
		
		
		System.out.println("Count: " + count);
		System.out.println("Array Size: " + arraySize);
		
		// checks we haven't filled up the array
		if(count >= arraySize) {
			throw new IndexOutOfBoundsException("Hash Table is full!");
		}
		
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);
		
		
		
		System.out.println("Hash index found: " + hashIndex);
		
		
		// If this isn't an empty node, move by a step until we find a free node
		while(internalArray[hashIndex] != null) {
			hashIndex += step;
			hashIndex %= arraySize;
		}
		
		
		
		
		// Insert it
		internalArray[hashIndex] = object;
		count++;
	}
	
	
	// our ideal index
	private int hashIndexOne(T object) {
		
		int hashVal = hash(object);
		
		return hashVal;
	}
	
	private int hashIndexTwo(T object) {
		
		int hashVal = hash(object);

		return 7 - hashVal % 7;
	}
	
	private int hash(T object) {
		int hashVal = object.hashCode() % arraySize;
		if(hashVal < 0) hashVal += arraySize;
		return hashVal;
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
