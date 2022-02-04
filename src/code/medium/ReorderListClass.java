package code.medium;
import code.nodes.*;
import java.util.*;

public class ReorderListClass {
	public static void ReorderList(ListNode head)
	{
		Stack<ListNode> stack = new Stack<ListNode>();
		
		ListNode point = head;
		while(point != null)
		{
			stack.push(point);
			point = point.next;
		}
		
		point = head;
		while(point.next != null)
		{
			ListNode node = stack.pop();
			ListNode temp = point.next;
			point.next = node;
			node.next = temp;
			
			ListNode remover = node;
			while(remover.next.val != node.val)
			{
				remover = remover.next;
			}
			
			remover.next = null;
			
			point = node.next;
		}
	}
	
	static ListNode reverseList(ListNode head)
	{
		ListNode pre = null;
		ListNode curr = head;
		ListNode next = curr.next;
		
		while(curr != null)
		{
			curr.next = pre;
			pre = curr;
			curr = next;
			next = curr != null ? curr.next : null;
		}
		
		return pre;
	}
	
	public static void reorderList2(ListNode head)
	{
		int count = -1;
		ListNode p = head;
		
		while(p != null)
		{
			count++;
			p = p.next;
		}
		
		if(count == 0)
            return;
		
		int mid = count / 2;
		ListNode nextHead = head;
		while(mid > 0)
		{
			nextHead = nextHead.next;
			mid--;
		}
		
		ListNode t = nextHead.next;
		nextHead.next = null;
		
		ListNode newHead = reverseList(t);
		ListNode point = head;
		
		while(point != null)
		{
			ListNode temp = point.next;
			ListNode temp2 = newHead != null ? newHead.next : null;
			
			if(newHead != null)
			{
				newHead.next = point.next;
			}
			
			point.next = newHead;
			newHead = temp2;
			point = temp;
		}
	}
}
