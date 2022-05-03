package ivanmarkovic.algorithms.recursion;

public class ReverseArray {
	
	
	public static void recursive(int nums[]) {
		helper(nums, 0, nums.length - 1);
	}

	private static void helper(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}
	
	public static void iterative(int nums[]) {
		int i = 0, j = nums.length - 1;
		while (i < j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
			i++;
			j--;
		}
	}

}
