package code.medium;

import java.util.*;

public class SumSubarryRanges {
	
	void biggers(int[] nums, int[] prevBigger, int[] nextBigger)
	{	
		Stack<Integer> prevBStack = new Stack<>();
		Stack<Integer> nextBStack = new Stack<>();
		
		for(int i = 0; i < nums.length; i++)
		{
			int j = nums.length - i - 1;
			
			while(!prevBStack.isEmpty() && nums[prevBStack.peek()] <= nums[i])
			{
				prevBStack.pop();
			}
			if(prevBStack.isEmpty())
			{
				prevBStack.push(i);
			}
			else
			{
				prevBigger[i] = prevBStack.peek();
				prevBStack.push(i);
			}
			
			while(!nextBStack.isEmpty() && nums[nextBStack.peek()] < nums[j])
			{
				nextBStack.pop();
			}
			if(nextBStack.isEmpty())
			{
				nextBStack.push(j);
			}
			else
			{
				nextBigger[j] = nextBStack.peek();
				nextBStack.push(j);
			}
		}
	}
	
	void smallers(int[] nums, int[] prevSmaller, int[] nextSmaller)
	{	
		Stack<Integer> prevBStack = new Stack<>();
		Stack<Integer> nextBStack = new Stack<>();
		
		for(int i = 0; i < nums.length; i++)
		{
			int j = nums.length - i - 1;
			
			while(!prevBStack.isEmpty() && nums[prevBStack.peek()] >= nums[i])
			{
				prevBStack.pop();
			}
			if(prevBStack.isEmpty())
			{
				prevBStack.push(i);
			}
			else
			{
				prevSmaller[i] = prevBStack.peek();
				prevBStack.push(i);
			}
			
			while(!nextBStack.isEmpty() && nums[nextBStack.peek()] > nums[j])
			{
				nextBStack.pop();
			}
			if(nextBStack.isEmpty())
			{
				nextBStack.push(j);
			}
			else
			{
				nextSmaller[j] = nextBStack.peek();
				nextBStack.push(j);
			}
		}
	}
	
	public long subArrayRanges(int[] nums)
	{
		int[] prevBigger, nextBigger, prevSmaller, nextSmaller;
		prevBigger = new int[nums.length];
		nextBigger = new int[nums.length];
		prevSmaller = new int[nums.length];
		nextSmaller = new int[nums.length];
		
		Arrays.fill(prevBigger, -1);
		Arrays.fill(nextBigger, -1);
		Arrays.fill(prevSmaller, -1);
		Arrays.fill(nextSmaller, -1);
		
		biggers(nums, prevBigger, nextBigger);
		smallers(nums, prevSmaller, nextSmaller);
		
		long result = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			int bigLeft = prevBigger[i] == -1 ? i + 1 : i - prevBigger[i];
			int bigRight = nextBigger[i] == -1 ? nums.length - i : nextBigger[i] - i;
			int smallLeft = prevSmaller[i] == -1 ? i + 1 : i - prevSmaller[i];
			int smallRight = nextSmaller[i] == -1 ? nums.length - i : nextSmaller[i] - i;
			
			long value = (long)nums[i] * ((bigLeft * bigRight) - (smallLeft * smallRight));
			result += value;
		}

		return result;
	}
	
	
	public static void main(String[] args)
	{
		SumSubarryRanges obj = new SumSubarryRanges();
		System.out.println(obj.subArrayRanges(new int[] {4, -2, -3, 5, 1}));
	}
}
