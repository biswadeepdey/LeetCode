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
	
	static boolean canConstruct(String target, Vector<String> wordBank)
	{
		if(target.equals("")) return true;
		
		for(String word : wordBank)
		{
			if(target.indexOf(word) == 0)
			{
				String suffix = target.substring(word.length());
				if(canConstruct(suffix, wordBank))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		
		System.out.println(Integer.min(2,2));
		
//		List<String> l = new LinkedList<String>();
//		List<List<String>> equations = new LinkedList<List<String>>(); 
//		l.add("a");l.add("b");
//		equations.add(l);
//		l = new LinkedList<String>();
//		l.add("b");l.add("c");
//		equations.add(l);
//		
//		double[] values = new double[] {2.0,3.0};
//		
//		List<String> q = new LinkedList<String>();
//		List<List<String>> queries = new LinkedList<List<String>>(); 
//		q.add("a");q.add("c");
//		queries.add(q);
//		q = new LinkedList<String>();
//		q.add("b");q.add("a");
//		queries.add(q);
//		q = new LinkedList<String>();
//		q.add("a");q.add("e");
//		queries.add(q);
//		q = new LinkedList<String>();
//		q.add("a");q.add("a");
//		queries.add(q);
//		q = new LinkedList<String>();
//		q.add("x");q.add("x");
//		queries.add(q);
//		
//		double[] d = EvaluateDivisionClass.calcEquation(equations, values, queries);
//		for(int i = 0; i < d.length; i++)
//		{
//			System.out.println(d[i]);
//		}
		
//		int[] nums = new int[] {10, 20, 30, 40};
//		int[] arr = NextGreaterElementClass.NextGreaterElement(nums);
//		for(int i = 0; i < arr.length; i++)
//		{
//			System.out.print(arr[i] + ", ");
//		}
		
		System.out.print("\n");
		
	}

}
