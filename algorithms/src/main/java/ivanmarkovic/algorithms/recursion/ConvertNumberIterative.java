package ivanmarkovic.algorithms.recursion;

public class ConvertNumberIterative {
	
	public static String converter(int num, int base) {
		String digits = "0123456789ABCDEF";
		
		StringBuilder sb = new StringBuilder();
		while(num > 0) {
			sb.append(digits.charAt(num % base));
			num = num / base;
		}
		
		sb.reverse();
		return sb.toString();
	}

}
