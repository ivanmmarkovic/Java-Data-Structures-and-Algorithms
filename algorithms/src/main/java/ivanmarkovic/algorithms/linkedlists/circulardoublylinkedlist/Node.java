package ivanmarkovic.algorithms.linkedlists.circulardoublylinkedlist;

public class Node {
	
	int payload;
	Node prev;
	Node next;
	public Node() {
		
	}
	
	public Node(int payload) {
		this.payload = payload;
	}
	
	public Node(int payload, Node prev, Node next) {
		this.payload = payload;
		this.prev = prev;
		this.next = next;
	}

}
