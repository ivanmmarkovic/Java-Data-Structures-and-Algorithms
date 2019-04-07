package circularDoublyLinkedList;

public class List {
	
	Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public void printAll() {
		if(this.isEmpty())
			System.out.println();
		else {
			Node tmp = this.head;
			do {
				System.out.print(tmp.info + " ");
				tmp = tmp.next;
			}while(tmp != this.head);
			System.out.println();
		}
	}
	public int numberOfElements() {
		if(this.isEmpty())
			return 0;
		else {
			Node tmp = this.head;
			int count = 0;
			do {
				count++;
				tmp = tmp.next;
			} while (tmp != this.head);
			return count;
		}
	}
	public void addToHead(int i) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(i);
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
		else {
			this.head = new Node(i, this.tail, this.head);
			this.head.next.prev = this.head;
			this.tail.next = this.head;
		}
	}
	public void addToTail(int i) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(i);
			this.head.prev = this.tail;
			this.tail.next = this.head;
		}
		else {
			this.tail = new Node(i, this.tail, this.head);
			this.tail.prev.next = this.tail;
			this.head.prev = this.tail;
		}
	}
	public Integer deleteFromHead() {
		if(this.isEmpty())
			return null;
		else {
			Integer toReturn = this.head.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = this.tail;
				this.tail.next = this.head;
			}
			return toReturn;
		}
	}
	public Integer deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			Integer toReturn = this.tail.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				this.tail = tmp;
				this.tail.next = this.head;
				this.head.prev = this.tail;
			}
			return toReturn;
		}
	}
	public void deleteNodesWithValue(int value) {
		if(this.isEmpty())
			System.out.println();
		else {
			Node tmp = this.head;
			while(tmp.next != this.head) {
				if(tmp.next.info == value) {
					if(tmp.next.next == this.head) {
						tmp.next = this.head;
						this.head.prev = tmp;
					}
					else
						tmp.next = tmp.next.next;
				}
			}
			this.tail = tmp;
			this.tail.next = this.head;
			this.head.prev = this.tail;
		}
		if(this.head.info == value)
			this.deleteFromHead();
	}
	public Integer deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(index < 0 || index >= size)
			return null;
		else {
			if(index == 0)
				return this.deleteFromHead();
			else if(index == size - 1)
				return this.deleteFromTail();
			else {
				int count = 0;
				Node current = this.head;
				Node prev = null;
				while(count < index) {
					count++;
					prev = current;
					current = current.next;
				}
				prev.next = current.next;
				current.next.prev = prev;
				return current.info;
			}
		}
	}
	public void insertAfter(int listElement, int newElement) {
		if(this.isEmpty())
			System.out.println();
		else {
			Node tmp = this.head;
			do {
				if (tmp.info == listElement) {
					if (tmp == this.tail)
						this.addToTail(newElement);
					else {
						Node newNode = new Node(newElement, tmp, tmp.next);
						tmp.next.prev = newNode;
						tmp.next = newNode;
					}
					tmp = tmp.next;
				}
				tmp = tmp.next;
			} while (tmp != this.head);
		}
	}
	public void insertBefore(int listElement, int newElement) {
		if(this.isEmpty())
			System.out.println();
		else {
			Node tmp = this.head;
			do {
				if(tmp.info == listElement) {
					if(tmp == this.head)
						this.addToHead(newElement);
					else {
						Node newNode = new Node(newElement, tmp.prev, tmp);
						tmp.prev.next = newNode;
						tmp.prev = newNode;
					}
				}
				tmp = tmp.next;
			}while(tmp != this.head);
			
		}
	}
	public void sort() {
		Node tmp = this.head;
		do {
			for(Node inner = this.tail; inner != tmp; inner = inner.prev) {
				if(inner.prev.info > inner.info) {
					int storage = inner.prev.info;
					inner.prev.info = inner.info;
					inner.info = storage;
				}
			}
			tmp = tmp.next;
		}while(tmp != this.head);
	}

}
