package code.medium;

import java.util.Stack;

public class NextGreaterElementClass {
	public static int[] NextGreaterElement(int[] nums)
	{
		int[] arr = new int[nums.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = arr.length - 1; i >= 0 ; i--)
		{
			while(true)
			{
				if(stack.size() > 0)
				{
					if(stack.peek() > nums[i])
					{
						arr[i] = stack.peek();
						stack.push(nums[i]);
						break;
					}
					else
					{
						stack.pop();
					}
				}
				else
				{
					arr[i] = -1;
					stack.push(nums[i]);
					break;
				}
			}
		}
		
		
		return arr;
	}
}
