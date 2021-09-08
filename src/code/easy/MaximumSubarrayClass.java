package code.easy;

public class MaximumSubarrayClass {
	public static int MaximumSubarray(int[] nums)
	{
		int maxCurrent = nums[0], maxGlobal = nums[0];
		
		for(int i = 1; i < nums.length; i++)
		{	
			maxCurrent = Integer.max(nums[i], maxCurrent + nums[i]);
			if(maxGlobal < maxCurrent)
			{
				maxGlobal = maxCurrent;
			}
		}

		return maxGlobal;
	}
}
