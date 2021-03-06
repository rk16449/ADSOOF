package dataStructures;

import java.lang.reflect.Array;

// TODO - FIX using double T
public class  SingleHashTable<T> extends SuperHash<T> implements IHashTable<T>{

	// Generic HashTable without separate chaining (no linked lists)
	// Uses prime numbers
	// Uses an underlining array data structure
	
	// the underlining array
	private T[] internalArray;
	
	
	
	@SuppressWarnings("unchecked")
	public SingleHashTable(Class<T> type, int size) {
		arraySize = getNextPrime(size);
		internalType = type;
		// Initialize array with the class type (+1) needed to keep array size correct
		internalArray = (T[]) Array.newInstance(type, arraySize);
	}
	
	@Override
	public void delete(T object) {
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);
		
		while(internalArray[hashIndex] != null) {
			
			// check if its the same object
			if(internalArray[hashIndex].equals(object)) {
				// Make it equal to null (let GC handle the rest)
				internalArray[hashIndex] = null;
				entries--;
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
		if(size < entries) throw new IllegalArgumentException("Hash table must be able to fit previous elements!");
		
		// Create the new size and copy array
		int newSize = getNextPrime(size);
		T[] copyArray = (T[]) Array.newInstance(internalType, newSize + 1);
		
		// Copy all objects in internalArray into newArray
		for(int i=0; i<arraySize; i++) {
			copyArray[i] = internalArray[i];
		}
		
		// Blank T[] array to store values into
		T[] newArray = (T[]) Array.newInstance(internalType, newSize + 1);
		
		// Delete current values by assigning internal Array as new array
		internalArray = newArray;
		arraySize = newSize;
		entries = 0;
		
		// Insert all the values back in
		for(int i=0; i<copyArray.length; i++) {
			if(copyArray[i] != null) insert(copyArray[i]);
		}
	}
	
	@Override
	public boolean exists(T object) {
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
	
	@Override
	// inserts a generic object into the generic array
	public void insert(T object){
		// checks we haven't filled up the array
		if(entries >= arraySize) throw new IndexOutOfBoundsException("Hash Table is full!");
		
		int hashIndex = hashIndexOne(object);
		int step = hashIndexTwo(object);

		// If this isn't an empty node, move by a step until we find a free node
		while(internalArray[hashIndex] != null) {
			hashIndex += step;
			hashIndex %= arraySize;
		}
		
		// Insert it
		internalArray[hashIndex] = object;
		entries++;
	}
}
