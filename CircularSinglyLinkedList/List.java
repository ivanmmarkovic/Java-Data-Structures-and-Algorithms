
public class List {
	
	private Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public void printAll() {
		if(this.isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			Node tmp = this.head;
			do {
				System.out.print(tmp.info + ", ");
				tmp = tmp.next;
			}while(tmp != this.head);
			System.out.println();
		}
	}
	public void addToHead(int i) {
		if(this.isEmpty()) {
			this.head = this.tail= new Node(i);
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
	public void deleteFromHead() {
		if(this.isEmpty()) {
			System.out.println("List is empty");
		}
		else {
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				this.head = this.head.next;
				this.tail.next = this.head; 
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
				tmp.next = this.head;
				this.tail = tmp;
			}
		}
	}
	public void deleteNodesWithValue1(int value) {
		if(this.isEmpty())
			System.out.println("List is empty");
		else {
			Node prev = null;
			Node tmp = this.head;
			do {
				if(tmp.info == value) {
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
	public void deleteNodesWithValue2(int value) {
		while(head != null && head.info == value) {
			this.deleteFromHead();
		}
		while(tail != null && tail.info == value) {
			this.deleteFromTail();
		}
		if(isEmpty())
			System.out.println("List is empty");
		else {
			Node prev = this.head;
			for(Node tmp = this.head.next; tmp != this.head; tmp = tmp.next) {
				if(tmp.info == value) {
					prev.next = tmp.next;
					//tmp = prev;
				}
				else
					prev = prev.next;
			}
		}
	}
	public void deleteNodesWithValue3(int value) {
		while(head != null && head.info == value) {
			this.deleteFromHead();
		}
		while(tail != null && tail.info == value) {
			this.deleteFromTail();
		}
		if(this.isEmpty())
			System.out.println("List is empty");
		else {
			Node current= this.head;
			while(current.next != tail) {
				if(current.next.info == value)
					current.next = current.next.next;
				else
					current = current.next;
			}
		}
	}
}
