package code.easy;

public class LongestCommonPrefixClass {
	public static String LongestCommonPrefix(String[] strs)
	{
		String prefix = "";
		int p = 0;
		
		while(true)
		{
			char ch;
			if(p < strs[0].length())
			{
				ch = strs[0].charAt(p);
				
				for(int i = 1; i < strs.length; i++)
				{
					if(p >= strs[i].length() || strs[i].charAt(p) != ch)
					{
						return prefix;
					}
				}
				
				prefix += ch;
				p += 1;
			}
			else
			{
				break;
			}
		}
		
		return prefix;
	}
	
	public static String LongestCommonPrefixRefs(String[] strs)
	{
		int itr = 1;
		String refs = strs[0];
		
		while(refs.length() >0 && itr < strs.length)
		{
			int p = 0;
			String tempRefs = "";
			
			while(true)
			{
				if(p < strs[itr].length() && p < refs.length() && refs.charAt(p) == strs[itr].charAt(p))
				{
					tempRefs += refs.charAt(p);
				}
				else
				{
					if(p == 0 )
					{
						return "";
					}
					refs = tempRefs;
					break;
				}
				p++;
			}
			itr++;
		}
		
		return refs;
	}
}
