package code.hard;
import java.util.*;
public class MedianFinder {
	Vector<Integer> list;
	
	public MedianFinder() {
        list = new Vector<Integer>();
    }
    
    public void addNum(int num) {
        int lo = 0, hi = list.size() - 1;
        while(lo < hi)
        {
            int mid = (lo + hi) / 2;
            if(list.get(mid) >= num)
            {
                hi = mid;
            }
            else
            {
                lo = mid + 1;
            }
        }

        if(list.size() == 0)
        {
        	list.add(num);
        }
        else
        {
        	list.add(lo + 1, num);
        }
        System.out.println(list);
    }
    
    public double findMedian() {
        if((list.size() % 2) != 0)
        {
            return list.get((list.size() - 1) / 2);
        }
        else
        {
            int mid = list.size() / 2;
            return ((double)list.get(mid - 1) + list.get(mid)) / 2;
        }
    }
    
    public static void main(String[] args)
    {
    	MedianFinder obj = new MedianFinder();
    	
    	obj.addNum(-1);
    	obj.addNum(-2);
    	System.out.println(obj.findMedian());
    	obj.addNum(-3);
    	System.out.println(obj.findMedian());
    	obj.addNum(-4);
    	System.out.println(obj.findMedian());
    	obj.addNum(-5);
    	System.out.println(obj.findMedian());
    }

}
