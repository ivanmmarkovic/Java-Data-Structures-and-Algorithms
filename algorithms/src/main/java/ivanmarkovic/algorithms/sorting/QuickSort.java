package ivanmarkovic.algorithms.sorting;

public class QuickSort {
	
	public static void main(String args[]) {
		int numbers[] = {3, 54, 12, 1, 101, 93, 43};
		printArray(numbers);
		quicksort(numbers, 0, numbers.length - 1);
		printArray(numbers);
	}
	
	public static void quicksort(int numbers[], int start, int end) {
		
		if(start >= end)
			return;
		
		int left = start;
		int right = end;
		int pointer = left;
		
		int pivotIndex = left + (right - left) / 2;
		int pivotValue = numbers[pivotIndex];
		
		int tmp;
		while(pointer <= right) {
			if(numbers[pointer] < pivotValue) {
				tmp = numbers[left];
				numbers[left] = numbers[pointer];
				numbers[pointer] = tmp;
				left++;
				pointer++;
			}
			else if(numbers[pointer] > pivotValue) {
				tmp = numbers[right];
				numbers[right] = numbers[pointer];
				numbers[pointer] = tmp;
				right--;
			}
			else
				pointer++;
		}
		
		quicksort(numbers, start, left);
		if(right > left)
			quicksort(numbers, right, end);
		else
			quicksort(numbers, left + 1, end);
		
		
	}
	
	public static void printArray(int nums[]) {
		for(int e: nums)
			System.out.print(e + ", ");
		System.out.println();
	}

}
