package code.medium;

import code.nodes.*;

public class SwapNodesInPairClass {
	public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
        ListNode prev = null, p = head, q = head.next;
        boolean isFirst = true;
        while(p !=null && q != null)
        {
            p.next = q.next;
            q.next = p;
            
            if(isFirst)
            {
                head = q;
                isFirst = false;
            }
            if(prev != null)
            {
                prev.next = q;
            }
            
            prev = p;
            q = p.next != null ? p.next.next : null;
            p = p.next;
        }
        
        return head;
    }
}
