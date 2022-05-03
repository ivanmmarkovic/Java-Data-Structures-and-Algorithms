package ivanmarkovic.algorithms.recursion;

public class FibonacciRecursiveSolution {
	
	public static void main(String args[]) {
		for(int i = 1; i <= 6; i++)
			System.out.println("Fibonacci " + i + " is " + fibonacci(i));
	}
	
	public static int fibonacci(int n) {
		return fibonacciHelper(n, 0, 1);
	}
	
	private static int fibonacciHelper(int n, int prev, int curr) {
		if(n == 1)
			return prev;
		else if(n == 2)
			return curr;
		else 
			return fibonacciHelper(n - 1, curr, prev + curr);
	}

}
