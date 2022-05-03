package ivanmarkovic.algorithms.recursion;

public class FibonacciSumIterative {
	
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
		if(n == 1)
			return 0;
		else if (n == 2) 
			return 1;
		
		int acc = 0;
		int prev = 0;
		int curr = 1;
		while(n > 2) {
			int tmp = prev + curr;
			acc += curr;
			prev = curr;
			curr = tmp;
			n--;
		}
		return curr + acc;
	}

}
