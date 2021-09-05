import code.easy.*;
import code.nodes.ListNode;

public class LeetCode {

	public static void main(String[] args) {
		ListNode l1 = null;
		ListNode l2 = null;
		
		
		
		ListNode output = MergeTwoSortedListsClass.MergeSortedLists(l1, l2);
		
		while(output != null)
		{
			System.out.println(output.val);
			output = output.next;		
		}
	}

}
