package code.medium;

import java.util.*;
import java.lang.Math;

public class ThreeSumClosestClass {
	public static int threeSumClosest(int[] nums, int target)
	{
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int minSum = Integer.MAX_VALUE;
		
		for(int i = 0; i < nums.length - 2; i++)
		{
			int lo = i + 1; 
			int hi = nums.length - 1;
			
			while(lo < hi)
			{
				int currSum = nums[i] + nums[lo] + nums[hi];
				
				if(currSum != target)
				{
					if(Math.abs(target - currSum) < Math.abs(min))
					{
						min = target - currSum;
						minSum = currSum;
					}
					
					if(currSum > target)
						hi--;
					else
						lo++;
				}
				else
				{
					return nums[i] + nums[lo] + nums[hi];
				}
			}
		}
		
		return minSum;
	}
	
	public static void main(String[] args)
	{
		int[] nums = new int[] {-1,2,1,-4};
		System.out.println(threeSumClosest(nums, 1));
	}
}
