package ivanmarkovic.algorithms.sorting;

public class SelectionSort {
	
	public static void main(String args[]) {
		int numbers[] = {3, 54, 12, 1, 101, 93, 43};
		printArray(numbers);
		selectionSort(numbers);
		printArray(numbers);
	}
	
	public static void selectionSort(int numbers[]) {
		
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
	
	public static void printArray(int nums[]) {
		for(int e: nums)
			System.out.print(e + ", ");
		System.out.println();
	}

}
