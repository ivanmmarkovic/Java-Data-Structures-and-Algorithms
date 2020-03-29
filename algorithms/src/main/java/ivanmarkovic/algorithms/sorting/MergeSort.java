package ivanmarkovic.algorithms.sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int numbers[] = {23, 4, 21, 1, 99, 7, 45};
		// int numbers[] = {};
		// int numbers[] = {1, 2};
		int numbers[] = {2};
		mergeSort(numbers);
		for(int n: numbers)
			System.out.print(n + ", ");
		System.out.println();
	}
	
	public static void mergeSort(int numbers[]) {
		if(numbers.length >= 2) {
			int midpoint = numbers.length / 2;
			int left[] = Arrays.copyOfRange(numbers, 0, midpoint);
			int right[] = Arrays.copyOfRange(numbers, midpoint, numbers.length);
			
			mergeSort(left);
			mergeSort(right);
			
			int i = 0, j = 0, k = 0;
			while(i < left.length && j < right.length) {
				if(left[i] <= right[j]) 
					numbers[k++] = left[i++];
				else
					numbers[k++] = right[j++];
			}
			while(i < left.length) {
				numbers[k++] = left[i++];
			}
			while(j < right.length) {
				numbers[k++] = right[j++];
			}
		}
	}

}
