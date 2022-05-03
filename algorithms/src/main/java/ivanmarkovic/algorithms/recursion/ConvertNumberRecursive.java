package ivanmarkovic.algorithms.recursion;

public class ConvertNumberRecursive {
	
	private static String digits = "0123456789ABCDEF";
	
	public static void main(String args[]) {
		System.out.println(converter(1453, 16)); // 5AD
	}
	
	public static String converter(int num, int base) {
		if(num < base)
			return String.valueOf(digits.charAt(num));
		else
			return converter(num / base, base) +  String.valueOf(digits.charAt(num % base));
	}

}
