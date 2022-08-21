package code.medium;

import java.util.*;

public class KClosestPointsClass {
	class Point implements Comparable<Point>{
        int x;
        int y;
        public Point(int x, int y)
        {
        	this.x = x;
        	this.y = y;
        }
        
        public int compareTo(Point p)
        {
        	int d1 = (this.x * this.x) + (this.y * this.y);
        	int d2 = (p.x * p.x) + (p.y * p.y);
        	
        	if(d1 < d2)
        	{
        		return -1;
        	}
        	else
        	{
        		return 1;
        	}
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<Point>();
        
        for(int i = 0; i < points.length; i++)
        {
        	Point p = new Point(points[i][0], points[i][1]);
        	pq.add(p);
        }
        
        int[][] result = new int[k][2];
        
        for(int i = 0; i < k; i++)
        {
        	Point p = pq.poll();
        	result[i][0] = p.x;
        	result[i][1] = p.y;
        }
        
        return result;
    }
    
    public static int[][] kClosest2(int[][] points, int k) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for(int i = 0; i < points.length; i++)
    	{
    		int key = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
    		map.put(key, i);
    	}
    	
    	int[][] result = new int[k][2];
    	
    	SortedSet<Integer> ss = new TreeSet<Integer>(map.keySet());
    	
    	int count = 0;
    	Iterator<Integer> itr = ss.iterator();
    	while(itr.hasNext()) {
    		
    		if(count < k)
    		{
    			result[count++] = points[map.get(itr.next())];
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	return result;
    }
}
