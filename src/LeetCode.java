import static org.junit.Assert.assertEquals;

import code.easy.*;
import code.medium.*;
import code.hard.*;
import code.nodes.*;
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
//		AllOne allOne = new AllOne();
//		allOne.inc("a");
//		allOne.inc("b");
//		allOne.inc("b");
//		allOne.inc("b");
//		allOne.inc("b");
//		allOne.dec("b");
//		allOne.dec("b");
		
		DirectedGraph<String> dg = new DirectedGraph<String>();
		dg.addEdge("A", "B", 6);
		dg.addEdge("A", "E", 5);
		dg.addEdge("A", "F", 5);
		dg.addEdge("B", "C", -1);
		dg.addEdge("C", "D", 3);
		dg.addEdge("E", "B", -2);
		dg.addEdge("E", "C", 1);
		dg.addEdge("F", "E", -2);
		dg.addEdge("F", "G", -1);
		dg.addEdge("G", "D", 3);
		
		
		dg.bellmanFord("A");
		
		
		
//		TreeSet<Node> t = new TreeSet<Node>();
//		t.add(new Node("a", 1));
//		t.add(new Node("b", 2));
//		t.add(new Node("a", 4));
//		t.add(new Node("b", 3));
//		SortedSet<Node> s = new TreeSet<Node>(t);
//		PriorityQueue<Node> pq = new PriorityQueue<Node>(s);

		/*
		 *A, 0
B, 3
C, 1
D, 5
E, 7
F, 6
		 * */
		
//		Node a = new Node("a", 1);
//		pq.add(a);
//		Node b = new Node("b", 2);
//		pq.add(b);
//		Node c = new Node("c", 3);
//		pq.add(c);
//		
//		a.priority = 5;
//		pq.add(a);
//		
//		s.forEach(node -> System.out.println(node.data + ", " + node.priority));
//		
		System.out.println();
	}

}
