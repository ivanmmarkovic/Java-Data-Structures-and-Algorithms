package ivanmarkovic.algorithms.recursion;

public class FibonacciSumRecursive {
	
	
	public static void main(String args[]) {
		for(int i = 1; i <= 6; i++)
			System.out.println("Fibonacci " + i + " is " + fibonacci(i));
		
		System.out.println("-------------------------------------------");
		
		for(int i = 1; i <= 6; i++)
			System.out.println("Fibonacci " + i + " is " + fibonacciSum(i));
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
	
	
	public static int fibonacciSum(int n) {
		return fibonacciSumHelper(n, 0, 0, 1);
	}
	
	private static int fibonacciSumHelper(int n, int acc, int prev, int curr) {
		if(n == 1)
			return prev;
		else if(n == 2)
			return curr + acc;
		else 
			return fibonacciSumHelper(n - 1, acc + curr, curr, prev + curr);
	}

}
