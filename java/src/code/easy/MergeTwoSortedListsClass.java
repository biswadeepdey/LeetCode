package code.easy;

import code.nodes.*;

public class MergeTwoSortedListsClass {
	public static ListNode MergeSortedLists(ListNode l1, ListNode l2)
	{
		ListNode newList = null;
		ListNode headNewList = null;
		
		while(l1 != null || l2 != null)
		{
			if(l1 == null)
			{
				if(headNewList == null)
				{
					newList = new ListNode(l2.val);
					headNewList = newList;
				}
				else
				{
					newList.next = new ListNode(l2.val);
					newList = newList.next;
				}
				
				l2 = l2.next;
			}
			else if(l2 == null)
			{
				if(headNewList == null)
				{
					newList = new ListNode(l1.val);
					headNewList = newList;
				}
				else
				{
					newList.next = new ListNode(l1.val);
					newList = newList.next;
				}
				
				l1 = l1.next;
			}
			else
			{
				if(l1.val < l2.val)
				{
					if(headNewList == null)
					{
						newList = new ListNode(l1.val);
						headNewList = newList;
					}
					else
					{
						newList.next = new ListNode(l1.val);
						newList = newList.next;
					}
					
					l1 = l1.next;
				}
				else
				{
					if(headNewList == null)
					{
						newList = new ListNode(l2.val);
						headNewList = newList;
					}
					else
					{
						newList.next = new ListNode(l2.val);
						newList = newList.next;
					}
					
					l2 = l2.next;
				}
			}
		}
		
		return headNewList;
	}
}
