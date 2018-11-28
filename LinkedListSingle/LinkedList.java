package recap;

public class LinkedList {
	
	private Node head, tail;
	public LinkedList() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public int numberOfElements() {
		int counter = 0;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			counter++;
		return counter;
	}
	public void printAll() {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.print() + ", ");
		System.out.println();
	}
	public void addToHead(int i) {
		this.head = new Node(i, this.head);
		if(this.tail == null)
			this.tail = this.head;
	}
	public void addToTail(int i) {
		if(this.isEmpty())
			this.head = this.tail = new Node(i);
		else {
			this.tail.next = new Node(i);
			this.tail = this.tail.next;
		}
	}
	public void deleteFromHead() {
		if(this.isEmpty())
			return;
		else {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
			}
		}
	}
	public void deleteFromTail() {
		if(this.isEmpty())
			return;
		else {
			if(this.head == this.tail)
				this.head = this.tail;
			else {
				Node tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				tmp.next = null;
				this.tail = tmp;
			}
		}
	}
	public void sort() {
		for(Node outer = this.head; outer != null; outer = outer.next) {
			boolean swapped = false;
			do {
				swapped = false;
				for(Node inner = this.head; inner.next != null; inner = inner.next) {
					if(inner.info > inner.next.info) {
						int tmp = inner.next.info;
						inner.next.info = inner.info;
						inner.info = tmp;
						swapped = true;
					}
				}
			}while(swapped);
		}
	}
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(index > size || index < 1 || this.isEmpty())
			return;
		else {
			if(index == 1)
				this.deleteFromHead();
			else if(index == size)
				this.deleteFromTail();
			else {
				int counter = 1;
				Node prevNode = this.head;
				while(counter < index -1) {
					counter++;
					prevNode = prevNode.next;
				}
				prevNode.next = prevNode.next.next;
			}
		}
	}
	/*public void deleteNodesWithValue(int value) {
		if(this.isEmpty())
			return;
		else if(this.head != this.tail) {
			Node currentNode = this.head;
			while(currentNode.next != null) {
				if(currentNode.next.info == value)
					currentNode.next = currentNode.next.next;
				else
					currentNode = currentNode.next;
			}
			this.tail = currentNode;
		}
		if(this.head.info == value)
			this.deleteFromHead();
	}*/
	public void deleteNodesWithValue(int value) {
		Node previous = null;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.isEqual(value)) {
				if(tmp == head)
					this.deleteFromHead();
				else if(tmp == tail)
					this.deleteFromTail();
				else {
					previous.next = previous.next.next;
					tmp = previous;
				}
			}
			else {
				previous = tmp;
			}
		}
}
}

