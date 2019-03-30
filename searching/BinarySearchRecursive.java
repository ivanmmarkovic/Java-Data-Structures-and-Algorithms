/*
 * Avoid slicing array
 * allocates a new array - space
 * copies the elements from the original array to the new array - time
 */

public class BinarySearchRecursive {

	public static void main(String[] args) {
		int numbers[] = {1, 3, 4, 5, 7, 11, 15, 19, 21, 22};
		System.out.println(binarySearchRecursive(numbers, 5, 0, numbers.length - 1)); // true
		System.out.println(binarySearchRecursive(numbers, 10, 0, numbers.length - 1)); // false
	}
	
	public static boolean binarySearchRecursive(int numbers[], int number, int start, int end) {
		if(start > end)
			return false;
		else if(start <= end){
			int midpoint = (start + end) / 2;
			if(numbers[midpoint] == number)
				return true;
			else {
				if(numbers[midpoint] > number)
					return binarySearchRecursive(numbers, number, start, midpoint - 1);
				else
					return binarySearchRecursive(numbers, number, midpoint + 1, end);
			}
		}
		return false;
	}

}
