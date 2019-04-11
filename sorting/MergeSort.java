package sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int numbers[] = {17, 34, 2, 15, 1, 95, 14, 25};
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
		mergeSort(numbers);
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void mergeSort(int numbers[]) {
		if(numbers.length > 1) {
			int midpoint = numbers.length / 2;
			int leftArray[] = Arrays.copyOfRange(numbers, 0, midpoint);
			int rightArray[] = Arrays.copyOfRange(numbers, midpoint, numbers.length);
			mergeSort(leftArray);
			mergeSort(rightArray);
			int i = 0, j = 0, k = 0;
			while(i < leftArray.length && j < rightArray.length) {
				if(leftArray[i] < rightArray[j]) {
					numbers[k] = leftArray[i];
					i++;
					k++;
				}
				else {
					numbers[k] = rightArray[j];
					j++;
					k++;
				}
			}
			while(i < leftArray.length) {
				numbers[k] = leftArray[i];
				i++;
				k++;
			}
			while(j < rightArray.length) {
				numbers[k] = rightArray[j];
				j++;
				k++;
			}
		}
	}

}
