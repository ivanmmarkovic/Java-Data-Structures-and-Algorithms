package ivanmarkovic.algorithms.recursion;

public class PalindromeRecursive {
	
	public static boolean palindromeChecker(String s) {
		return palindromeCheckerHelper(s, 0, s.length() - 1);
	}

	private static boolean palindromeCheckerHelper(String s, int start, int end) {
		if(start >= end)
			return true;
		else {
			if(s.charAt(start) != s.charAt(end))
				return false;
			return palindromeCheckerHelper(s, start + 1, end - 1);
		}
	}

}
