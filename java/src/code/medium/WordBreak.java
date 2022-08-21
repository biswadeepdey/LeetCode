package code.medium;
import java.util.*;

public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict)
	{
		boolean[] memo = new boolean[s.length() + 1];
		Arrays.fill(memo, false);
		memo[0] = true;
		
		for(int i = 1; i <= s.length(); i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(memo[j] && wordDict.contains(s.substring(j, i)))
				{
					memo[i] = true;
					break;
				}
			}
		}
		
		return memo[s.length()];
	}
}
