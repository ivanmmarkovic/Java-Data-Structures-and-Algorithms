
public class Node {
	
	public int payload;
	public Node next;
	
	public Node() {
		this.payload = 0;
		this.next = null;
	}
	public Node(int i) {
		this.payload = i;
		this.next = null;
	}
	public Node(int i, Node n) {
		this.payload = i;
		this.next = n;
	}
	public int print() {
		return this.payload;
	}
	public boolean isEqual(int i) {
		return this.payload == i;
	}

}
