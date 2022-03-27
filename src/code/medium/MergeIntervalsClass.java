package code.medium;
import java.util.*;

public class MergeIntervalsClass {
	
	public static int[][] Helper(int[][] intervals)
	{
		Arrays.sort(intervals, (i0, i1) -> Integer.compare(i0[0], i1[0]));
		Stack<int[]> stack = new Stack<int[]>();
		for(int i = intervals.length - 1; i >= 0; i--)
		{
			stack.push(intervals[i]);
		}
		
		Vector<int[]> v = new Vector<int[]>();
		while(!stack.isEmpty())
		{
			boolean found = false;
			int[] smaller = stack.pop();
			if(stack.isEmpty())
			{
				v.add(smaller);
				continue;
			}
			
			int[] bigger = stack.pop();
			
			int ss = smaller[0];
			int se = smaller[1];
			int bs = bigger[0];
			int be = bigger[1];
			
			int hi = 0, lo = 0;
			if(se >= bs)
			{
				hi = be;
				
				if(ss < bs)
				{
					lo = ss;
				}
				else
				{
					lo = bs;
				}
				found = true;
			}
			
			if(found)
			{
				int[] newInt = new int[] {lo, hi};
				stack.push(newInt);
			}
			else
			{
				v.add(smaller);
				stack.push(bigger);
			}
		}
		
		int result[][] = new int[v.size()][2];
		int count = 0;
		for(int[] a : v)
		{
			result[count++] = a;
		}
		
		return result;
	}
	
	public static int[][] MergeIntervals(int[][] intervals)
	{
		int currentLength = intervals.length;
		int lastLength = 0;
		int[][] newIntervals = intervals;
		while(currentLength != lastLength)
		{
			lastLength = currentLength;
			newIntervals = Helper(newIntervals);
			currentLength = newIntervals.length; 
		}
		
		return newIntervals;
	}
}
