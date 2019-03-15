

public class Node<T> {

	T payload;
	Node<T> next;
	public Node(T t) {
		this.payload = t;
		this.next = null;
	}
	public Node(T t, Node<T> next) {
		this.payload = t;
		this.next = next;
	}
	
}
