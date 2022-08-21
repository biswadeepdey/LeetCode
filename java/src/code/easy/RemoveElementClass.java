package code.easy;

public class RemoveElementClass {
	public static int RemoveElement(int[] nums, int val)
	{
		int e = 0;
		boolean eInitialized = false;
		
		for(int i = 0; i < nums.length; i++)
		{
			if(!eInitialized && nums[i] == val)
			{
				eInitialized = true;
				e = i;
			}
			
			if(eInitialized && nums[i] != val)
			{
				nums[e] = nums[i];
				e++;
			}
		}
		
		return !eInitialized && e == 0 ? nums.length : e;
	}
}
