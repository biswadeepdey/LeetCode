import static org.junit.Assert.assertEquals;

import code.easy.*;
import code.medium.*;
import code.hard.*;
import code.nodes.*;
import code.exercise.*;
import java.util.*;

//class Node implements Comparable<Node>
//{
//	public String data;
//	public int priority;
//	
//	public Node(String data, int priority)
//	{
//		this.data = data;
//		this.priority = priority;
//	}
//	
//	@Override
//	public int compareTo(Node obj)
//	{
//		if(data == obj.data && priority != obj.priority)
//		{
//			
//			obj.priority = this.priority;
//			return 0;
//		}
//		
//		if(data == obj.data)
//		{
//			return 0;
//		}
//		
//		if(priority > obj.priority)
//			return 1;
//		else
//			return -1;
//	}
//	
//	@Override
//	public int hashCode()
//	{
//		return Integer.parseInt("" + this.data.charAt(0));
//	}
//	
//	@Override
//	public boolean equals(Object obj)
//	{
//		if(obj == null || getClass() != obj.getClass())
//			return false;
//		
//		if(this == obj)
//			return true;
//		
//		Node n = (Node)obj;
//		if(n.data != data)
//			return false;
//		
//		return true;
//	}
//	
//	
//}
//
//class NodeComparator implements Comparator<Node>
//{
//	@Override
//	public int compare(Node a, Node b)
//	{
//		if(a.priority == b.priority)
//			return 0;
//		else if (a.priority > b.priority)
//			return 1;
//		else
//			return -1;
//	}
//}

public class LeetCode {

	public long subArrayRanges(int[] nums) {
        long sum = 0;
        Vector<Integer> v = new Vector<>(nums.length);
        for(int i : nums)
        {
            v.add(i);
        }
        
        for(int i = 0; i <= v.size(); i++)
        {
            for(int j = 0; j < i; j++)
            {
                List<Integer> sv = v.subList(j, i);
                int max = Collections.max(sv);
                int min = Collections.min(sv);
                
                sum = sum + (max - min);
            }
        }
        
        return sum;
    }
	
	public static void main(String[] args) {
		
//		MaxStack stk = new MaxStack();
//		stk.push(5);   // [5] the top of the stack and the maximum number is 5.
//		stk.push(1);   // [5, 1] the top of the stack is 1, but the maximum is 5.
//		stk.push(5);   // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is the top most one.
//		System.out.println(stk.top());     // return 5, [5, 1, 5] the stack did not change.
//		System.out.println(stk.popMax());  // return 5, [5, 1] the stack is changed now, and the top is different from the max.
//		System.out.println(stk.top());     // return 1, [5, 1] the stack did not change.
//		System.out.println(stk.peekMax()); // return 5, [5, 1] the stack did not change.
//		System.out.println(stk.pop());     // return 1, [5] the top of the stack and the max element is now 5.
//		System.out.println(stk.top());     // return 5, [5] the stack did not change.
		
//		System.out.println(SellColoredBalls.maxProfit(new int[] {2,5,9}, 15));
		
//		ExpressionTree obj = new ExpressionTree();
//		BNode expTree = obj.buildTree(new String[] {"4","5","2","7","+","-","*"});
//		System.out.println(RobotInCircle.isRobotBounded2("GLGLGGLGL"));
		
//		for(int y : CourseScheduleII.findOrder(2, new int[][] {
//			new int[] {0, 1}
//			}))
//			System.out.println(y);
		
//		int[] p = AsteroidCollision.asteroidCollision(new int[] {1, -1, -2, -2});
//		for(int o : p)
//		{
//			System.out.println(o);
//		}
		
//		Vector<Integer> v = new Vector<>();
//		v.add(0, 1);
//		v.add(0, 2);
//		System.out.println(v);
		
//		Vector<Dummy> ts = new Vector<>();
//		ts.add(new Dummy("l", 3));
//		ts.add(new Dummy("o", 2));
//		ts.add(new Dummy("h", 1));
//		ts.add(new Dummy("e", 1));
//		ts.add(new Dummy("w", 1));
//		
//		Collections.sort(ts, (a, b)->{
//			return b.i - a.i;
//		});
//		
//		
//		
//		for(Dummy d : ts)
//		{
//			System.out.println(d.s + "\t" + d.i);
//		}
		
		Integer i = 90;
		LeetCode.sum(i);
		System.out.println(i);
		
		List<String> result = new LinkedList<String>();
		
	}
	
	static void sum(int a)
	{
		a = 100;
		return;
	}
}

class Dummy implements Comparable<Dummy>
{
	public String s;
	public int i;
	
	public Dummy(String s, int i)
	{
		this.s = s;
		this.i = i;
	}
	
	public int compareTo(Dummy d)
	{
		return Integer.compare(this.i, d.i);
	}
}