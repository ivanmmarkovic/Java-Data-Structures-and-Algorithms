package ivanmarkovic.algorithms.recursion;

public class FibonacciIterativeSolution {
	
	
	public static void main(String args[]) {
		for(int i = 1; i <= 6; i++)
			System.out.println("Fibonacci " + i + " is " + fibonacci(i));
	}
	
	public static int fibonacci(int n) {
		if(n == 1)
			return 0;
		else if (n == 2) 
			return 1;
		int prev = 0;
		int curr = 1;
		while(n > 2) {
			int tmp = prev + curr;
			prev = curr;
			curr = tmp;
			n--;
		}
		return curr;
	}

}
