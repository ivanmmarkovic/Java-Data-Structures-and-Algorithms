
public class Main {

	public static void main(String args[]) {
		
		Queue q = new Queue();
		for(int i = 100; i < 110; i++)
			q.enqueue(i);
		
		while(!q.isEmpty())
			System.out.print(q.dequeue() + ", ");
		
		
		
	}
}
