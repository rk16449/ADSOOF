package dataStructures;

public class LinkedList<E> {

	private Cell<E> myList;

	private LinkedList(Cell<E> list) {
		myList = list;
	}
	
	public Cell<E> getList(){
		return this.myList;
	}
	
	public static <E> LinkedList<E> empty() {
		return new LinkedList<E>(null);
	}
	
	// Remove element from LinkedList
	public boolean delete(E item){
		
		if(myList.getFirst().equals(item)) {
			
			
			if(myList.getNext() != null) {
				myList = myList.getNext();
			}else {
				myList = null;
			}
			
			return true;
		}
		
		// Loop through the linked list elements until item found
		// make the next value equal to the node after
		for(Cell<E> ptr = myList; ptr.getNext() != null; ptr = ptr.getNext()) {
			
			
			
			
			// Remove it by changing the ptr references
			if(ptr.getNext().equals(item)) {
				
				
				if(ptr.getNext().getNext() != null) {
					ptr.setNext(ptr.getNext().getNext());
				}else {
					ptr.setNext(null);
				}
				
				
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
	
	/**
	 * Constructs a new LinkedList and attaches an item at the front of it
	 * @param item
	 * @return
	 */
	public LinkedList<E> cons(E item) {
		return new LinkedList<E>(new Cell<E>(item, myList));
	}
	
	// Creates and returns a T linked list
	public static <E> LinkedList<E> createLinkedList(E[] vals){
		
		LinkedList<E> list = empty();
		
		for(int i=0; i<vals.length; i++) {
			list = list.cons(vals[i]);
		}
		
		return list;
	}

}
