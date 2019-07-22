public class Node {
	
	int payload;
	Node next;
	public Node(int payload) {
		this.payload = payload;
		this.next = null;
	}
	public Node(int payload, Node next) {
		this.payload = payload;
		this.next = next;
	}
	public boolean isEqual(int i) {
		return payload == i;
	}

}
