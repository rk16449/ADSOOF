package dataStructures;

import java.lang.reflect.Array;

public class LinkedHashTable<T> extends SuperHash<T> implements IHashTable<T> {

	// Generic Hash Table that supports separate chaining
	// Uses a prime number as array size
	// Underlining data structure is an array

	LinkedList<T>[] rgLL;

	@SuppressWarnings("unchecked")
	public LinkedHashTable(int size) {

		// Validate arguments
		validateSize(size);

		// Make sure its prime sized
		arraySize = getNextPrime(size);

		// Initialize range of Linked Lists
		rgLL = new LinkedList[arraySize];

		// Set the entries value to 0
		entries = 0;
	}

	private void validateSize(int size) {
		if (size <= 0)
			throw new IllegalArgumentException("Invalid size entered!");
	}

	private void isHashTableFull() {
		if (entries >= arraySize)
			throw new IndexOutOfBoundsException("Hash Table is full!");
	}

	private boolean isDuplicate(T obj, int i) {
		boolean found = false;

		// check if its a duplicate by looping through the linked list
		for (Cell<T> ptr = rgLL[i].getList(); ptr != null; ptr = ptr.getNext()) {
			// we have a match
			if (ptr.getFirst().equals(obj)) {
				// increase its count
				ptr.inc();
				found = true;
				break;
			}
		}

		return found;
	}

	public void insert(T obj) {
		// Check hash table isn't full
		isHashTableFull();

		// Calculate hash index
		int i = hashIndexOne(obj);

		// if it isn't null then we have a linked list, just add it to the linked list
		if (rgLL[i] != null) {
			// Check if its a duplicate (increases its count,
			// if its not a duplicate, it'll attach as a new entry
			if (!isDuplicate(obj, i)) {
				rgLL[i] = rgLL[i].cons(obj);
			}
		} else {
			// add a new linked list in this element
			rgLL[i] = new LinkedList<T>(new Cell<T>(obj, null));
		}
	}

	public void delete(T obj) {

		// Calculate hash value
		int i = hashIndexOne(obj);

		System.out.println("Deleteing at index: " + i);

		// check there is something on the index
		if (rgLL[i] != null) {

			System.out.println("Linked List exists at index;");

			// check in the LinkedList if the obj exists there, if it does check its count
			// value, dec if > 1

			for (Cell<T> ptr = rgLL[i].getList(); ptr != null; ptr = ptr.getNext()) {
				// is there a match?
				if (ptr.getFirst().equals(obj)) {
					// check the count, decrement it, else delete it
					if (ptr.getCount() > 1) {
						ptr.dec();
					} else {
						rgLL[i].delete(obj);
					}
					break;
				}
			}
		}
	}

	public void update(T obj1, T obj2) {

		// calculate the hash index
		int i = hashIndexOne(obj1);

		if (rgLL[i] != null) {

		}

		// if obj1 is found then remove it entirely, and re-insert obj2
	}

	// Returns the count of a certain object in the Hash Table / Linked List
	public int getCount(T obj) {

		// calculate hash value
		int i = hashIndexOne(obj);

		if (rgLL[i] != null) {

			// Loop through the linked list until obj is found
			for (Cell<T> ptr = rgLL[i].getList(); ptr != null; ptr = ptr.getNext()) {

				// Match found, return the count value!
				if (ptr.getFirst().equals(obj)) {
					return ptr.getCount();
				}
			}
		}

		// Else no count found
		return 0;
	}

	public void updateCount(T obj, int count) {
		// calculate hash/index
		int i = hashIndexOne(obj);
	}
	// set the value of the count of the obj if found

	@Override
	public boolean exists(T obj) {

		// calculate hash/step
		int i = hashIndexOne(obj);

		System.out.println("Hash index to check exists: " + i);

		// check if this index is not null
		if (rgLL[i] != null) {

			// if its not null check inside the LinkedList if the value exists
			for (Cell<T> ptr = rgLL[i].getList(); ptr != null; ptr = ptr.getNext()) {

				if (ptr.getFirst().equals(obj)) {
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
