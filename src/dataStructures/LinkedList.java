package dataStructures;

public class LinkedList<E> {
	
	class Cell<T>{
		T first;
		Cell<T> next;
		
		Cell(T _first, Cell<T> _next){
			this.first = _first;
			this.next = _next;
		}
	}
	
	private Cell<E> myList;

	private LinkedList(Cell<E> list) {
		myList = list;
	}
	
	public static <T> LinkedList<T> empty() {
		return new LinkedList<T>(null);
	}
	
	public LinkedList<E> cons(E item) {
		return new LinkedList<E>(new Cell<E>(item, myList));
	}

	public static void main(String[] args) {
		// Create a Linked List
		LinkedList<Integer> integerList = createLinkedList(new Integer[]{4, 5, 6, 4});
	}
	
	// Creates and returns a T linked list
	public static <T> LinkedList<T> createLinkedList(T[] vals){
		
		LinkedList<T> list = empty();
		
		for(int i=0; i<vals.length; i++) {
			list = list.cons(vals[i]);
		}
		
		return list;
	}

}
