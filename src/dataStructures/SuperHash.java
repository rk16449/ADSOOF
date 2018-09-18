package dataStructures;

public abstract class SuperHash<T> {

	// counts how many entries are filled
	protected int count;

	// lets us know the array size
	protected int arraySize;

	// stores the type
	protected Class<T> internalType;
		

	// returns the next available prime number
	protected int getNextPrime(int size) {
		// Keep looping until we are a prime number
		while (true) {
			if (isPrime(size)) {
				return size;
			}
			// Else increment
			size++;
		}

	}

	// returns true if prime number
	protected boolean isPrime(int num) {
		// Start from 3, and increment by 2 (ignore even numbers)
		for (int i = 3; i < num; i += 2) {
			// Check if it can be divided into num
			if (num % i == 0) {
				return false;
			}
		}
		// Must be prime
		return true;
	}
	
	// our ideal index
	protected int hashIndexOne(T object) {
		return hash(object);
	}
	
	protected int hashIndexTwo(T object) {
		return 7 - hash(object) % 7;
	}
	
	protected int hash(T object) {
		int hashVal = object.hashCode() % arraySize;
		if(hashVal < 0) hashVal += arraySize;
		return hashVal;
	}
	
	
	protected int getArraySize() {
		return this.arraySize;
	}
	
	protected int getCount() {
		return this.count;
	}
	
	protected Class<T> getType(){
		return internalType;
	}

}
