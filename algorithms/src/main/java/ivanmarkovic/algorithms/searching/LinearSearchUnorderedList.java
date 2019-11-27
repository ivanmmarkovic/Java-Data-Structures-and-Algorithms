package ivanmarkovic.algorithms.searching;

public class LinearSearchUnorderedList {
	
	public static boolean search(int numbers[], int element) {
		boolean found = false;
		int count = 0;
		while (count < numbers.length && !found) {
			if(numbers[count] == element)
				found = true;
			else
				count++;
		}
		return found;
	}

}
