
public class List {

	private Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public void printAll() {
		for(Node tmp =this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info);
		System.out.println();
	}
	public int numberOfElements() {
		int count = 0;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
	}
	public void addToHead(int i) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(i);
		}
		else {
			this.head = new Node(i, null, this.head);
			this.head.next.prev = this.head;
		}
	}
	public void addToTail(int i) {
		if(this.isEmpty())
			this.head = this.tail = new Node(i);
		else {
			this.tail.next = new Node(i, this.tail, null);
			this.tail = this.tail.next;
		}	
	}
	public Integer deleteFromHead() {
		if(this.isEmpty())
			return null;
		else {
			Integer retvalue = this.head.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node toDelete = this.head;
				this.head = this.head.next;
				this.head.prev = null;
				toDelete = null;
			}
			return retvalue;
		}
	}
	public Integer deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			Integer retvalue = this.tail.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node toDelete = this.tail;
				this.tail = this.tail.prev;
				this.tail.next = null;
				toDelete = null;
			}
			return retvalue;
		}
	}
	public void deleteNodesWithValue(int v) {
		if(this.isEmpty())
			return;
		else {
			Node currentNode = this.head;
			while(currentNode.next != null) {
				if(currentNode.next.info == v) {
					if(currentNode.next.next == null)
						currentNode.next = null;
					else {
						currentNode.next = currentNode.next.next;
						currentNode.next.prev = currentNode;
					}
				}
				else {
					currentNode = currentNode.next;
				}
			}
			this.tail = currentNode;
			if(this.head.info == v)
				this.deleteFromHead();
		}
	}
	public Integer deleteWithValue(int value) {
		Integer retValue = null;
		if(this.isEmpty())
			return null;
		Node current = this.head;
		while(current.next != null) {
			if(current.next.info == value) {
				retValue = current.next.payload;
				if(current.next.next == null) {
					current.next.prev = null;
					current.next = null;
				}
				else {
					current.next = current.next.next;
					current.next.prev = current;
				}
			}
			else
				current = current.next;
		}
		this.tail = current;
		if(this.head.info == value) {
			retValue = this.head.info;
			this.deleteFromHead();
		}
		return retValue;
	}
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(index < 0 || index > size - 1 || this.isEmpty()){
			if(this.isEmpty())
				System.out.println("List is empty");
			else
				System.out.println("Index out of range");
		}
		else {
			if(index == 0)
				this.deleteFromHead();
			else if(index ==size - 1)
				this.deleteFromTail();
			else {
				Node current = this.head;
				int counter = 0;
				while(counter < index) {
					counter++;
					current = current.next;
				}
				Node toDelete = current;
				current.prev.next = current.next;
				current.next.prev = current.prev;
				toDelete = null;
			}
		}
	}
	public void sort() {
		for(Node outer = this.head; outer != null; outer = outer.next) {
			for(Node inner = this.tail; inner != outer; inner = inner.prev) {
				if(inner.prev.info > inner.info) {
					int tmp = inner.prev.info;
					inner.prev.info = inner.info;
					inner.info = tmp;
				}
			}
		}
	}
	public void insertAfter(int listElement, int newElement) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.tail)
					this.addToTail(newElement);
				else {
					Node newNode = new Node(newElement, tmp, tmp.next);
					tmp.next.prev = newNode;
					tmp.next = newNode;
				}
				tmp = tmp.next;
			}
		}
	}
	public void insertBefore(int listElement, int newElement) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.head)
					this.addToHead(newElement);
				else {
					Node newNode = new Node(newElement, tmp.prev, tmp);
					tmp.prev.next = newNode;
					tmp.prev = newNode;
				}
			}
		}
	}
}
