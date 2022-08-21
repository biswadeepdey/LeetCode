package code.easy;

public class SearchInsertPositionClass {
	
	public static int SearchInsertPosition(int[] nums, int target, int start, int end)
	{
		if(start == end)
		{
			if(target > nums[end])
			{
				return end + 1;
			}
			else if(target < nums[start])
			{
				return start;
			}
			else if(target == nums[start])
			{
				return start;
			}
		}
		
		int mid = (start + end - 1) / 2;
		
		if(target > nums[mid] && target < nums[mid + 1])
		{
			return mid + 1;
		}
		else if(target <= nums[mid])
		{
			return SearchInsertPosition(nums, target, start, mid);
		}
		else if(target >= nums[mid])
		{
			return SearchInsertPosition(nums, target, mid + 1, end);
		}
		
		return -1;
	}
	
	public static int SearchInsertPosition(int[] nums, int target)
	{
		return SearchInsertPosition(nums, target, 0, nums.length - 1);
	}
}
