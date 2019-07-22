
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
			this.head = new Node(payload, this.head);
		}
	}
	
	public void addToTail(int payload) {
		if(this.isEmpty())
			this.head = this.tail = new Node(payload);
		else {
			this.tail.next = new Node(payload);
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
			else 
				this.head = this.head.next;
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
				Node tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				this.tail = tmp;
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
					else
						currentNode.next = currentNode.next.next;
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
				Node prev = null, curr = this.head;
				while(count < index) {
					prev = curr;
					curr = curr.next;
					count++;
				}
				prev.next = curr.next;
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
					tmp.next = new Node(newValue, tmp.next);
				}
				tmp = tmp.next;
			}
		}
	}
	
	public void insertBefore(int listValue, int newValue) {
		Node prev = null;
		for(Node tmp = this.head; tmp != null; tmp = tmp.next) {
			if(tmp.payload == listValue) {
				if(tmp == this.head) {
					this.addToHead(newValue);
				}
				else {
					prev.next = new Node(newValue, tmp);
				}
			}
			prev = tmp;
		}
	}
	
	public void sort() {
		boolean swapped = true;
		do{
			swapped = false;
			for(Node tmp = this.head; tmp != this.tail; tmp = tmp.next) {
				if(tmp.payload > tmp.next.payload) {
					int storage = tmp.payload;
					tmp.payload = tmp.next.payload;
					tmp.next.payload = storage;
					swapped = true;
				}
			}
		}while(swapped);
	}
	
}
