package sorting;

public class ShortBubble {

	public static void main(String[] args) {

		int numbers[] = {17, 34, 2, 15, 1, 95, 14, 25};
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
		shortBubble(numbers);
		for(int number: numbers)
			System.out.print(number + " ");
		System.out.println();
	}
	
	public static void shortBubble(int numbers[]) {
		boolean swapped;
		int tmp;
		int dec = 1;
		do {
			swapped = false;
			for(int i = 0; i < numbers.length - dec; i++) {
				if(numbers[i] > numbers[i + 1]) {
					tmp = numbers[i];
					numbers[i] = numbers[i + 1];
					numbers[i + 1] = tmp;
					swapped = true;
				}
			}
			dec++;
		}while(swapped);
	}

}
