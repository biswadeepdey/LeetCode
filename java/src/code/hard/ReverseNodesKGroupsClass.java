package code.hard;
import code.nodes.*;
import java.util.*;

public class ReverseNodesKGroupsClass {
	public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null)
        	return head;
        
        Stack<ListNode> s = new Stack<ListNode>();
        ListNode output = null, q = null, p = head;
        
        while(true)
        {
        	int i = 1;
        	ListNode temp = null;
        	do {
        		if(p == null)
        		{
        			break;
        		}
        		
        		s.push(p);
        		if(i == k)
        		{
        			temp = p.next;
        		}
        		i++;
        		p = p.next;
        	}while(i <= k);
        	
        	if(s.size() < k)
        	{
        		break;
        	}
        	
        	int j = 0;
        	while(j < k)
        	{
        		if(output == null)
        		{
        			output = s.pop();
        			q = output;
        		}
        		else
        		{
        			q.next = s.pop();
        			q = q.next;
        		}
        		j++;
        	}
        	
        	if(q != null)
        	{
        		q.next = temp;
        	}
        	p = q.next;
        }
        
        return output;
    }
}
