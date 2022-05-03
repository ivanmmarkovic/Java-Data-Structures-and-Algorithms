package ivanmarkovic.algorithms.recursion;

public class Factorial {
	
	public static void main(String args[]) {
		
		for(int i = 0; i <= 6; i++)
			System.out.println("Factorial of " + i + " is " + factorialRecursive(i));
	}
	
	public static int factorialRecursive(int n) {
		if(n <= 1)
			return 1;
		else 
			return n * factorialRecursive(n - 1);

	}

}
