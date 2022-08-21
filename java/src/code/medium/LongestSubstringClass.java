package code.medium;
import java.util.*;

public class LongestSubstringClass {
	public static String LongestSubstring(String str)
	{
		if(str.length() == 0)
			return "";
		
		Set<Character> set = new HashSet<Character>();
		String lastStr = str.substring(0,1);
		set.add(str.charAt(0));
		int i = 0;
		for(int j = 1; j < str.length(); j++)
		{
			if(set.contains(str.charAt(j)))
			{
				while(str.charAt(i) != str.charAt(j))
				{
					set.remove(str.charAt(i));
					i++;
				}
				
				set.remove(str.charAt(i));
				i+=1;
				set.add(str.charAt(j));
				
				if(str.substring(i, j+1).length() > lastStr.length())
				{
					lastStr = str.substring(i, j+1);
				}
			}
			else
			{
				set.add(str.charAt(j));
				
				if(str.substring(i, j+1).length() > lastStr.length())
				{
					lastStr = str.substring(i, j+1);
				}
			}
		}
		
		return lastStr;
	}
	
	public static int LongestSubstring2(String str)
	{
		if(str.length() == 0)
		{
			return 0;
		}
		
		int i = 0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int maxLen = 0;
		
		for(int j = 0; j < str.length(); j++)
		{
			char c = str.charAt(j);
			
			if(map.get(c) != null && map.get(c) >= i)
			{
				int pos = map.get(c);
				i = pos + 1;
				map.put(c, j);
				
				if((j-i)+1 > maxLen)
				{
					maxLen = (j-i)+1; 
				}
			}
			else
			{
				map.put(c, j);
				
				if((j-i)+1 > maxLen)
				{
					maxLen = (j-i)+1; 
				}
			}
		}
		
		return maxLen;
	}
	
	
}
