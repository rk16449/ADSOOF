
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
	
	public boolean isFullStack() {
		// Determine whether the stack is full 
		
		// Postcondition: returns true if the stack is empty, false otherwise
		
		return false;
	}
	
	public void initializeStack() {
		for(int i=0; i<maxSize; i++) {
			list[i] = null;
		}
		topElement = 0;
	}
	
	// Default constructor
	public Stack() {
		// Create array size 16
		// Postcondition: The variable list contains the base of the array, topElement = 0 and maxSize = 16
		this.maxSize = 16;
		this.initializeStack();
	}
	
	public Stack(int _stackSize) {
		this.maxSize = _stackSize;
		this.initializeStack();
	}
	
	// Copy constructor
	public Stack(Stack old) {
		
	}
	
	public Data top() {
		// Precondition: Stack exists and is not empty
		
		// Postcondition: If stack empty throw exception, otherwise reference to a copy of te top element
		return list[topElement];
	}
	
	// Place value onto stack
	public void push(Data element) {
		// Precondition: Stack exists and is not full
		
		// Postcondition: The stack is changed and new item is added to the top
	}
	
	// Remove element from stack
	public void pop() {
		// Precondition: The stack exists and is not empty
		
		// Postcondition: The stack is changed and the top element is removed from the stack.
		// If the stack is empty throw exception
	}
	
	private void copy(Stack old) {
		
	}
	
	public void copyStack(Stack old) {
		if(this != old)
			copy(old);
	}
}
