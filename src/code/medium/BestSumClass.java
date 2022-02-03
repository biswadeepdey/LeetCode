package code.medium;
import java.util.*;

public class BestSumClass {
	public static Vector<Integer> bestSum(int target, Vector<Integer> numbers)
	{
		if(target == 0)
			return new Vector<Integer>();
		if(target < 0)
			return null;
		
		Vector<Integer> minimumVector = null;
		for(Integer i : numbers)
		{
			Vector<Integer> retV = bestSum(target - i, numbers);
			if(retV != null)
			{
				retV.add(i);
				if(minimumVector == null)
				{
					minimumVector = retV;
				}
				else if(minimumVector.size() > retV.size())
				{
					minimumVector = retV;
				}
			}
		}
		
		return minimumVector;
	}
	
	public static Vector<Integer> bestSumDp(int target, Vector<Integer> numbers, 
			Map<Integer, Vector<Integer>> memo)
	{
		if(memo.get(target) != null)
		{
			return memo.get(target);
		}
		if(target == 0)
			return new Vector<Integer>();
		if(target < 0)
			return null;
		
		Vector<Integer> minimumVector = null;
		for(Integer i : numbers)
		{
			Vector<Integer> retV = bestSumDp(target - i, numbers, memo);
			if(retV != null)
			{
				Vector<Integer> v = new Vector<Integer>();
				v.addAll(retV);
				v.add(i);
				if(minimumVector == null || minimumVector.size() > v.size())
				{
					minimumVector = new Vector<Integer>();
					minimumVector.addAll(v);
				}
			}
		}
		
		memo.put(target, minimumVector);
		return minimumVector;
	}
}
