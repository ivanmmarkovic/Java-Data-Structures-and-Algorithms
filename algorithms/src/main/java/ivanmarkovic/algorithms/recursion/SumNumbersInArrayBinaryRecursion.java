package ivanmarkovic.algorithms.recursion;

public class SumNumbersInArrayBinaryRecursion {
	
	
	public static int sumNumbers(int nums[]) {
		return helper(nums, 0, nums.length - 1);
	}

	private static int helper(int[] nums, int start, int end) {
		if(start > end)
			return 0;
		else {
			int index = start + (end - start) / 2;
			return helper(nums, start, index - 1) + nums[index] + helper(nums, index + 1, end);
		}
	}
	
	

}
