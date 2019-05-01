
public class Main {

	public static void main(String[] args) {
		
		Stack stack = new Stack(5);
		
		stack.push(15);
		stack.push(3);
		stack.push(10);
		stack.push(1);
		stack.push(100);
		
		stack.push(1000);
		
		System.out.println(stack);
		
		while(!stack.isEmpty())
			System.out.println("Removed : " + stack.pop());
		
		System.out.println(stack);
		stack.pop();
	}

}
