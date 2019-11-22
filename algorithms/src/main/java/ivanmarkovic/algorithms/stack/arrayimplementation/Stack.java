package ivanmarkovic.algorithms.stack.arrayimplementation;

import java.util.EmptyStackException;

public class Stack {
	
	private int size;
	private int pointer;
	private int stack[];
	
	public Stack(int size) {
		this.size = size;
		this.stack = new int[this.size];
		this.pointer = -1;
	}
	
	public int size() {
		return this.pointer + 1;
	}
	
	public boolean isEmpty() {
		return this.pointer == -1;
	}
	
	public int peek() {
		if(this.isEmpty())
			throw new EmptyStackException();
		else
			return this.stack[this.pointer];
	}
	
	public int pop() {
		if(this.isEmpty())
			throw new EmptyStackException();
		else
			return this.stack[this.pointer--];
	}
	
	public void push(int element) {
		if(this.pointer < this.size - 1)
			this.stack[++this.pointer] = element;
	}

}
