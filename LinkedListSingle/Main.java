package recap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList();
		
		for(int i = 10; i >= 1; i--)
			l.addToHead(i);
		
		l.deleteNodesWithValue(3);
		l.printAll();

	}

}
