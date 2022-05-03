package ivanmarkovic.algorithms.recursion;

public class Factorial {
	
	public static void main(String args[]) {
		
		for(int i = 0; i <= 6; i++)
			System.out.println("Factorial of " + i + " is " + factorialRecursive(i));
		
		System.out.println("-------------------------------------------------------");
		
		for(int i = 0; i <= 6; i++)
			System.out.println("Factorial of " + i + " is " + factorialIterative(i));
	}
	
	public static int factorialRecursive(int n) {
		if(n <= 1)
			return 1;
		else 
			return n * factorialRecursive(n - 1);

	}
	
	public static int factorialIterative(int n) {
		if(n <= 1)
			return 1;
		int f = 1;
		while(n > 1) {
			f *= n;
			n--;
		}
		return f;
	}

}
