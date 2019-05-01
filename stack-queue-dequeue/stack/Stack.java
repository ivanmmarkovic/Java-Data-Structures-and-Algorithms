
public class Stack {
	
	int stackSize;
	int pointer;
	int stack[];
	public Stack(int stackSize) {
		this.pointer = -1;
		this.stackSize = stackSize;
		this.stack = new int[this.stackSize];
	}
	
	public int size() {
		return this.pointer + 1;
	}
	
	public  boolean isEmpty() {
		return this.pointer == -1;
	}
	
	public void push(int i) {
		if(this.pointer < this.stackSize - 1)
			this.stack[++this.pointer] = i;
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
