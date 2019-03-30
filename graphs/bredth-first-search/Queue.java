

// Stack as doubly linked list
public class Queue<T> {

	Node<T> head, tail;
	public Queue() {
		this.head = this.tail = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void enqueue(T payload) {
		this.head = new Node<T>(payload, this.head);
		if(this.tail == null)
			this.tail = this.head;
	}
	
	public Node<T> dequeue() {
		if(this.isEmpty())
			return null;
		else {
			Node<T> returnNode = this.tail;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node<T> tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				this.tail = tmp;
				this.tail.next = null;
			}
			return returnNode;
		}
	}
}
