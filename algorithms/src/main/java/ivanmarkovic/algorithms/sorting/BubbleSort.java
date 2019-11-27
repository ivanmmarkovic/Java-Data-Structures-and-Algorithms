package ivanmarkovic.algorithms.sorting;

public class BubbleSort {
	
	
	public static void main(String args[]) {
		int numbers[] = {3, 54, 12, 1, 101, 93, 43};
		printArray(numbers);
		bubbleSort(numbers);
		printArray(numbers);
	}
	
	public static void bubbleSort(int numbers[]) {
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = numbers.length - 1; j > i; j--) {
				if(numbers[j - 1] > numbers[j]) {
					int strg = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = strg;
				}
			}
		}
	}
	
	public static void printArray(int nums[]) {
		for(int e: nums)
			System.out.print(e + ", ");
		System.out.println();
	}

}
