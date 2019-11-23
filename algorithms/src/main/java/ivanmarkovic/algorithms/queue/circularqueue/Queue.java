package ivanmarkovic.algorithms.queue.circularqueue;

import java.util.NoSuchElementException;

public class Queue {
	
	private int size;
	private int front, rear;
	private int elements[];
	
	public Queue(int size){
		this.size = size;
		this.elements = new int[this.size];
		this.front = this.rear = -1;
	}
	
	public boolean isEmpty() {
		return this.front == -1;
	}
	
	private boolean isFull() {
		return (this.rear + 1) % this.size == this.front;
	}
	
	public void enqueue(int element) {
		if(this.isFull())
			return;
		if(this.front == -1)
			this.front = 0;
		this.rear = (this.rear + 1) % this.size;
		this.elements[this.rear] = element;
	}
	
	public int dequeue() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		int ret = this.elements[this.front];
		if(this.front == this.rear)
			this.front = this.rear = -1;
		else
			this.front = (this.front + 1) % this.size;
		return ret;
	}

}
