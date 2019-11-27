package ivanmarkovic.algorithms.sorting;

public class SelectionSort {
	
	public static void shortBubble(int numbers[]) {
		
		for(int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[j] < numbers[min])
					min = j;
			}
			if(min != i) {
				int strg = numbers[min];
				numbers[min] = numbers[i];
				numbers[i] = strg;
			}
		}
		
	}

}
