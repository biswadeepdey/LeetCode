package code.hard;
import java.util.*;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if(nums.length == 1)
			return nums;
		
		if(nums.length * k == 0)
			return new int[0];
		
		Deque<Integer> de = new LinkedList<Integer>();
		int[] result = new int[nums.length - k + 1];
		int resultIndex = 0;
		
		for(int i = 0; i < nums.length; i++)
		{
			// remove out of index
			while(!de.isEmpty() && de.peek() < i - k + 1)
			{
				de.poll();
			}
			
			while(!de.isEmpty() && nums[de.peekLast()] < nums[i])
			{
				de.pollLast();
			}
			
			de.add(i);
			
			if(i >= k - 1)
			{
				result[resultIndex++] = nums[de.peek()];
			}
		}
		
		return result;
	}
}
