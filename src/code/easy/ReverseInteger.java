package code.easy;

public class ReverseInteger {
	public static int Reverse(int x)
	{
		int INT_MAX = (int)(Math.pow(2, 31) - 1);
		int INT_MIN = -1 * (int)(Math.pow(2, 31) - 1) - 1;
		boolean isNegative = false;
		if(x < 0)
		{
			isNegative = true;
		}
		
		int t = 0;
		
		try
		{
			while(x != 0)
			{
				int lastDigit = Math.abs(x % 10);
				
				// Check for integer range
				String sCheck = "" + t + "0";
				try {
					Integer.parseInt(sCheck);
				}
				catch(Exception e)
				{
					return 0;
				}
				
				t = t * 10 + lastDigit;
				x = x / 10;
			}
		}
		catch(Exception e)
		{
			return 0;
		}
		
		return isNegative ? -1 * t : t;
	}
	
	public static int ReverseUsingString(int x)
	{
		boolean negative = false;
		if(x < 0)
		{
			negative = true;
		}
		String s = "" + x;
		s = negative ? s.substring(1) : s;
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.reverse();
		s = sb.toString();
		try
		{
			return negative ? -1 * Integer.parseInt(s) : Integer.parseInt(s);
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}
}
