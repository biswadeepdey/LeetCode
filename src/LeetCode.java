import static org.junit.Assert.assertEquals;

import code.easy.*;
import code.medium.*;
import code.hard.*;
import code.nodes.*;
import code.exercise.*;
import java.util.*;

class Node implements Comparable<Node>
{
	public String data;
	public int priority;
	
	public Node(String data, int priority)
	{
		this.data = data;
		this.priority = priority;
	}
	
	@Override
	public int compareTo(Node obj)
	{
		if(data == obj.data && priority != obj.priority)
		{
			
			obj.priority = this.priority;
			return 0;
		}
		
		if(data == obj.data)
		{
			return 0;
		}
		
		if(priority > obj.priority)
			return 1;
		else
			return -1;
	}
	
	@Override
	public int hashCode()
	{
		return Integer.parseInt("" + this.data.charAt(0));
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		if(this == obj)
			return true;
		
		Node n = (Node)obj;
		if(n.data != data)
			return false;
		
		return true;
	}
	
	
}

class NodeComparator implements Comparator<Node>
{
	@Override
	public int compare(Node a, Node b)
	{
		if(a.priority == b.priority)
			return 0;
		else if (a.priority > b.priority)
			return 1;
		else
			return -1;
	}
}

public class LeetCode {
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		ReorderListClass.reorderList2(l1);
		
		ListNode p = l1;
		while(p != null)
		{
			System.out.println(p.val);
			p = p.next;
		}
	}

}
