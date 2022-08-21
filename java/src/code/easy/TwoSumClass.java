package code.easy;

import java.util.HashMap;

public class TwoSumClass {
	public static int[] TwoSumBruteForce(int[] nums, int target)
	{
		for(int i = 0; i < nums.length - 1; i++)
		{
			for(int j = i+1; j < nums.length; j++)
			{
				if(nums[i] + nums[j] == target)
				{
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {};
	}
	
	public static int[] TwoSum(int[] nums, int target)
	{
		HashMap<Integer, Integer> lookBackMap = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++)
		{
			if(lookBackMap.containsKey(nums[i]))
			{
				return new int[] {lookBackMap.get(nums[i]), i};
			}
			
			lookBackMap.put(target - nums[i], i);
		}
		
		return new int[] {};
	}
}
