package ivanmarkovic.algorithms.recursion;

public class FibonacciRecursiveSolutionWorst {
	
	
	public static void main(String args[]) {
		for(int i = 1; i <= 6; i++)
			System.out.println("Fibonacci " + i + " is " + fibonacci(i));
	}
	
	public static int fibonacci(int n) {
		if(n == 1)
			return 0;
		else if (n == 2) 
			return 1;
		else
			return fibonacci(n - 1) + fibonacci(n - 2);
	}

}
