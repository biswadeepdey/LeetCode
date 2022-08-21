package code.medium;
import java.util.*;
public class CountNumberOfTeams {
	void fromRight(int[] rating, int[] biggerOnRight, int[] smallerOnRight)
	{
		Stack<Integer> bigger = new Stack<>();
		Stack<Integer> smaller = new Stack<>();
		
		for(int i = rating.length - 1; i >= 0; i--)
		{
			while(!bigger.isEmpty() && rating[i] > rating[bigger.peek()])
			{
				bigger.pop();
			}
			
			if(bigger.isEmpty())
			{
				biggerOnRight[i] = -1;
			}
			else
			{
				biggerOnRight[i] = bigger.peek();
			}
			bigger.push(i);
			
			while(!smaller.isEmpty() && rating[i] < rating[smaller.peek()])
			{
				smaller.pop();
			}
			
			if(smaller.isEmpty())
			{
				smallerOnRight[i] = -1;
			}
			else
			{
				smallerOnRight[i] = smaller.peek();
			}
			smaller.push(i);
		}
	}
	
	void fromLeft(int[] rating, int[] biggerOnLeft, int[] smallerOnLeft)
	{
		Stack<Integer> bigger = new Stack<>();
		Stack<Integer> smaller = new Stack<>();
		
		for(int i = 0; i < rating.length; i++)
		{
			while(!bigger.isEmpty() && rating[i] > rating[bigger.peek()])
			{
				bigger.pop();
			}
			
			if(bigger.isEmpty())
			{
				biggerOnLeft[i] = -1;
			}
			else
			{
				biggerOnLeft[i] = bigger.peek();
			}
			bigger.push(i);
			
			while(!smaller.isEmpty() && rating[i] < rating[smaller.peek()])
			{
				smaller.pop();
			}
			
			if(smaller.isEmpty())
			{
				smallerOnLeft[i] = -1;
			}
			else
			{
				smallerOnLeft[i] = smaller.peek();
			}
			smaller.push(i);
		}
	}
	
	public int numTeams(int[] rating) {
        int[] biggerOnRight = new int[rating.length];
        int[] smallerOnRight = new int[rating.length];
        int[] biggerOnLeft = new int[rating.length];
        int[] smallerOnLeft = new int[rating.length];
        
        fromRight(rating, biggerOnRight, smallerOnRight);
        fromLeft(rating, biggerOnLeft, smallerOnLeft);
        
        Set<String> result = new HashSet<>();
        
        for(int i = 0; i < rating.length; i++)
        {
        	if(biggerOnRight[i] != -1 && biggerOnRight[biggerOnRight[i]] != -1)
        	{
        		String key = rating[i] + "-" + rating[biggerOnRight[i]] + "-" + rating[biggerOnRight[biggerOnRight[i]]];
        		result.add(key);
         	}
        	if(smallerOnRight[i] != -1 && smallerOnRight[smallerOnRight[i]] != -1)
        	{
        		String key = rating[i] + "-" + rating[smallerOnRight[i]] + "-" + rating[smallerOnRight[smallerOnRight[i]]];
        		result.add(key);
        	}
        	if(biggerOnLeft[i] != -1 && biggerOnLeft[biggerOnLeft[i]] != -1)
        	{
        		String key = rating[biggerOnLeft[biggerOnLeft[i]]] + "-" + rating[biggerOnLeft[i]] + "-" + rating[i];
        		result.add(key);
        	}
        	if(smallerOnLeft[i] != -1 && smallerOnLeft[smallerOnLeft[i]] != -1)
        	{
        		String key = rating[smallerOnLeft[smallerOnLeft[i]]] + "-" + rating[smallerOnLeft[i]] + "-" + rating[i];
        		result.add(key);
        	}
        }
        System.out.println(result);
        return result.size();
    }
	
	public static void main(String[] args)
	{
		CountNumberOfTeams obj = new CountNumberOfTeams();
		System.out.println(obj.numTeams(new int[] {1,2,3,4}));
	}
}
