package code.easy;
import code.nodes.ListNode;

public class RemoveDuplicatesFromSortedList {
	public static ListNode RemoveDuplicates(ListNode head)
	{
		ListNode current = head;
		int counter = 0;
		while(current != null && current.next != null)
		{
			System.out.println(++counter);
			if(current.val == current.next.val)
			{
				current.val = current.next.val;
				current.next = current.next.next;
			}
			else
			{
				current = current.next;
			}
		}
		return head;
	}
}
