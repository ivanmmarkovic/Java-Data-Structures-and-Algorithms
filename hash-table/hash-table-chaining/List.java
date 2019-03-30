public class List<T> {

	private Node<T> head, tail;
	public List() {
		this.head = this.tail = null;
	}
	public boolean isEmpty() {
		return this.head == null;
	}
	public void printAll() {
		for(Node<T> tmp =this.head; tmp != null; tmp = tmp.next)
			System.out.print(tmp.info);
		System.out.println();
	}
	public int numberOfElements() {
		int count = 0;
		for(Node<T> tmp = this.head; tmp != null; tmp = tmp.next)
			count++;
		return count;
	}
	public void addToHead(T t) {
		this.head = new Node<T>(t, this.head);
		if(this.tail == null)
			this.tail = this.head;
	}
	public void addToTail(T t) {
		if(this.isEmpty())
			this.head = this.tail = new Node<T>(t);
		else {
			this.tail.next = new Node<T>(t);
			this.tail = this.tail.next;
		}	
	}
	public T deleteFromHead() {
		if(this.isEmpty())
			return null;
		else {
			T retvalue = this.head.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node<T> toDelete = this.head;
				this.head = this.head.next;
				toDelete = null;
			}
			return retvalue;
		}
	}
	public T deleteFromTail() {
		if(this.isEmpty())
			return null;
		else {
			T retvalue = this.tail.info;
			if(this.head == this.tail)
				this.head = this.tail = null;
			else {
				Node<T> tmp;
				for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
				Node<T> toDelete = this.tail;
				tmp.next = null;
				this.tail = tmp;
				toDelete = null;
			}
			return retvalue;
		}
	}
	public void deleteNodesWithValue(T t) {
		if(this.isEmpty())
			System.out.println("List is empty");
		else if(this.head != this.tail) {
			Node<T> currentNode = this.head;
			while(currentNode.next != null) /* NOT currentNode != this.tail, tail can be null */
				if(currentNode.next.info.equals(t)) {
					Node<T> toDelete = currentNode.next;
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
		if(this.head.info.equals(t))
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
				Node<T> prev = null, tmp = this.head;
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
	public boolean contains(T t) {
		boolean found = false;
		Node<T> tmp = this.head;
		while(tmp != null && !found) {
			if(tmp.info.equals(t))
				found = true;
			else
				tmp = tmp.next;
		}
		return found;
	}
	public int getIndex(T t) {
		if(this.isEmpty())
			return -1;
		else {
			int index = 0, size = this.numberOfElements();
			boolean found = false;
			Node<T> tmp = this.head;
			while(index < size && !found) {
				if(tmp.info.equals(t))
					found = true;
				else {
					index++;
					tmp = tmp.next;
				}
			}
			if(found)
				return index;
			else
				return -1;
		}
	}
	
	public Node<T> returnNodeOnIndex(int index){
		int size = this.numberOfElements();
		if(this.isEmpty())
			return null;
		else if(index < 0 || index >= size)
			return null;
		else {
			int count = 0;
			Node<T> tmp = this.head;
			while(count < index) {
				count++;
				tmp = tmp.next;
			}
			return tmp;
		}
	}
	public void insertValueOnIndex(int index, T t){
		int size = this.numberOfElements();
		if(this.isEmpty())
			return;
		else if(index < 0 || index >= size)
			return;
		else {
			int count = 0;
			Node<T> tmp = this.head;
			while(count < index) {
				count++;
				tmp = tmp.next;
			}
			tmp.info = t;
		}
	}
	
}