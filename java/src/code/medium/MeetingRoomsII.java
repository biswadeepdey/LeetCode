package code.medium;
import java.util.*;

public class MeetingRoomsII {
	public static int minMeetingRooms(int[][] intervals) {
		Arrays.sort(intervals, (a, b)->a[1]-b[1]);
        Arrays.sort(intervals, (a, b)->a[0]-b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
        
        int count = 0;
        
        for(int i = 0; i < intervals.length; i++)
        {
        	if(pq.size() == 0)
        	{
        		pq.add(intervals[i]);
        		count++;
        	}
        	else
        	{
        		int[] min = pq.peek();
        		if(min[1] > intervals[i][0])
        		{
        			pq.add(intervals[i]);
        			count++;
        		}
        		else
        		{
        			pq.poll();
        			pq.add(intervals[i]);
        		}
        	}
        }
        
        return count;
    }
}
