package ivanmarkovic.algorithms.linkedlists.doublylinkedlist;

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
