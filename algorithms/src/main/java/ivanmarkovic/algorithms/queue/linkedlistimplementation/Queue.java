package ivanmarkovic.algorithms.queue.linkedlistimplementation;

import java.util.NoSuchElementException;

public class Queue {
	
	Node head, tail;
	
	public Queue() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	public int size() {
		int count = 0;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
	}
	
	public void enqueue(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.tail.next = new Node(payload);
			this.tail = this.tail.next;
		}
	}
	
	public int dequeue() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		else {
			Node retNode = this.head;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else 
				this.head = this.head.next;
			return retNode.payload;
		}
	}
}
