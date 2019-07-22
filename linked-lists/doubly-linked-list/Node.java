
public class Node {
	
	int payload;
	Node prev, next;
	public Node(int payload) {
		this.payload = payload;
		this.prev = null;
		this.next = null;
	}
	public Node(int payload, Node prev, Node next) {
		this.payload = payload;
		this.prev = prev;
		this.next = next;
	}
	public boolean isEqual(int i) {
		return payload == i;
	}

}
