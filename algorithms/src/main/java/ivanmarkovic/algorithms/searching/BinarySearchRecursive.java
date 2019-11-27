package ivanmarkovic.algorithms.searching;

public class BinarySearchRecursive {
	
	public static boolean search(int numbers[], int element) {
		boolean found = false;
		int start = 0, end = numbers.length - 1;
		int midpoint;
		while(start <= end && !found) {
			midpoint = start + (end - start) / 2;
			if(numbers[midpoint] == element)
				found = true;
			else
				if(numbers[midpoint] > element)
					end = midpoint - 1;
				else
					start = midpoint + 1;
		}
		return found;
	}

}
