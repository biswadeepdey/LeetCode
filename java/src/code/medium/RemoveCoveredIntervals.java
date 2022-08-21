package code.medium;
import java.util.*;
public class RemoveCoveredIntervals {
	public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b)->{
        	int d = Integer.compare(a[0], b[0]);
        	if(d == 0)
        	{
        		return Integer.compare(b[1], a[1]);
        	}
        	return d;
        });
        
        int min = intervals[0][0];
        int max = intervals[0][1];
        
        int result = intervals.length;
        int count = 1;
        while(count < intervals.length)
        {
        	if(min<= intervals[count][0] && max >=intervals[count][1])
        	{
        		result--;
        	}
        	else
        	{
        		min = intervals[count][0];
        		max = intervals[count][1];
        	}
        	count++;
        }
        
        return result;
    }
	
	public static void main(String[] args)
	{
		RemoveCoveredIntervals obj = new RemoveCoveredIntervals();
		System.out.println(obj.removeCoveredIntervals(new int[][] {
			new int[] {1,4},
			new int[] {3,6},
			new int[] {2,8}
		}));
	}
}
