package ivanmarkovic.algorithms.queue.arrayimplementation;

public class Main {

	public static void main(String[] args) {
		
		Queue q = new Queue(5);
		
		//q.dequeue();
		q.enqueue(2);
		q.enqueue(15);
		
		for(int i = 100; i <= 500; i+= 100)
			q.enqueue(i);
		
		while (!q.isEmpty()) {
			System.out.println(q.dequeue());
		}

	}

}
