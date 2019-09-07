

public class Node {

    Node prev;
    Node next;
    int payload;

    public Node(int payload){
        this.payload = payload;
        this.prev = null;
        this.next = null;
    }

    public Node(int payload, Node prev, Node next){
        this.payload = payload;
        this.prev = prev;
        this.next = next;
    }


}