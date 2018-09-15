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
	
	// stores the type
	private Class<T> internalType;
	
	
	@SuppressWarnings("unchecked")
	public SingleHashTable(Class<T> type, int size) {
		arraySize = getNextPrime(size);
		internalType = type;
		// Initialize array with the class type (+1) needed to keep array size correct
		internalArray = (T[]) Array.newInstance(type, size + 1);
	}
	
	public void delete(T object) {
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);
		
		while(internalArray[hashIndex] != null) {
			
			// check if its the same object
			if(internalArray[hashIndex].equals(object)) {
				// Make it equal to null (let GC handle the rest)
				internalArray[hashIndex] = null;
				count--;
				break;
			}
			
			hashIndex += step;
			hashIndex %= arraySize;
		}
	}
	
	// Resizes the hash table
	@SuppressWarnings("unchecked")
	public void resize(int size) {
		
		// Check if our count variable is bigger
		if(count >= size) throw new IllegalArgumentException("Hash table must be able to fit previous elements!");
		
		// Create the new size and array
		int newSize = getNextPrime(size);
		T[] newArray = (T[]) Array.newInstance(internalType, newSize + 1);
		T[] copyArray = (T[]) Array.newInstance(internalType, newSize + 1);
		
		// Copy all objects in internalArray into newArray
		for(int i=0; i<arraySize; i++) {
			copyArray[i] = internalArray[i];
		}
		
		// Delete current values by assigning internal Array as new array
		internalArray = newArray;
		
		// Insert all the values back in
		for(int i=0; i<copyArray.length; i++) {
			insert(copyArray[i]);
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
	
	// Finds an object specified and changes it
	public boolean update(T object, T replacement) {
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);
		
		while(internalArray[hashIndex] != null) {
			
			// check if its the same object
			if(internalArray[hashIndex].equals(object)) {
				// change the reference to replacement (let GC handle the rest)
				internalArray[hashIndex] = null;
				
				// insert it into the hash table (since we need the same indexes)
				insert(replacement);
				
				return true;
			}
			
			hashIndex += step;
			hashIndex %= arraySize;
		}
		return false;
	}
	
	// inserts a generic object into the generic array
	public void insert(T object) throws IndexOutOfBoundsException{
		// checks we haven't filled up the array
		if(count >= arraySize) throw new IndexOutOfBoundsException("Hash Table is full!");
		
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);

		// If this isn't an empty node, move by a step until we find a free node
		while(internalArray[hashIndex] != null) {
			hashIndex += step;
			hashIndex %= arraySize;
		}
		
		// Insert it
		internalArray[hashIndex] = object;
		count++;
	}
	
	public int getArraySize() {
		return this.arraySize;
	}
	
	public int getCount() {
		return this.count;
	}

	// our ideal index
	private int hashIndexOne(T object) {
		return hash(object);
	}
	
	private int hashIndexTwo(T object) {
		return 7 - hash(object) % 7;
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
}
