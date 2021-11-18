package ivanmarkovic.algorithms.linkedlists.circulardoublylinkedlist;

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
				current = current.next;
			} while (current != this.head);
		}
		System.out.println();
	}
	
	public void addToHead(int payload) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(payload);
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
		else {
			this.head = new Node(payload, this.tail, this.head);
			this.head.next.prev = this.head;
			this.tail.next = this.head;
		}
	}
	
	public void addToTail(int payload) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(payload);
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
		else {
			this.tail.next = new Node(payload, this.tail, this.head);
			this.tail = this.tail.next;
			this.head.prev = this.tail;
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
				this.head.prev = this.tail;
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
				this.tail = this.tail.prev;
				this.tail.next = this.head;
				this.head.prev = this.tail;
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
					current.next.prev = current;
				}
				else
					current = current.next;
			}
			this.tail = current;
			this.tail.next = this.head;
			this.head.prev = this.tail;
			if(this.head.payload == value)
				retValue = this.deleteFromHead();
			if(retValue == null)
				throw new NoSuchElementException();
			else
				return retValue;
		}
	}
	
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(index < 0 || index >= size)
			return;
		if(index == 0)
			this.deleteFromHead();
		else if(index == size - 1)
			this.deleteFromTail();
		else {
			int count = 0;
			Node current = this.head;
			while(count < index) {
				count++;
				current = current.next;
			}
			current.prev.next = current.next;
			current.next.prev = current.prev;
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
					else {
						current.next = new Node(newElement, current, current.next);
						current.next.next.prev = current.next;
					}
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
			Node current = this.head;
			do {
				if(current.payload == listElement) {
					if(current == this.head)
						this.addToHead(newElement);
					else {
						Node newNode = new Node(newElement, current.prev, current);
						newNode.prev.next = newNode;
						current.prev = newNode;
						
					}
				}
				current = current.next;
			} while (current != this.head);
		}
	}
	
	public void sort() {
		if(this.isEmpty())
			return;
		for(Node current = this.head; current != this.tail; current = current.next) {
			for(Node tmp = this.tail; tmp != current; tmp = tmp.prev) {
				if(tmp.prev.payload > tmp.payload) {
					int storage = tmp.payload;
					tmp.payload = tmp.prev.payload;
					tmp.prev.payload = storage;
				}
			}
		}
	}


}
