
public class BinarySearch {

	public static void main(String[] args) {
		int numbers[] = {1, 3, 4, 5, 7, 11, 15, 19, 21, 22};
		System.out.println(binarySearch(numbers, 5)); // true
		System.out.println(binarySearch(numbers, 10)); // false
	}
	
	public static boolean binarySearch(int numbers[], int number) {
		boolean found = false;
		int start = 0, end = numbers.length - 1;
		while(start <=end && !found) {
			int midpoint =(end + start) / 2;
			if(numbers[midpoint] == number)
				found = true;
			else {
				if(numbers[midpoint] > number)
					end = midpoint - 1;
				else
					start = midpoint + 1;
			}
		}
		return found;
	}

}
