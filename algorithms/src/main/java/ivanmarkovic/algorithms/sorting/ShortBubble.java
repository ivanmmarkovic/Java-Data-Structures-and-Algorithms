package ivanmarkovic.algorithms.sorting;

public class ShortBubble {
	
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

}
