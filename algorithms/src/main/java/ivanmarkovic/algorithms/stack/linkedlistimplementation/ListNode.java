package ivanmarkovic.algorithms.stack.linkedlistimplementation;

public class ListNode<T> {
	
	private T payload;
	private ListNode<T> next;
	
	public ListNode(T payload) {
		this.payload = payload;
	}
	
	public ListNode(T payload, ListNode<T> node) {
		this.payload = payload;
		this.next = node;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T payload) {
		this.payload = payload;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

}
