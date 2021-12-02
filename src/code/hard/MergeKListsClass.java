package code.hard;

import code.nodes.*;
import java.util.*;

public class MergeKListsClass {
	public static ListNode mergeKLists(ListNode[] lists)
	{
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
        
        for(int i =0; i < lists.length; i++)
        {
            ListNode p = lists[i];
            while(p != null)
            {
                pQueue.add(p.val);
                p = p.next;
            }
        }
        
        
        ListNode lhead = null, p = null;
        
        while(pQueue.peek() != null)
        {
           if(lhead == null)
           {
               lhead = new ListNode(pQueue.poll());
               p = lhead;
           }
            else{
                p.next = new ListNode(pQueue.poll());
                p = p.next;
           }
        }
        
        return lhead;
	}
}
