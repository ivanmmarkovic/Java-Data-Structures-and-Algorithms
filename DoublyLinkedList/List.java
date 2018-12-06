
public class List {

	private Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public void printAll() {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) 
			System.out.print(tmp.info + ", ");
		System.out.println();
	}
	public int numberOfElements() {
		int count = 0;
		for(Node tmp = this.head; tmp!= null; tmp = tmp.next)
			count++;
		return count;
	}
	public void addToHead(int i) {
		if(this.isEmpty()) 
			this.head = this.tail = new Node(i);
		else {
			this.head = new Node(i, null, this.head);
			this.head.next.prev = this.head;
		}
	}
	public void addToTail(int i) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(i);
		}
		else {
			this.tail.next = new Node(i, this.tail, null);
			this.tail = this.tail.next;
		}
	}
	public void deleteFromHead() {
		if(this.isEmpty())
			System.out.println("List is empty");
		else {
			if(head == tail)
				head = tail = null;
			else {
				this.head = this.head.next;
				this.head.prev = null;
			}
		}
	}
	public Integer deleteFromTail() {
		if(this.isEmpty()) {
			System.out.println("List is empty");
			return null;
		}
		else {
			Integer toReturn = this.tail.info;
			if(head == tail)
				head =tail = null;
			else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			return toReturn;
		}
	}
	public void sort() {
		for(Node outer = this.head; outer != null; outer = outer.next) {
			boolean swapped = false;
			do {
				swapped = false;
				for(Node inner = this.head; inner.next != null; inner = inner.next) {
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
	/*
	public void deleteNodesWithValue(int i) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == i) {
				if(tmp == this.head)
					this.deleteFromHead();
				else if(tmp == this.tail)
					this.deleteFromTail();
				else {
					tmp.prev.next = tmp.next;
					tmp.next.prev = tmp.prev;
					tmp = tmp.prev;
				}
				
			}
		}
	}
	*/
	public void deleteNodesWithValue(int value) {
		while(this.head != null && this.head.info == value)
			this.deleteFromHead();
		while(this.tail != null && this.tail.info == value) 
			this.deleteFromTail();
		if(!this.isEmpty()) {
			Node current = this.head;
			while(current.next != tail) {
				if(current.next.info == value) {
					Node toDelete = current.next;
					current.next = current.next.next;
					current.next.next.prev = current;
					toDelete = null;
				}
				else
					current = current.next;
			}
		}
	}
	public void insertBefore(int listElement, int newElement) {
		for(Node tmp= this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.head)
					this.addToHead(newElement);
				else {
					Node newNode = new Node(newElement,tmp.prev, tmp);
					tmp.prev.next = newNode;
					tmp.prev = newNode;
				}
			}
		}
	}
	/*
	public void insertBefore(int listElement, int newElement) {
		Node current = this.head.next;
		while(current != null) {
			if(current.info == listElement) {
				Node newNode = new Node(newElement, current.prev, current);
				current.prev.next = newNode;
				current.prev = newNode;
			}
			current = current.next;
		}
		if(this.head.info == listElement)
			this.addToHead(newElement);
	}
	*/
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
}