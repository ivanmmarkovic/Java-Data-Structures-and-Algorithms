
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
				Node tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				Node toDelete = this.tail;
				tmp.next = null;
				this.tail = tmp;
				toDelete = null;
			}
			return retvalue;
		}
	}
	public void deleteNodesWithValue(int val) {
		if(this.isEmpty())
			System.out.println("List is empty");
		else if(this.head != this.tail) {
			Node currentNode = this.head;
			while(currentNode.next != null) /* NOT currentNode != this.tail, tail can be null */
				if(currentNode.next.info == val) {
					Node toDelete = currentNode.next;
					if(currentNode.next.next == null)
						currentNode.next = null;
					else
						currentNode.next = currentNode.next.next;
					toDelete = null;
				}
				else
					currentNode = currentNode.next;
			this.tail = currentNode;				
		}
		if(this.head.info == val)
			this.deleteFromHead();
	}
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(this.isEmpty())
			System.out.println("List is empty");
		else if(index < 0 || index > size - 1){
			System.out.println("Index out of bounds");
		}
		else {
			if(index == 0)
				this.deleteFromHead();
			else if(index == size - 1)
				this.deleteFromTail();
			else {
				int count = 0;
				Node prev = null, tmp = this.head;
				while(count < index) {
					count++;
					prev = tmp;
					tmp = tmp.next;
				}
				prev.next = tmp.next;
				tmp = null;
			}
		}
	}
	public void sort() {
		for(Node outer = this.head; outer != null; outer = outer.next) {
			boolean swapped;
			do {
				swapped = false;
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
	public void insertAfter(int listElement, int newElement) {
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.tail)
					this.addToTail(newElement);
				else {
					Node newNode = new Node(newElement, tmp.next);
					tmp.next = newNode;
				}
				tmp = tmp.next;
			}
		}
	}
	public void insertBefore(int listElement, int newElement) {
		Node prev = null;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.info == listElement) {
				if(tmp == this.head)
					this.addToHead(newElement);
				else {
					Node newNode = new Node(newElement, tmp);
					prev.next = newNode;
				}
			}
			prev = tmp;
		}
	}
}
