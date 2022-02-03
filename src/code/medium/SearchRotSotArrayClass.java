package code.medium;

public class SearchRotSotArrayClass {
	
	public static int bSearch(int[] nums, int lo, int hi, int target)
	{
		while(true)
		{
			int mid = (lo + hi) / 2;
			if(nums[mid] == target) return mid;
			
			if(lo == hi)
				return -1;
			
			if(target < nums[mid])
			{
				hi = mid;
			}
			else
			{
				lo = mid + 1;
			}
		}
		
	}
	
	public static int SearchRotSotArray(int[] nums, int target) {
		int loIdx = 0;
		for(int i = 0; i < nums.length; i++)
			if(nums[i] < nums[loIdx])
				loIdx = i;
		
		if(nums[loIdx] == target) return loIdx;
		if(nums[0] == target) return 0;
		if(nums[nums.length - 1] == target) return nums.length - 1;
		if(loIdx - 1 >= 0 && nums[loIdx - 1] == target) return loIdx - 1;
		if(loIdx + 1 < nums.length && nums[loIdx + 1] == target) return loIdx + 1;
		
		if(nums[0] < target && nums[loIdx - 1] > target)
			return bSearch(nums, 0, loIdx - 1, target);
		
		if(nums[loIdx + 1] < target && nums[nums.length - 1] > target)
			return bSearch(nums, loIdx + 1, nums.length - 1, target);
			
		return -1;
	}
}
