package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int numbers[] = {17, 34, 2, 15, 1, 95, 14, 25};
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
		insertionSort(numbers);
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void insertionSort(int numbers[]) {
		for(int i = 1; i < numbers.length; i++) {
			int currentNumber = numbers[i];
			int pos = i;
			while(pos > 0 && numbers[pos - 1] > currentNumber) {
				numbers[pos] = numbers[pos - 1];
				pos--;
			}
			numbers[pos] = currentNumber;
		}
	}

}
