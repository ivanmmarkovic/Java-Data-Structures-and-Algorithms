package ivanmarkovic.algorithms.sorting;

public class ShortBubble {
	
	public static void main(String args[]) {
		int numbers[] = {3, 54, 12, 1, 101, 93, 43};
		printArray(numbers);
		shortBubble(numbers);
		printArray(numbers);
	}
	
	public static void shortBubble(int numbers[]) {
		boolean swapped;
		do {
			swapped = false;
			for(int i = 0; i < numbers.length - 1; i++) {
				if(numbers[i] > numbers[i + 1]) {
					int strg = numbers[i + 1];
					numbers[i + 1] = numbers[i];
					numbers[i] = strg;
					swapped = true;
				}
			}
		} while (swapped);
		
	}
	
	public static void printArray(int nums[]) {
		for(int e: nums)
			System.out.print(e + ", ");
		System.out.println();
	}
}
