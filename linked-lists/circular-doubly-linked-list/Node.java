package circularDoublyLinkedList;

public class Node {
	
	Integer info;
	Node prev, next;
	public Node() {
		this.info = null;
		this.next = this.prev = null;
	}
	public Node(int i) {
		this.info = i;
		this.prev = null;
		this.next = null;
	}
	public Node(int i, Node prev, Node next) {
		this.info = i;
		this.prev = prev;
		this.next = next;
	}
	public Integer print() {
		return info;
	}
}
