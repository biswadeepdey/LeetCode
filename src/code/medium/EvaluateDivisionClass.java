package code.medium;
import java.util.*;

public class EvaluateDivisionClass {
	
	public static String key(String a, String b)
	{
		return a + "-" + b;
	}
	
	public static Double dfs(String src, String dest, Map<String, String> oneToOne, Map<String, Double> valueMap, 
			Double d)
	{
		if(oneToOne.get(src) != null)
		{			
			if(oneToOne.get(src).equals(dest))
			{
				if(d == null)
				{
					return valueMap.get(key(src, dest));
				}
				else
				{
					return d * valueMap.get(key(src, dest));
				}
			}
			else
			{
				return dfs(oneToOne.get(src), dest, oneToOne, valueMap, 
						valueMap.get(key(src, oneToOne.get(src))));
			}
		}
		else
		{
			return null;
		}
	}
	
	public static double[] calcEquation(List<List<String>> equations, double[] values, 
			List<List<String>> queries)
	{
		Map<String, Double> valueMap = new HashMap<String, Double>();
		for(int i = 0; i < equations.size(); i++)
		{
			List<String> e = equations.get(i);
			valueMap.put(key(e.get(0), e.get(1)), values[i]);
			valueMap.put(key(e.get(1), e.get(0)), 1 / values[i]);
			valueMap.put(key(e.get(0), e.get(0)), 1.0);
			valueMap.put(key(e.get(1), e.get(1)), 1.0);
		}
		
		Map<String, String> oneToOne = new HashMap<String, String>();
		for(List<String> l : equations)
		{
			oneToOne.put(l.get(0), l.get(1));
		}
		
		double[] result = new double[queries.size()];
		
		for(int i = 0; i < queries.size(); i++)
		{
			List<String> q = queries.get(i);
			
			if(valueMap.get(key(q.get(0), q.get(1))) != null)
			{
				result[i] = valueMap.get(key(q.get(0), q.get(1)));
			}
			else
			{
				Double d = dfs(q.get(0), q.get(1), oneToOne, valueMap, null);
				if(d == null)
				{
					result[i] = -1;
				}
				else
				{
					result[i] = d;
				}
			}
		}
		
		return result;
	}
}
