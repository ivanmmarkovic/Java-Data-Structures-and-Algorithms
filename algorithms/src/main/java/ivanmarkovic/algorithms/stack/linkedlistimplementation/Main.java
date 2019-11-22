package ivanmarkovic.algorithms.stack.linkedlistimplementation;

public class Main {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		
		//stack.peek();
		//stack.pop();
		stack.push(2);
		stack.push(14);
		
		System.out.println("Peek : " + stack.peek()); // 14
		/*
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		*/
		for(int i = 100; i <= 500; i+= 100)
			stack.push(i);
		
		System.out.println("Peek : " + stack.peek()); // 300
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
	}

}
