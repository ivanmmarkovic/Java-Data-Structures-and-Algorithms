package ivanmarkovic.algorithms.sorting;

public class InsertionSort {
	
	public static void main(String args[]) {
		int numbers[] = {3, 54, 12, 1, 101, 93, 43};
		printArray(numbers);
		insertionSort(numbers);
		printArray(numbers);
	}
	
	public static void insertionSort(int numbers[]) {
		
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
	
	public static void printArray(int nums[]) {
		for(int e: nums)
			System.out.print(e + ", ");
		System.out.println();
	}

}
