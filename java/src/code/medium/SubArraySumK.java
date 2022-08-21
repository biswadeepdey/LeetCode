package code.medium;
import java.util.*;


public class SubArraySumK {
	public static int SubArraySumEqualK(int[] nums, int k)
	{
		int lastSize = 0; int loopIndex = 0;
		Vector<Integer> v = new Vector<Integer>();
		for(int i = 0; i < nums.length; i++)
		{
			v.add(nums[i]);
			int j = loopIndex;
			int loopCount = lastSize;
			while(loopCount > 0)
			{
				v.add(nums[i] + v.get(j));
				loopCount--;
				j++;
			}
			
			loopIndex = loopIndex + lastSize;
			lastSize = v.size() - lastSize;
			
		}
		
		int count = 0;
		for(int i : v)
		{
			if(i == k)
				count++;
		}
		
		return count;
	}
}
