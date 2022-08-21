package code.easy;

import java.util.*;

public class AddBinaryClass {
	
	static HashMap<String, int[]> binMap = new HashMap<String, int[]>(){
		{ 
			put("000", new int[] {0,0});
			put("001", new int[] {0,1});
			put("010", new int[] {0,1});
			put("100", new int[] {0,1});
			put("011", new int[] {1,0});
			put("101", new int[] {1,0});
			put("110", new int[] {1,0});
			put("111", new int[] {1,1});
		}
	};
	
	public static String AddBinary(String a, String b) 
	{
		String longStr, shortStr;
		int longLen, shortLen;
		if(a.length() > b.length())
		{
			longStr = a;
			longLen = a.length();
			shortStr = b;
			shortLen = b.length();
		}
		else
		{
			longStr = b;
			longLen = b.length();
			shortStr = a;
			shortLen = a.length();
		}
		
		int carry = 0;
		String outputString = "";
		while(true)
		{
			if(longLen < 0)
				break;
			if(carry == 0 && shortLen < 0)
			{
				outputString = "" + longStr.charAt(longLen) + outputString;
			}
			else
			{
				int[] sum;
				if(shortLen > 0)
				{
					sum = binMap.get("" + longStr.charAt(--longLen) + shortStr.charAt(--shortLen) + carry);
				}
				else if(longLen > 0)
				{
					sum = binMap.get("0" + longStr.charAt(--longLen) + carry);
				}
				else
				{
					break;
				}
				
				if(sum[0] == 1)
				{
					carry = 1;
				}
				else
				{
					carry = 0;
				}
				
				outputString = "" + sum[1] + outputString;
			}
		}
		
		return carry == 1 ? "" + carry + outputString : outputString;
	}
	
	public static String AddBinary2(String a, String b) 
	{
		if(a.length() < b.length())
		{
			return AddBinary2(b, a);
		}
		
		int limit = a.length() - 1;
		int smallLimit = b.length() - 1;
		int carry = 0;
		StringBuilder output = new StringBuilder();
		for(int i = limit; i > -1; i--)
		{
			if(a.charAt(i) == '1')
			{
				carry++;
			}
			
			if(smallLimit > -1 && b.charAt(smallLimit--) == '1')
			{
				carry++;
			}
			
			output.append(carry % 2);
			
			carry /= 2;
		}
		
		if(carry == 1)
		{
			output.append(1);
		}
		
		return output.reverse().toString();
	}
}
