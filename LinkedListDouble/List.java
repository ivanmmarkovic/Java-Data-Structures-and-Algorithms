
public class List {

	private Node head, tail;
	public List() {
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
			System.out.print(tmp.info + ", ");
		System.out.println();
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
		if(this.isEmpty())
			this.head = this.tail = new Node(i);
		else {
			this.tail.next = new Node(i, this.tail, null);
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
				this.head.prev = null;
			}
		}
	}
	public Integer deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			Integer i = this.tail.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.tail = this.tail.prev;
				this.tail.next = null;
			}
			return i;
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
		if(index < 1 || index > size || this.isEmpty())
			return;
		else {
			if(index == 1)
				this.deleteFromHead();
			else if(index == size)
				this.deleteFromTail();
			else {
				int counter = 1;
				Node current = this.head;
				while(counter < index) {
					counter++;
					current = current.next;
				}
				current.prev.next = current.next;
				current.next.prev = current.prev
			}
		}
	}
	public void deleteNodesWithValue(int i) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == i) {
				if(tmp == this.head)
					this.deleteFromHead();
				else if(tmp == this.tail)
					this.deleteFromTail();
				else {
					tmp.prev.next = tmp.next;
					tmp.next.prev = tmp.prev
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
}
