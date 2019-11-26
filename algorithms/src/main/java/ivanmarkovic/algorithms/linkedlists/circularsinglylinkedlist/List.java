package ivanmarkovic.algorithms.linkedlists.circularsinglylinkedlist;

import java.util.NoSuchElementException;

public class List {
	
	Node head;
	Node tail;
	
	public List() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public int numberOfElements() {
		if(this.isEmpty())
			return 0;
		else {
			int count = 0;
			Node current = this.head;
			do {
				count++;
				current = current.next;
			} while (current != this.head);
			return count;
		}
	}
	
	public void printAll() {
		if(this.isEmpty())
			return;
		else {
			Node current = this.head;
			do {
				System.out.print(current.payload + ", ");
			} while (current != this.head);
		}
		System.out.println();
	}
	
	public void addToHead(int payload) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(payload);
			this.tail.next = this.head;
		}
		else {
			this.head = new Node(payload, this.head);
			this.tail.next = this.head;
		}
	}
	
	public void addToTail(int payload) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(payload);
			this.tail.next = this.head;
		}
		else {
			this.tail.next = new Node(payload, this.head);
			this.tail = this.tail.next;
		}
	}
	
	public Integer deleteFromHead() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		else {
			Node retNode = this.head;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.tail.next = this.head;
			}
			return retNode.payload;
		}
	}
	
	public Integer deleteFromTail() {
		if(this.isEmpty())
			throw new NoSuchElementException();
		else {
			Node retNode = this.tail;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node current;
				for(current = this.head; current.next != this.tail; current = current.next);
				this.tail = current;
				this.tail.next = this.head;
			}
			return retNode.payload;
		}
	}
	
	public Integer deleteNodesWithValue(int value) {
		if(this.isEmpty())
			throw new NoSuchElementException();
		else {
			Integer retValue = null;
			Node current = this.head;
			while (current.next != this.head) {
				if(current.next.payload == value) {
					retValue = current.next.payload;
					current.next = current.next.next;
				}
				else
					current = current.next;
			}
			this.tail = current;
			if(this.head.payload == value)
				retValue = this.deleteFromHead();
			if(retValue == null)
				throw new NoSuchElementException();
			else
				return retValue;
		}
	}
	
	public void insertAfter(int listElement, int newElement) {
		if(this.isEmpty())
			return;
		else {
			Node current = this.head;
			do {
				if(current.payload == listElement) {
					if(current == this.tail)
						this.addToTail(newElement);
					else 
						current.next = new Node(newElement, current.next);
					current = current.next;
				}
				current = current.next;
			} while (current != this.head);
		}
	}
	
	public void insertBefore(int listElement, int newElement) {
		if(this.isEmpty())
			return;
		else {
			Node prev = null;
			Node current = this.head;
			do {
				if(current.payload == listElement) {
					if(current == this.head)
						this.addToHead(newElement);
					else {
						prev.next = new Node(newElement, current);
					}
				}
				prev = current;
				current = current.next;
			} while (current != this.head);
		}
	}
	
	public void sort() {
		if(this.isEmpty())
			return;
		boolean swapped = false;
		do {
			swapped = false;
			for(Node tmp = this.head; tmp != this.tail; tmp = tmp.next) {
				if(tmp.payload > tmp.next.payload) {
					int storage = tmp.payload;
					tmp.payload = tmp.next.payload;
					tmp.next.payload = storage;
					swapped = true;
				}
			}
		}while(swapped);
	}

}
