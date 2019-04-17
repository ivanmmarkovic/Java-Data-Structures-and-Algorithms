package xyz;

public class Main {

	public static void main(String[] args) {
		Stack s = new Stack(5);
		
		s.push(21);
		s.push(31);
		s.push(117);
		s.push(2);
		s.push(9);
		
		s.push(91);
		
		System.out.println(s);
		while(!s.isEmpty())
			System.out.println("Removed : " + s.pop());
		
		s.pop();

	}

}
