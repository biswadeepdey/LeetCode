import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;
import code.nodes.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
		ListNode output = RemoveDuplicatesFromSortedList.RemoveDuplicates(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(3)))))));
		while(output != null)
		{
			System.out.println(output.val);
			output = output.next;
		}
	}

}
