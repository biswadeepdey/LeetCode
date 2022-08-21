package code.hard;
import java.util.*;

public class IntegerToEnglish {
	private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
	private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
	
	private String HunTenOne(int n)
	{
		int nums = n;
		int ones = nums % 10;
		nums = nums / 10;
		
		int tens = nums % 10;
		nums = nums / 10;
		
		int hun = nums % 10;
		
		StringBuilder sb = new StringBuilder();
		if((tens * 10 + ones) < 20)
		{
			sb.insert(0, LESS_THAN_20[tens * 10 + ones]);
		}
		else
		{
			if(ones == 0 && tens > 0)
			{
				sb.insert(0, TENS[tens]);
			}
			else if(ones > 0 && tens > 0)
			{
				sb.insert(0, TENS[tens] + " " +  LESS_THAN_20[ones]);
			}
		}
		
		if(hun != 0)
		{
            String s = (sb.length() > 0) ? LESS_THAN_20[hun] + " Hundred " : LESS_THAN_20[hun] + " Hundred";
			sb.insert(0, s);
		}
		
		return sb.toString();
	}
    
    
    public String numberToWords(int num) {
        if(num == 0)
			return "Zero";
		
		int remainder = num;
		int loopCount = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while(remainder > 0)
		{
			int n = remainder % 1000;
			String s = " " + HunTenOne(n);
			if(loopCount == 1 && s.length() > 0)
			{
				if(s.trim().length() > 0)
				{
					s += " Thousand";
				}
			}
			else if(loopCount == 2 && s.length() > 0)
			{
				if(s.trim().length() > 0)
				{
					s += " Million";
				}
			}
			else if(loopCount == 3 && s.length() > 0)
			{
				if(s.trim().length() > 0)
				{
					s += " Billion";
				}
			}
			
			if(s.trim().length() > 0)
			{
				sb.insert(0, s);
			}
			
			remainder = remainder / 1000;
			loopCount++;
		}
		
        return sb.toString().trim();
    }
}
