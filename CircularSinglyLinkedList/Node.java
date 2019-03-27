
public class Node {
	
	int info;
	Node next;
	public Node() {
		this.info = 0;
		this.next = null;
	}
	public Node(int i) {
		this.info = i;
		this.next = null;
	}
	public Node(int i, Node next) {
		this.info = i;
		this.next = next;
	}
	public int print() {
		return info;
	}
}
