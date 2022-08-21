package code.easy;
import java.util.*;

public class ClimbingStairsClass {
	static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>(); 
	static int fibonacci(int n)
	{
		if(memo.containsKey(n))
		{
			return memo.get(n);
		}
		else if(n == 0)
		{
			memo.put(n, 1);
			return 1;
		}
		else if(n == 1)
		{
			memo.put(n, 2);
			return 2;
		}
		else
		{
			int output = fibonacci(n - 1) + fibonacci(n - 2);
			memo.put(n, output);
			return output;
		}
	}
	public static int ClimbingStairs(int n)
	{
		return fibonacci(n - 1);
	}
}
