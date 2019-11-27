package ivanmarkovic.algorithms.sorting;

public class InsertionSort {
	
	public static void shortBubble(int numbers[]) {
		
		for(int i = 1; i < numbers.length; i++) {
			int pos = i;
			int currentValue = numbers[i];
			while (pos > 0 && numbers[pos - 1] > currentValue) {
				numbers[pos] = numbers[pos - 1];
				pos--;
			}
			numbers[pos] = currentValue;
		}
		
	}

}
