
public class Node {
	
	public int info;
	public Node next;
	public Node() {
		this.info = 0;
		this.next = null;
	}
	public Node(int i) {
		this.info = i;
		this.next = null;
	}
	public Node(int i, Node n) {
		this.info = i;
		this.next = n;
	}
	public boolean isEquals(int i) {
		return this.info == i;
	}
	public int print() {
		return this.info;
	}
}
