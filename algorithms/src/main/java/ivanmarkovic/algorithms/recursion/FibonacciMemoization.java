package ivanmarkovic.algorithms.recursion;

import java.util.HashMap;
import java.util.Map;

public class FibonacciMemoization {
	
	
	private static Map<Integer, Integer> memo = new HashMap<>();
	
	public static void main(String args[]) {
		for(int i = 1; i <= 6; i++)
			System.out.println("Fibonacci " + i + " is " + fibonacci(i));
	}
	
	public static int fibonacci(int n) {
		if(n == 1)
			return 0;
		else if (n == 2) 
			return 1;
		else {
			if(!memo.containsKey(n)) {
				int f = fibonacci(n - 1) + fibonacci(n - 2);
				memo.put(n, f);
			}
			return memo.get(n);
		}
	}

}
