package code.easy;

public class SqrtOfXClass {
	public static int SqrtOfX(int x)
	{
		if(x == 1)
			return 1;
		
		if(x == 0)
			return 0;
		
		int lower = 0;
		int higher = x;
		int ans = 0;
		int mid= 0, lastMid = -1;
		
		while(lower != higher || lastMid != mid)
		{

			if(lastMid == mid)
				return mid;

			lastMid = mid;
			
			mid = (lower + higher) / 2;
			
			System.out.println("" + lower + "\t" + higher + "\t" + mid + "\t" + mid*mid);
			
			
			if(mid * mid == x)
			{
				return mid;
			}
			else if(mid > x / mid)
			{
				higher = mid;
				ans = mid;
			}
			else
			{
				lower = mid;
				ans = mid;
			}
			
		}
		
		return ans;
	}
}
