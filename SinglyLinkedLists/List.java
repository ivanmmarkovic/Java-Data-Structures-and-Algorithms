
public class List {

	private Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public void printAll() {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info + ", ");
		System.out.println();
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public int numberOfElements() {
		int count = 0;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
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
			System.out.println("List is empty");
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
			System.out.println("List is empty");
		else {
			if(this.head == this.tail)
				this.head = this.tail = null;
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
			boolean swapped;
			do {
				swapped =false;
				for(Node inner = this.head; inner != this.tail; inner = inner.next) {
					if(inner.info > inner.next.info) {
						int tmp = inner.info;
						inner.info = inner.next.info;
						inner.next.info = tmp;
						swapped = true;
					}
				}
			}while(swapped == true);
		}
	}
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(index < 0 || index > size - 1 || this.isEmpty() )
			System.out.println();
		else {
			if(index == 0)
				this.deleteFromHead();
			else if(index == size- 1)
				this.deleteFromTail();
			else {
				int count = 0;
				Node prev = null, current = this.head;
				while(count < index) {
					count++;
					prev = current;
					current = current.next;
				}
				prev.next = current.next;
			}
		}
	}
	/*
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
	*/
	public void deleteNodesWithValue(int value) {
		if(this.isEmpty())
			System.out.println();
		else if(this.head != this.tail) {
			Node current = this.head;
			while(/*current != this.tail*/ current.next != null) {
				if(current.next.info ==value) 
					if(current.next.next == null) {
						current.next = null;
					}
					else
						current.next = current.next.next;
				else
					current = current.next;
			}
			this.tail = current;
		}
		if(this.head.info == value)
			this.deleteFromHead();
	}
	public void insertBefore(int listElement, int newElement) {
		Node prev = null;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.head)
					this.head = new Node(newElement, this.head);
				else {
					Node newNode = new Node(newElement, tmp);
					prev.next = newNode;
				}
			}
			prev = tmp;
		}
	}
	public void insertAfter(int listElement, int newElement) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.tail) {
					this.tail.next = new Node(newElement);
					this.tail = this.tail.next;
				}
				else {
					Node newNode = new Node(newElement, tmp.next);
					tmp.next = newNode;
				}
				tmp = tmp.next;
			}
		}
	}
}
