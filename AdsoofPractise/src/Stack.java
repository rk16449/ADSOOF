import java.util.Random;

public class Stack {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// Put 100 random integer values into a stack
	
		
		// Random object of seed 10
		Random generator = new Random(10);
		
		// Create stack of 100 spaces
		Stack myStack = new Stack(100);
		
		
		// Fill up stack with 100 random integers 
		for(int i=0; i<100; i++) {
			myStack.push(new Data<Integer>(generator.nextInt()));
		}
		
		// Give us a copy of the most top value
		System.out.println(myStack.top().getValue());	
	}
	
	private int maxSize;
	private int top;
	private Data<?>[] stack;
	
	// Returns false if topElement is 0
	public boolean isEmptyStack() {
		return top == 0;
	}
	
	public boolean isStackFull() {
		// Determine whether the stack is full 
		// Postcondition: returns true if the stack is empty, false otherwise
		return top == maxSize;
	}
	
	public void initializeStack() {
		for(int i=0; i<maxSize; i++) {
			stack[i] = null;
		}
		top = 0;
	}
	
	// Default constructor
	public Stack() {
		// Create array size 16
		// Postcondition: The variable list contains the base of the array, topElement = 0 and maxSize = 16
		maxSize = 16;
		top = 0;
		stack = new Data[maxSize];
	}
	
	public Stack(int size) {
		if(size <= 0) {
			maxSize = 16;
		}else {
			maxSize = size;
		}
		
		top = 0;
		stack = new Data[maxSize];
	}
	
	// Copy constructor
	public Stack(Stack newStack) {
		copy(newStack);
	}
	
	public Data<?> top() throws StackUnderflowException{
		// Precondition: Stack exists and is not empty
		if(isEmptyStack()) {
			// throw exception here
			throw new StackUnderflowException();
		}
			
		// Postcondition: If stack empty throw exception, otherwise reference to a copy of te top element
		return stack[top-1].copyMe();
	}
	
	// Place value onto stack
	public void push(Data<?> element) throws StackOverflowException {
		// Precondition: Stack exists and is not full
		if(isStackFull()) {
			// throw exception here
			throw new StackOverflowException();
		}
		
		// Postcondition: The stack is changed and new item is added to the top
		stack[top] = element.copyMe();
		top++;
	}
	
	/**
	 * Method to resize the stack in case of a StackOverflow
	 * @param size
	 */
	public void resize(int size) {
		
		Data<?>[] newStack = new Data[size];
		
		for(int i=0; i<stack.length; i++) {
			newStack[i] = stack[i];
			
			// update alias
			stack = newStack;
		}
		
		// change maxSize
		maxSize = size;
	}
	
	// Remove element from stack
	public void pop() throws StackUnderflowException{
		// Precondition: The stack exists and is not empty
		if(isEmptyStack()) {
			//throw exception here
			throw new StackUnderflowException();
		}
		// Postcondition: The stack is changed and the top element is removed from the stack.
		// If the stack is empty throw exception
		top--;
		stack[top] = null;
	}
	
	private void copy(Stack old) {
		stack = null;
		System.gc();
		
		maxSize = old.maxSize;
		top = old.top;
		
		stack = new Data[maxSize];
		
		// copy old stack into this stack
		for(int i=0; i<top; i++) {
			stack[i] = old.stack[i].copyMe();
		}
	}
	
	public void copyStack(Stack otherStack) {
		if(this != otherStack)
			copy(otherStack);
	}
}
