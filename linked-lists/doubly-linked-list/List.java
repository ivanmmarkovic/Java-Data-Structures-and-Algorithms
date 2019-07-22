
public class List {
	
	Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	public void printAll() {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.payload + ", ");
		System.out.println();
	}
	
	public int numberOfElements() {
		int count = 0;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
	}
	
	public void addToHead(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.head = new Node(payload, null, this.head);
			this.head.next.prev = this.head;
		}
	}
	
	public void addToTail(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.tail.next = new Node(payload, this.tail, null);
			this.tail = this.tail.next;
		}
	}
	
	public Integer deleteFromHead() {
		if(this.isEmpty())
			return null;
		else {
			Node toDelete = this.head;
			Integer toReturn = this.head.payload;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
			toDelete = null;
			return toReturn;
		}
	}
	
	public Integer deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			Node toDelete = this.tail;
			Integer toReturn = this.tail.payload;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			toDelete = null;
			return toReturn;
		}
	}
	
	public Integer deleteNodesWithValue(int value) {
		Integer toReturn = null;
		if(this.isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			Node currentNode = this.head;
			while(currentNode.next != null) {
				if(currentNode.next.payload == value) {
					toReturn = currentNode.next.payload;
					Node toDelete = currentNode.next;
					if(currentNode.next.next == null)
						currentNode.next = null;
					else {
						currentNode.next = currentNode.next.next;
						currentNode.next.prev = currentNode;
					}
					toDelete = null;
				}
				else
					currentNode = currentNode.next;
			}
			this.tail = currentNode;
		}
		if(this.head.payload == value)
			toReturn = this.deleteFromHead();
		return toReturn;
	}
	
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(index < 0 || index >= size)
			System.out.println("Index out of range");
		else {
			if(index == 0)
				this.deleteFromHead();
			else if(index == size - 1)
				this.deleteFromTail();
			else {
				int count = 0;
				Node curr = this.head;
				while(count < index) {
					curr = curr.next;
					count++;
				}
				curr.prev.next = curr.next;
				curr.next.prev = curr.prev;
				curr = null;
			}
		}
	}
	
	public void insertAfter(int listValue, int newValue) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.payload == listValue) {
				if(tmp == this.tail)
					this.addToTail(newValue);
				else {
					Node newNode = new Node(newValue, tmp, tmp.next);
					tmp.next.prev = newNode;
					tmp.next = newNode;
				}
				tmp = tmp.next;
			}
		}
	}
	
	public void insertBefore(int listValue, int newValue) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.payload == listValue) {
				if(tmp == this.head) {
					this.addToHead(newValue);
				}
				else {
					Node newNode = new Node(newValue, tmp.prev, tmp);
					tmp.prev.next = newNode;
					tmp.prev = newNode;
				}
			}
		}
	}
	
	public void sort() {
		for(Node outer = this.head; outer != this.tail; outer = outer.next) {
			for(Node inner = this.tail; inner != outer; inner = inner.prev) {
				if(inner.prev.payload > inner.payload) {
					int storage = inner.payload;
					inner.payload = inner.prev.payload;
					inner.prev.payload = storage;
					
				}
			}
		}
	}
	
}
