

public class Stack {

    public Node head;

    public Stack(){
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public int size(){
        int count = 0;
        Node current = this.head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    public void push(int payload){
        if(this.isEmpty())
            this.head = new Node(payload);
        else  
            this.head = new Node(payload, this.head);
    }

    public Integer pop(){
        if(this.isEmpty())
            return null;
        else {
            Integer retValue = this.head.payload;
            this.head = this.head.next;
            return retValue;
        }
    }

    public Integer peek(){
        if(this.isEmpty())
            return null;
        else     
            return this.head.payload;
    }
}