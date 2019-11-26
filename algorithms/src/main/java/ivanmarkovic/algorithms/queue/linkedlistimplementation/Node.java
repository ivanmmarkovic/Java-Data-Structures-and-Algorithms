package ivanmarkovic.algorithms.queue.linkedlistimplementation;

public class Node {
	
	int payload;
	Node next;
	
	public Node() {
		
	}
	
	public Node(int payload) {
		this.payload = payload;
	}
	
	public Node(int payload, Node next) {
		this.payload = payload;
		this.next = next;
	}

}
