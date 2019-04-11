package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int numbers[] = {17, 34, 2, 15, 1, 95, 14, 25};
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
		selectionSort(numbers);
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void selectionSort(int numbers[]) {
		int tmp;
		for(int i = 0; i < numbers.length - 1; i++) {
			int min = i;
			for(int j = i + 1; j < numbers.length; j++) {
				if(numbers[min] > numbers[j])
					min = j;
			}
			if(min != i) {
				tmp = numbers[min];
				numbers[min] = numbers[i];
				numbers[i] = tmp;
			}
		}
	}

}
