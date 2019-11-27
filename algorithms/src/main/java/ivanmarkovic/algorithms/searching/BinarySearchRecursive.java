package ivanmarkovic.algorithms.searching;

public class BinarySearchRecursive {
	
	public static boolean search(int numbers[], int element, int start, int end) {
		if(start > end)
			return false;
		else {
			int midpoint = start + (end - start) / 2;
			if(numbers[midpoint] == element)
				return true;
			else 
				if(numbers[midpoint] > element)
					return search(numbers, element, start, midpoint - 1);
				else
					return search(numbers, element, midpoint + 1, end);
		}
		
	}

}
