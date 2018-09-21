package dataStructures;

import java.lang.reflect.Array;

public class LinkedHashTable<T> extends SuperHash<T> implements IHashTable<T> {

	// Generic Hash Table that supports separate chaining
	// Uses a prime number as array size
	// Underlining data structure is an array
	
	LinkedList<T>[] myArray;
	
	@SuppressWarnings("unchecked")
	public LinkedHashTable(int size) {
		// Make sure its prime sized
		arraySize = getNextPrime(size);

		// Try to set it normally?
		myArray = new LinkedList[arraySize];
		
		System.out.println("Size of normal linked list generic: " + myArray.length);
		
		count = 0;
	}

	public void insert(T obj) {
		// calculate hash indexes
		// calculate the step required

		if (count >= arraySize)
			throw new IndexOutOfBoundsException("Hash Table is full!");

		int hashIndex = hashIndexOne(obj);
		
		System.out.println("Hash index to check insert: " + hashIndex);

		// if it isn't null then we have a linked list, just add it to the linked list
		if(myArray[hashIndex] != null) {
			
			boolean found = false;
			// check if its a duplicate by looping through the linked list
			for(Cell<T> ptr = myArray[hashIndex].getList(); ptr != null; ptr = ptr.getNext()) {
				
				// we have a match, increase its count
				if(ptr.getFirst().equals(obj)) {
					ptr.inc();
					found = true;
					break;
				}
			}
			
			// We didn't find anything in the linked list, so just insert it into the linked list
			if(!found) {
				myArray[hashIndex] = myArray[hashIndex].cons(obj);
			}
		}else {
			// add a new linked list in this element
			myArray[hashIndex] = new LinkedList<T>(new Cell<T>(obj, null));
		}
	}

	public void delete(T obj) {

		

	}

	public void update(T obj1, T obj2) {
		// calculate the hash index

		// find obj1

		// if obj1 is found then remove it entirely, and re-insert obj2 into the linked
		// list
	}

	public void updateCount(T obj, int count) {
		// calculate hash/index

		// set the value of the count of the obj if found
	}

	@Override
	public boolean exists(T obj) {
		
		// calculate hash/step
		int hashIndex = hashIndexOne(obj);
		
		System.out.println("Hash index to check exists: " + hashIndex);

		// check if this index is not null
		if(myArray[hashIndex] != null) {
			
			// if its not null check inside the LinkedList if the value exists
			for(Cell<T> ptr = myArray[hashIndex].getList();  ptr != null; ptr = ptr.getNext()) {
				
				if(ptr.getFirst().equals(obj)) {
					return true;
				}
				
			}
		}
		return false;
	}

	@Override
	public void resize(int num) {
		// TODO Auto-generated method stub
	}
}
