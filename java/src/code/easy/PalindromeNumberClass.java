package code.easy;

public class PalindromeNumberClass {
	public static boolean PalindromeNumber(int x)
	{
		if(x < 0 )
		{
			return false;
		}
		if(x < 10)
		{
			return true;
		}
		
		return x == ReverseInteger.Reverse(x);
	}
}
