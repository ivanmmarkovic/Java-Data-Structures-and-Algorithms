package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		int numbers[] = {17, 34, 2, 15, 1, 95, 14, 25};
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
		bubbleSort(numbers);
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void bubbleSort(int numbers[]) {
		int tmp;
		for(int i = 0; i < numbers.length - 1; i++) {
			for(int j = numbers.length - 1; j > i; j--) {
				if(numbers[j - 1] > numbers[j]) {
					tmp = numbers[j - 1];
					numbers[j - 1] = numbers[j];
					numbers[j] = tmp;
				}
			}
		}
	}

}
