
public class List {

	private Node head,tail;
	public List() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public int numberOfElements() {
		if(this.isEmpty())
			return 0;
		else {
			Node tmp = this.head;
			int count = 0;
			do {
				count++;
				tmp= tmp.next;
			}while(tmp != this.head);
			return count; 
		}
	}
	public void printAll() {
		if(this.isEmpty())
			System.out.println("List is empty");
		else {
			Node tmp = this.head;
			do {
				System.out.print(tmp.payload + ", ");
				tmp = tmp.next;
			}while(tmp != this.head);
			System.out.println();
		}
	}
	public void addToHead(int i) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(i);
			this.tail.next = this.head;
		}
		else {
			this.head = new Node(i, this.head);
			this.tail.next = this.head;
		}
	}
	public void addToTail(int i) {
		if(this.isEmpty()) {
			this.head = this.tail = new Node(i);
			this.tail.next = this.head;
		}
		else {
			this.tail.next = new Node(i, this.head);
			this.tail = this.tail.next;
		}
	}
	public Integer deleteFromHead() {
		if(this.isEmpty())
			return null;
		else {
			Integer toReturn = this.head.payload;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node toDelete = this.head;
				this.head = this.head.next;
				this.tail.next = this.head;
				toDelete = null;
			}
			return toReturn;
		}
	}
	public Integer deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			Integer toReturn = this.tail.payload;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node tmp;
				for(tmp = this.head; tmp.next!= this.tail; tmp = tmp.next);
				Node toDelete = tmp.next;
				tmp.next = this.head;
				this.tail = tmp;
				toDelete = null;
			}
			return toReturn;
		}
	}
	/*
	public void deleteNodesWithValue1(int value) {
		if(this.isEmpty())
			System.out.println("List is empty");
		else {
			Node prev = null;
			Node tmp = this.head;
			do {
				if(tmp.payload == value) {
					if(tmp == head) {
						this.deleteFromHead();
						this.deleteNodesWithValue1(value);
					}
					else if(tmp == tail) {
						this.deleteFromTail();
						this.deleteNodesWithValue1(value);
					}
					else {
						prev.next = tmp.next;
						tmp = prev;
					}
				}
				prev = tmp;
				tmp = tmp.next;
			}while(tmp != head);
		}
	}
	
	public void deleteNodesWithValue(int val) {
		while(this.head != null && this.head.payload == val)
			this.deleteFromHead();
		while(this.tail != null && this.tail.payload == val)
			this.deleteFromTail();
		if(!this.isEmpty() && this.head != this.tail) {
			Node current = this.head;
			while(current.next != this.tail) {
				if(current.next.payload == val) {
					Node toDelete = current.next;
					current.next = current.next.next;
					toDelete = null;
				}
				else
					current = current.next;
			}
		}
	}
	*/
	public void deleteOnIndex(int index) {
		int size = this.numberOfElements();
		if(this.isEmpty())
			System.out.println("List is empty");
		else if(index < 0 || index > size - 1)
			System.out.println("Index out of range");
		else {
			if(index == 0)
				this.deleteFromHead();
			else if(index == size - 1)
				this.deleteFromTail();
			else {
				Node prev = null;
				Node current = this.head;
				int count = 0;
				while(count < index) {
					prev = current;
					current = current.next;
					count++;
				}
				Node toDelete = current;
				prev.next = current.next;
				toDelete = null;
			}
		}
	}
	public void insertBefore(int listElement, int newElement) {
		if(this.isEmpty())
			System.out.println("List is empty");
		else if(this.head != this.tail){
			Node prev = this.head;
			for(Node tmp  = this.head.next; tmp != this.head; tmp = tmp.next) {
				if(tmp.payload == listElement) {
					Node newNode = new Node(newElement, tmp);
					prev.next = newNode;
				}
				prev = tmp;
			}
			if(this.head.payload == listElement)
				this.addToHead(newElement);
		}
	}
	public void insertAfter(int listElement, int newElement) {
		if(this.isEmpty())
			System.out.println("List is empty");
		else {
			for(Node tmp = this.head; tmp != this.tail; tmp = tmp.next) {
				if(tmp.payload == listElement) {
					Node newNode = new Node(newElement, tmp.next);
					tmp.next = newNode;
					tmp = tmp.next;
				}
			}
			if(this.tail.payload == listElement)
				this.addToTail(newElement);
		}
	}
	
}
