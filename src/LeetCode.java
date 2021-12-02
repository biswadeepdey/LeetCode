import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;
import code.medium.*;
import code.hard.*;
import code.nodes.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(5);
		
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		
		ListNode l3 = new ListNode(2);
		l3.next = new ListNode(6);
		
		ListNode[] lnr = new ListNode[] {l1, l2, l3};
		
		ListNode mkl = MergeKListsClass.mergeKLists(lnr);
		
		ListNode p = mkl;
		while(p != null)
		{
			System.out.println(p.val);
			p = p.next;
		}
	}

}
