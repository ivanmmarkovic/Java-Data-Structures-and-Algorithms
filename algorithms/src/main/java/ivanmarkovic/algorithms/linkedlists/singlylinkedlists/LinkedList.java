package ivanmarkovic.algorithms.linkedlists.singlylinkedlists;

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
		else
			this.head = new Node(payload, this.head);
	}
	
	public void addToTail(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.tail.next = new Node(payload);
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
			else 
				this.head = this.head.next;
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
				Node tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				tmp.next = null;
				this.tail = tmp;
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
				Node prev = null;
				Node current = this.head;
				int count = 0;
				while(count < index) {
					prev = current;
					current = current.next;
					count++;
				}
				prev.next = current.next;
			}
		}
	}
	
	public void insertAfter(int listElement, int newElement) {
		for(Node current = this.head; current != null; current = current.next) {
			if(current.payload == listElement) {
				if(current == this.tail)
					this.addToTail(newElement);
				else 
					current.next = new Node(newElement, current.next);
				current = current.next;
			}
		}
	}
	
	public void insertBefore(int listElement, int newElement) {
		Node prev = null;
		for(Node current = this.head; current != null; current = current.next) {
			if(current.payload == listElement) {
				if(current == this.head)
					this.addToHead(newElement);
				else {
					prev.next = new Node(newElement, current);
				}
			}
			prev = current;
		}
	}
	
	public void sort() {
		boolean swapped;
		do {
			swapped = false;
			for(Node current = this.head; current != this.tail; current = current.next) {
				if(current.payload > current.next.payload) {
					int tmp = current.payload;
					current.payload = current.next.payload;
					current.next.payload = tmp;
					swapped = true;
				}
			}
		} while (swapped);
	}
}
