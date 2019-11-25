package ivanmarkovic.algorithms.linkedlists.doublylinkedlist;

import java.util.NoSuchElementException;

public class LinkedList {
	
	Node head, tail;
	
	public LinkedList() {
		this.head = this.tail = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void printAll() {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.payload + ", ");
		System.out.println();
	}
	
	public int numberOfElements() {
		int count = 0;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
	}
	
	public void addToHead(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.head = new Node(payload, null, this.head);
			this.head.next.prev = this.head;
		}
	}
	
	public void addToTail(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.tail.next = new Node(payload, this.tail, null);
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
				this.head.prev = null;
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
				this.tail.next = null;
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
			while(current.next != null) {
				if(current.next.payload == value) {
					retValue = current.next.payload;
					current.next = current.next.next;
					if(current.next != null)
						current.next.prev = current;
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
	
	public void deleteOnOndex(int index) {
		int size = this.numberOfElements();
		if(index < 0 || index >= size)
			return;
		else {
			if(index == 0)
				this.deleteFromHead();
			else if(index == size - 1)
				this.deleteFromTail();
			else {
				Node current = this.head;
				int count = 0;
				while(count < index) {
					current = current.next;
					count++;
				}
				current.prev.next = current.next;
				current.next.prev = current.prev;
			}
		}
	}
	
	public void insertAfter(int listElement, int newElement) {
		for(Node current = this.head; current != null; current = current.next) {
			if(current.payload == listElement) {
				if(current == this.tail)
					this.addToTail(newElement);
				else {
					Node newNode = new Node(newElement, current, current.next);
					current.next = newNode;
					if(newNode.next != null)
						newNode.next.prev = newNode;
				}
				current = current.next;
			}
		}
	}
	
	public void insertBefore(int listElement, int newElement) {
		for(Node current = this.head; current != null; current = current.next) {
			if(current.payload == listElement) {
				if(current == this.head)
					this.addToHead(newElement);
				else {
					Node newNode = new Node(newElement, current.prev, current);
					newNode.prev.next = newNode;
					current.prev = newNode;
				}
			}
		}
	}
	
	public void sort() {
		for(Node outer = this.head; outer != this.tail; outer = outer.next) {
			for(Node inner = this.tail; inner != outer; inner = inner.prev) {
				if(inner.prev.payload > inner.payload) {
					int tmp = inner.prev.payload;
					inner.prev.payload = inner.payload;
					inner.payload = tmp;
				}
			}
		}
	}
}
