package code.medium;
import java.util.*;

public class PreviousGreaterElementClass {
	public static int[] PreviousGreaterElement(int[] nums)
	{
		int[] arr = new int[nums.length];
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < arr.length; i++)
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
