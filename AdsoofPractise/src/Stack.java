
public class Stack {
	
	public static void main(String[] args) {
		
	}
	
	private int maxSize;
	private int topElement;
	private Data[] list;
	
	// Returns false if topElement is 0
	public boolean isEmptyStack() {
		return topElement != 0;
	}
	
	public void isFullStack() {
		
	}
	
	public void initializeStack() {
		for(int i=0; i<maxSize; i++) {
			list[i] = null;
		}
		topElement = 0;
	}
	
	public Stack(int _stackSize) {
		this.maxSize = _stackSize;
		this.initializeStack();
	}
	
	// Copy constructor
	public Stack(Stack old) {
		
	}
	
	public void top() {
		
	}
	
	// Place value onto stack
	public void push(Data element) {
		
	}
	
	// Remove element from stack
	public void pop() {
		
	}
	
	private void copy(Stack old) {
		
	}
	
	public void copyStack(Stack old) {
		if(this != old)
			copy(old);
	}
}
