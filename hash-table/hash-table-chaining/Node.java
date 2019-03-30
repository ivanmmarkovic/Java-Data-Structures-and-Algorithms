public class Node<T> {
	
	public T info;
	public Node next;
	public Node() {
		this.info = null;
		this.next = null;
	}
	public Node(T t) {
		this.info = t;
		this.next = null;
	}
	public Node(T t, Node n) {
		info = t;
		next = n;
	}
	public T print() {
		return info;
	}
	public boolean isEqual(T t) {
		return t.equals(t);
	}

}