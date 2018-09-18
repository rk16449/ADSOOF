package dataStructures;

import java.lang.reflect.Array;

public class LinkedHashTable<T> extends SuperHash<T> implements IHashTable<T> {

	// Generic Hash Table that supports separate chaining
	// Uses a prime number as array size
	// Underlining data structure is an array

	LinkedList<T>[] myArray;

	@SuppressWarnings("unchecked")
	public LinkedHashTable(Class<T> type, int size) {
		// Make sure its prime sized
		arraySize = getNextPrime(size);

		// Initialize the LinkedList array with the size given
		myArray = (LinkedList<T>[]) Array.newInstance(type, arraySize);

		count = 0;
	}

	public void insert(T obj) {
		// calculate hash indexes
		// calculate the step required

		if (count >= arraySize)
			throw new IndexOutOfBoundsException("Hash Table is full!");

		int hashIndex = hashIndexOne(obj);

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
		}
	}

	public void delete(T obj) {

		// calculate hash/step

		// check if this index is not null

		// if its not null check inside the LinkedList if the value exists

		// if it exists check the count value, if its 1 then we need to delete it
		// entirely

		// if its above 1 just decrement the count instead
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void resize(int num) {
		// TODO Auto-generated method stub
	}
}
