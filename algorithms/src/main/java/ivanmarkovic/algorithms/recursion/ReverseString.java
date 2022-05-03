package ivanmarkovic.algorithms.recursion;

public class ReverseString {
	
	public static String reverse(String s) {
		
		return helper(s, s.length() - 1);
	}

	private static String helper(String s, int j) {
		if(j < 0)
			return "";
		else
			return String.valueOf(s.charAt(j)) + helper(s, j - 1);
	}
	
	
	public static String iterative(String s) {
		
		char chars[] = new char[s.length()];
		int i = 0, j = chars.length - 1;
		while (i < j) {
			char tmp = chars[i];
			chars[i] = chars[j];
			chars[j] = tmp;
			i++;
			j--;
		}
		return new String(chars);
	}

}
