package ivanmarkovic.algorithms.queue.stacksimplementation;

import ivanmarkovic.algorithms.stack.linkedlistimplementation.Stack;

public class Queue<T> {
	
	Stack<T> instack;
	Stack<T> outstack;
	
	public Queue() {
		instack = new Stack<T>();
		outstack = new Stack<T>();
	}
	
	public void enqueue(T element) {
		this.instack.push(element);
	}
	
	public T dequeue() {
		while(!instack.isEmpty())
			outstack.push(instack.pop());
		T ret = outstack.pop();
		while (!outstack.isEmpty()) {
			instack.push(outstack.pop());
		}
		return ret;
	}
	
	public boolean isEmpty() {
		return this.instack.isEmpty();
	}
	
	public int size() {
		return this.instack.size();
	}
}
