
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
            this.tail.next = this.head;
        }
        else {
            this.head = new Node(payload, this.head);
            this.tail.next = this.head;
        }
    }

    public void addToTail(int payload){
        if(this.isEmpty()){
            this.head = this.tail = new Node(payload);
            this.tail.next = this.head;
        }
        else {
            this.tail.next = new Node(payload, this.head);
            this.tail = this.tail.next;
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
                Node tmp;
                for(tmp = this.head; tmp.next != this.tail; tmp = tmp.next);
                this.tail = tmp;
                this.tail.next = this.head;
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
                    retValue = current.next.payload;
                }
                else
                    current = current.next;
            }
            this.tail = current;
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
                Node prev = null;
                Node current = this.head;
                while(count < index){
                    prev = current;
                    current = current.next;
                    count++;
                }
                prev.next = current.next;
            }
        }
    }

    public void insertBefore(int listElement, int newElement){
        if(this.isEmpty()){
            // List is empty
            return;
        }
        else {
            Node prev = null;
            Node current = this.head;
            do {
                if(current.payload == listElement){
                    if(current == this.head)
                        this.addToHead(newElement);
                    else {
                        Node newNode = new Node(newElement, current);
                        prev.next = newNode;
                    }
                }
                prev = current;
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
                        current.next = new Node(newElement, current.next);
                    }
                    current = current.next;
                }
                current = current.next;
            } while (current != this.head);
        }
    }

    public void sort(){
        boolean swapped = false;
        do {
            swapped = false;
            for(Node tmp = this.head; tmp != this.tail; tmp = tmp.next){
                if(tmp.payload > tmp.next.payload){
                    int storage = tmp.payload;
                    tmp.payload = tmp.next.payload;
                    tmp.next.payload = storage;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}