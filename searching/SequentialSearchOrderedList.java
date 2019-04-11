package searching;

public class SequentialSearchOrderedList {

	public static void main(String[] args) {
		int numbers[] = {1, 2, 14, 15, 17, 25, 34, 95};
		System.out.println("Found 15 : " + sequentialSearchOrderedList(numbers, 15));
		System.out.println("Found 28 : " + sequentialSearchOrderedList(numbers, 28));
	}

	public static boolean sequentialSearchOrderedList(int numbers[], int element) {
		boolean found = false, stop = false;
		int count = 0;
		while(count < numbers.length && !found && !stop) {
			if(numbers[count] == element)
				found = true;
			else 
				if(numbers[count] > element)
					stop = true;
				else
					count++;
		}
		return found;
	}
}
