
public class List {
	
	Node head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public void printAll() {
		if(this.isEmpty())
			return;
		else {
			Node tmp = this.head;
			do {
				System.out.print(tmp.info + " ");
				tmp = tmp.next;
			}while(tmp != this.head);
		}
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public int size() {
		if(this.isEmpty())
			return 0;
		else {
			Node tmp = this.head;
			int count = 0;
			do {
				tmp = tmp.next;
				count++;
			}while(tmp != this.head);
			return count;
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
			Integer toReturn = this.head.info; 
			if(this.head == this.tail) {
				this.head = this.tail = null;
			}
			else {
				this.head = this.head.next;
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
			}
			return toReturn;
		}
	}
	public void deleteNodesWithValues(int v) {
		if(this.isEmpty())
			return;
		else {
			Node currentNode = this.head;
			while(currentNode.next!= this.head) {
				if(currentNode.next.info == v)
					currentNode.next = currentNode.next.next;
				else
					currentNode = currentNode.next;
			}
			this.tail = currentNode;
			this.tail.next = this.head;
		}
		if(this.head.info == v)
			this.deleteFromHead();
	}
	public void deleteOnIndex(int index) {
		int size = this.size();
		if(index < 0 || index >= size)
			return;
		
		else {
			if(index == 1)
				this.deleteFromHead();
			else if(index == size - 1)
				this.deleteFromTail();
			else {
				int count = 0;
				Node tmp = this.head, prev = null;
				while(count < index) {
					prev = tmp;
					tmp = tmp.next;
					count++;
				}
				prev.next = tmp.next;
			}
		}
	}
	public void insertBefore(int listElement, int newElement) {
		if(this.isEmpty())
			return;
		else {
			Node tmp = this.head, prev = null;
			do {
				if(tmp.info == listElement) {
					if(tmp == this.head)
						this.addToHead(newElement);
					else {
						Node newNode = new Node(newElement, tmp);
						prev.next = newNode;
					}
				}
				prev = tmp;
				tmp = tmp.next;
			}while(tmp != this.head);
		}
	}
	public void insertAfter(int listElement, int newElement) {
		if(this.isEmpty())
			return;
		else {
			Node tmp = this.head;
			do {
				if(tmp.info == listElement) {
					if(tmp == this.tail)
						this.addToTail(newElement);
					else {
						Node newNode = new Node(newElement, tmp.next);
						tmp.next = newNode;
					}
					tmp = tmp.next;
				}
				tmp = tmp.next;
			}while(tmp != this.head);
		}
	}
	public void sort() {
		boolean swapped = false;
		do {
			swapped = false;
			for(Node tmp = this.head; tmp.next != this.head; tmp = tmp.next) {
				if(tmp.info > tmp.next.info) {
					int storage = tmp.info;
					tmp.info = tmp.next.info;
					tmp.next.info = storage;
					swapped = true;
				}
			}
		}while(swapped);
	}
}
