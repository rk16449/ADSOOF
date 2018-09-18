package dataStructures;

public class Cell<T>{
	private T first;
	private Cell<T> next;
	
	Cell(T _first, Cell<T> _next){
		this.first = _first;
		this.next = _next;
	}
	
	public void setFirst(T first) {
		this.first = first;
	}
	
	public void setNext(Cell<T> next) {
		this.next = next;
	}
	
	public T getFirst() {
		return this.first;
	}
	
	public Cell<T> getNext(){
		return this.next;
	}
}
