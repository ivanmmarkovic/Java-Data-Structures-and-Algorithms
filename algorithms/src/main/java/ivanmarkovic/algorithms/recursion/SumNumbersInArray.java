package ivanmarkovic.algorithms.recursion;

public class SumNumbersInArray {
	
	
	public static int sumNumbers(int nums[]) {
		return helper(nums, nums.length - 1);
	}

	private static int helper(int[] nums, int i) {
		if(i < 0)
			return 0;
		else
			return nums[i] + helper(nums, i - 1);
	}
	
	
	public static int iterative(int nums[]) {
		int end = nums.length - 1;
		int sum = 0;
		while(end >= 0) {
			sum += nums[end];
			end--;
		}
		return sum;
	}

}
