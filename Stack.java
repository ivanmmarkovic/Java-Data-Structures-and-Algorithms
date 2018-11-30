public class Stack {
	
	private int stackPointer;
	private int maxNumberOfElements;
	private int stack[];
	
	public Stack(int maxNumberOfElements) {
		this.maxNumberOfElements = maxNumberOfElements;
		this.stack = new int[this.maxNumberOfElements];
		this.stackPointer = -1;
	}
	
	public void push(int element) {
		if(this.stackPointer < this.maxNumberOfElements - 1)
			this.stack[++this.stackPointer] = element;
	}
	
	public int pop() {
		if(this.stackPointer >= 0)
			return this.stack[this.stackPointer--];
		else
			return 0;
	}
	
	public int peek() {
		if(this.stackPointer >= 0)
			return this.stack[this.stackPointer];
		else
			return 0;
	}
	
	public int size() {
		return this.stackPointer + 1;
	}
	
	public boolean isEmpty() {
		return this.stackPointer == -1;
	}
}