package ivanmarkovic.algorithms.recursion;

public class PalindromeIterative {
	
	
	public static boolean palindromeChecker(String s) {
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}

}
