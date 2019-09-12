package linkedLists.circularDoublyLinkedList;

public class List {
    public Node head;
    public Node tail;

    public List(){
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int numberOfElements(){
        if(this.isEmpty())
            return 0;
        else {
            int count = 0;
            Node tmp = this.head;
            do {
                count++;
                tmp = tmp.next;
            } while (tmp != this.head);
            return count;
        }
    }

    public void addToHead(int payload){
        if(this.isEmpty()){
            this.head = this.tail = new Node(payload);
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }
        else {
            this.head = new Node(payload, this.tail, this.head);
            this.head.next.prev = this.head;
            this.tail.next = this.head;
        }
    }

    public void addToTail(int payload){
        if(this.isEmpty()){
            this.head = this.tail = new Node(payload);
            this.head.prev = this.tail;
            this.tail.next = this.head;
        }
        else {
            this.tail.next = new Node(payload, this.tail, this.head);
            this.tail = this.tail.next;
            this.head.prev = this.tail;
        }
    }

    public Integer deleteFromHead(){
        if(this.isEmpty())
            return null;
        else {
            Integer retValue = this.head.payload;
            if(this.head == this.tail)
                this.head = this.tail = null;
            else {
                this.head = this.head.next;
                this.head.prev = this.tail;
                this.tail.next = this.head;
            }
            return retValue;
        }
    }

    public Integer deleteFromTail(){
        if(this.isEmpty())
            return null;
        else {
            Integer retValue = this.tail.payload;
            if(this.head == this.tail)
                this.head = this.tail = null;
            else {
                this.tail = this.tail.prev;
                this.tail.next = this.head;
                this.head.prev = this.tail;
            }
            return retValue;
        }
    }

    public Integer deleteNodesWithValue(int value){
        Integer retValue = null;
        if(this.isEmpty())
            retValue = null;
        else {
            Node current = this.head;
            while(current.next != this.head){
                if(current.next.payload == value){
                    current.next = current.next.next;
                    current.next.prev = current;
                    retValue = current.next.payload;
                }
                else
                    current = current.next;
            }
            this.tail = current;
            this.head.prev = this.tail;
            this.tail.next = this.head;
            if(this.head.payload == value){
                retValue = this.deleteFromHead();
            }
        }
        return retValue;
    }

    public void deleteOnIndex(int index){
        int size = this.numberOfElements();
        if(index < 0 || index >= size){
            // Index out of range
            return;
        }
        else {
            if(index == 0)
                this.deleteFromHead();
            else if(index == size - 1)
                this.deleteFromTail();
            else {
                int count = 0;
                Node current = this.head;
                while(count < index){
                    current = current.next;
                    count++;
                }
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }

    public void insertBefore(int listElement, int newElement){
        if(this.isEmpty()){
            // List is empty
            return;
        }
        else {
            Node current = this.head;
            do {
                if(current.payload == listElement){
                    if(current == this.head)
                        this.addToHead(newElement);
                    else {
                        Node newNode = new Node(newElement, current.prev, current);
                        newNode.prev.next = newNode;
                        newNode.next.prev = newNode;
                    }
                }
                current = current.next;
            } while (current != this.head);
        }
    }

    public void insertAfter(int listElement, int newElement){
        if(this.isEmpty()){
            // List is empty
            return;
        }
        else {
            Node current = this.head;
            do {
                if(current.payload == listElement){
                    if(current == this.tail)
                        this.addToTail(newElement);
                    else {
                        current.next = new Node(newElement, current, current.next);
                        current.next.next.prev = current.next;
                    }
                    current = current.next;
                }
                current = current.next;
            } while (current != this.head);
        }
    }

    public void sort() {
        if(this.isEmpty())
            System.out.println("List is empty");
        else {
            for(Node outer = this.head; outer.next != this.head; outer = outer.next) {
                for(Node inner = this.tail; inner != outer; inner = inner.prev) {
                    if(inner.prev.payload > inner.payload) {
                        int storage = inner.prev.payload;
                        inner.prev.payload = inner.payload;
                        inner.payload = storage;
                    }
                }
            }
        }
    }
}
