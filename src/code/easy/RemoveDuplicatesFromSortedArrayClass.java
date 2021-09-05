package code.easy;

public class RemoveDuplicatesFromSortedArrayClass {
	public static int RemoveDuplicatesFromSortedArrayInPlace(int[] nums)
	{
		if(nums.length == 0)
		{
			return 0;
		}
		
		int unique = 1;
		int current = nums[0];
		int empty = 1;
		for(int i = 0; i < nums.length - 1; i++)
		{
			if(current != nums[i+1])
			{
				nums[empty] = nums[i+1];
				current = nums[i+1];
				empty++;
				unique++;
			}
		}
		
		return unique;
	}
}
