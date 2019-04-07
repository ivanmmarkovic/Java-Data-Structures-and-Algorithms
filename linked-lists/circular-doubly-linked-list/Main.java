package circularDoublyLinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List l = new List();
		l.addToHead(5);
		l.addToHead(117);
		l.addToTail(1001);
		l.addToTail(1002);
		l.addToHead(13);
		l.addToHead(4567);
		l.addToHead(8999);
		l.addToTail(1);
		l.addToTail(2);
		l.sort();
		l.printAll();
	}

}
