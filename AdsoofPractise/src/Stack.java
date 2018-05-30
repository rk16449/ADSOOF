
public class Stack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	private int maxSize;
	
	private int topElement;
	
	private Data[] list;
	
	
	public void isEmptyStack() {
		
	}
	
	public void isFullStack() {
		
	}
	
	public void initializeStack() {
		for(int i=0; i<maxSize; i++) {
			list[i] = null;
		}
		topElement = 0;
	}
	
	public Stack() {
		
	}
	
	// Copy constructor
	public Stack(Stack old) {
		
	}
	
	public void top() {
		
	}
	
	public void push() {
		
	}
	
	public void pop() {
		
	}
	
	private void copy(Stack old) {
		
	}
	
	public void copyStack(Stack old) {
		if(this != old)
			copy(old);
	}
}
