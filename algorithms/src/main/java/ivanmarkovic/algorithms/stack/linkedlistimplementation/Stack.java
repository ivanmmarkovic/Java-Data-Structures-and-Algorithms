package ivanmarkovic.algorithms.stack.linkedlistimplementation;

import java.util.EmptyStackException;

public class Stack<T> {
	
	ListNode<T> head;
	
	public Stack() {
		
	}
	
	public int size() {
		int count = 0;
		for(ListNode<T> tmp = this.head; tmp != null; tmp = tmp.getNext())
			count++;
		return count;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public T peek() {
		if(this.isEmpty())
			throw new EmptyStackException();
		else
			return this.head.getPayload();
	}
	
	public T pop() {
		if(this.isEmpty())
			throw new EmptyStackException();
		else {
			ListNode<T> retValue = this.head;
			this.head = this.head.getNext();
			return retValue.getPayload();
		}
	}
	
	public void push(T element) {
		if(this.isEmpty())
			this.head = new ListNode<T>(element);
		else
			this.head = new ListNode<T>(element, head);
	}

}
