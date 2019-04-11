package searching;

public class SequentialSearch {

	public static void main(String[] args) {
		int numbers[] = {17, 34, 2, 15, 1, 95, 14, 25};
		System.out.println("Found 15 : " + sequentialSearch(numbers, 15));
		System.out.println("Found 117 : " + sequentialSearch(numbers, 117));
	}

	public static boolean sequentialSearch(int numbers[], int element) {
		boolean found = false;
		int count = 0;
		while(count < numbers.length && !found) {
			if(numbers[count] == element)
				found = true;
			else
				count++;
		}
		return found;
	}
}
