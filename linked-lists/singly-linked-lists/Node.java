
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
		info = i;
		next = n;
	}
	public int print() {
		return info;
	}
	public boolean isEqual(int i) {
		return info == i;
	}

}
