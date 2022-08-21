package code.easy;

public class RomanToIntegerClass {
	public static int RomanToInt(String s)
	{
		int p = 0;
		int n = 0;
		while(p < s.length())
		{
			if(s.charAt(p) == 'I')
			{
				if(p+1 < s.length() && s.charAt(p+1) == 'V')
				{
					n += 4;
					p += 2;
				}
				else if(p+1 < s.length() && s.charAt(p+1) == 'X')
				{
					n += 9;
					p += 2;
				}
				else
				{
					n += 1;
					p += 1;
				}
				
			}
			else if(s.charAt(p) == 'X')
			{
				if(p+1 < s.length() && s.charAt(p+1) == 'L')
				{
					n += 40;
					p += 2;
				}
				else if(p+1 < s.length() && s.charAt(p+1) == 'C')
				{
					n += 90;
					p += 2;
				}
				else
				{
					n += 10;
					p += 1;
				}
			}
			else if(s.charAt(p) == 'C')
			{
				if(p+1 < s.length() && s.charAt(p+1) == 'D')
				{
					n += 400;
					p += 2;
				}
				else if(p+1 < s.length() && s.charAt(p+1) == 'M')
				{
					n += 900;
					p += 2;
				}
				else
				{
					n += 100;
					p += 1;
				}
			}
			else
			{
				if(s.charAt(p) == 'V')
				{
					n += 5;
				}
				else if(s.charAt(p) == 'L')
				{
					n += 50;
				}
				else if(s.charAt(p) == 'D')
				{
					n += 500;
				}
				else if(s.charAt(p) == 'M')
				{
					n += 1000;
				}

				p += 1;
			}
		}
		
		return n;
	}
}
