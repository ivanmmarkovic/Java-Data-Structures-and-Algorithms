

public class Node {

    public Node next; 
    public int payload;

    public Node(int payload){
        this.payload = payload;
        this.next = null;
    }

    public Node(int payload, Node next){
        this.payload = payload;
        this.next = next;
    }

}