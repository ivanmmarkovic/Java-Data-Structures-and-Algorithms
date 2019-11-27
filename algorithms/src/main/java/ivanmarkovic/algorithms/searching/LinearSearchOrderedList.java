package ivanmarkovic.algorithms.searching;

public class LinearSearchOrderedList {
	
	public static boolean search(int numbers[], int element) {
		boolean stop = false;
		boolean found = false;
		int count = 0;
		while (count < numbers.length && !found && !stop) {
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
