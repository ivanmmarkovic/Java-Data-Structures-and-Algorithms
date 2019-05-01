
public class Stack {
	
	private int pointer;
	private int capacity;
	private int stack[];
	public Stack(int capacity) {
		this.capacity = capacity;
		this.stack = new int[this.capacity];
		this.pointer = -1;
	}
	
	public boolean isEmpty() {
		return this.pointer == -1;
	}
	
	public int size() {
		return this.pointer + 1;
	}
	
	public void push(int number) {
		if(this.pointer < this.capacity - 1)
			this.stack[++this.pointer] = number;
		else
			System.out.println("Stack is full");	
	}
	
	public Integer pop() {
		if(this.pointer > -1)
			return this.stack[this.pointer--];
		else {
			System.out.println("Stack is empty");
			return null;
		}
	}
	
	@Override 
	public String toString() {
		String result = "";
		for(int i = 0; i <= this.pointer; i++)
			result += this.stack[i] + ", ";
		return result;
	}

}
