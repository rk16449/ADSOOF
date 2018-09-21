package dataStructures;

public class Cell<T>{
	private T first;
	private int count;
	private Cell<T> next;
	
	Cell(T _first, Cell<T> _next){
		this.first = _first;
		this.next = _next;
		
		// if something was set into first, we need to increment the count
		if(_first != null) count++;
	}
	
	public void inc() {
		count++;
	}
	
	public void dec() {
		count--;
	}
	
	public void setCount(int count) {
		this.count = count;
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
