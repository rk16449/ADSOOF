
public class Stack {
	
	public static void main(String[] args) {
		
	}
	
	private int maxSize;
	private int topStack;
	private Data[] stack;
	
	// Returns false if topElement is 0
	public boolean isEmptyStack() {
		return topStack != 0;
	}
	
	public boolean isStackFull() {
		// Determine whether the stack is full 
		
		// Postcondition: returns true if the stack is empty, false otherwise
		
		return topStack == maxSize;
	}
	
	public void initializeStack() {
		for(int i=0; i<maxSize; i++) {
			stack[i] = null;
		}
		topStack = 0;
	}
	
	// Default constructor
	public Stack() {
		// Create array size 16
		// Postcondition: The variable list contains the base of the array, topElement = 0 and maxSize = 16
		maxSize = 16;
		topStack = 0;
		stack = new Data[maxSize];
	}
	
	public Stack(int size) {
		if(size <= 0) {
			maxSize = 16;
		}else {
			maxSize = size;
		}
		
		topStack = 0;
		stack = new Data[maxSize];
	}
	
	// Copy constructor
	public Stack(Stack newStack) {
		copy(newStack);
	}
	
	public Data top() {
		// Precondition: Stack exists and is not empty
		if(isEmptyStack()) {
			// throw exception here
		}
			
		// Postcondition: If stack empty throw exception, otherwise reference to a copy of te top element
		return stack[topStack-1].copyMe();
	}
	
	// Place value onto stack
	public void push(Data element) {
		// Precondition: Stack exists and is not full
		
		
		// Postcondition: The stack is changed and new item is added to the top
		
		if(isStackFull()) {
			// throw exception here
		}
		
		stack[topStack] = element.copyMe();
		
		topStack++;
	}
	
	// Remove element from stack
	public void pop() {
		// Precondition: The stack exists and is not empty
		if(isEmptyStack()) {
			//throw exception here
		}
		
		
		
		// Postcondition: The stack is changed and the top element is removed from the stack.
		// If the stack is empty throw exception
		topStack--;
		stack[topStack] = null;
	}
	
	private void copy(Stack old) {
		stack = null;
		System.gc();
		
		maxSize = old.maxSize;
		topStack = old.topStack;
		
		stack = new Data[maxSize];
		
		// copy old stack into this stack
		for(int i=0; i<topStack; i++) {
			stack[i] = old.stack[i].copyMe();
		}
	}
	
	public void copyStack(Stack otherStack) {
		if(this != otherStack)
			copy(otherStack);
	}
}
