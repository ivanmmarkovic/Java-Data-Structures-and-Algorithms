
public class Node {
	
	public int info;
	public Node prev, next;
	public Node() {
		this.info = 0;
		this.prev = null;
		this.next = null;
	}
	public Node(int i) {
		this.info = i;
		this.prev = this.next = null;
	}
	public Node(int i, Node p, Node n) {
		info = i;
		prev = p;
		next = n;
	}
	public int print() {
		return info;
	}
	public boolean isEqual(int i) {
		return info == i;
	}

}
