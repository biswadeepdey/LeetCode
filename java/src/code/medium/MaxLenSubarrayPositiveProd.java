package code.medium;

public class MaxLenSubarrayPositiveProd {
	public int getMaxLen(int[] nums) 
	{
		
		int start = -1;
		for(int i = 0; i < nums.length; i++)
		{
			if(nums[i] != 0)
			{
				start = i;
				break;
			}
		}
		
		if(start == -1)
		{
			return 0;
		}
		
		int end = 0;
		int minusStart = (nums[start] < 0) ? start : -1;
		int minusEnd = -1;
		boolean positive = (nums[start] > 0) ? true : false;
		int maxLength = Integer.MIN_VALUE;
		
		for(int i = start + 1; i <= nums.length;)
		{
			if(i < nums.length && nums[i] < 0 && minusStart == -1)
			{
				minusStart = i;
				positive = !positive;
			}
			else if(i < nums.length && nums[i] < 0)
			{
				minusEnd = i;
				positive = !positive;
			}
			
			if(i == nums.length || nums[i] == 0)
			{
				end = i;
				if(positive)
				{
					maxLength = Integer.max(maxLength, i - start);
				}
				else
				{
					if(minusEnd != -1)
					{
						maxLength = Integer.max(maxLength, Integer.max(end - (minusStart + 1), minusEnd - start));
					}
					else
					{
						maxLength = Integer.max(maxLength, Integer.max(minusStart - start, end - (minusStart + 1)));
					}
				}
				
				if(i == nums.length)
				{
					break;
				}
				
				while(nums[i] == 0)
				{
					i++;
				}
				start = i;
				if(start == nums.length)
				{
					break;
				}
				positive = (nums[start] > 0) ? true : false;
				minusStart = (nums[start] < 0) ? start : -1;
				i = start + 1;
				continue;
			}
			i++;
		}
		
		return maxLength;
	}
	
	public static void main(String[] args)
	{
		MaxLenSubarrayPositiveProd obj = new MaxLenSubarrayPositiveProd();
		System.out.println(obj.getMaxLen(new int[] {0,-19,26,-24,-13,-2,26,10,0,4,0,-26,-22,9,35,-11,-14,0,-29}));
	}
}
