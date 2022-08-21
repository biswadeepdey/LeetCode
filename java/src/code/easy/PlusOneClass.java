package code.easy;

public class PlusOneClass {
	public static int[] PlusOne(int[] digits)
	{
		int carry = 0;
		int sum = 0;
		
		for(int i = digits.length - 1; i >= 0; i--)
		{
			sum = i == digits.length - 1 ? digits[i] + 1 : digits[i] + carry;
			
			if(sum == 10)
			{
				digits[i] = 0;
				carry = 1;
			}
			else
			{
				digits[i] = sum;
				carry = 0;
			}
		}
		
		if(carry == 0)
		{
			return digits;
		}
		else
		{
			int[] newArr = new int[digits.length + 1];
			newArr[0] = carry;
			for(int i=1; i < newArr.length; i++)
			{
				newArr[i] = digits[i-1];
			}
			
			return newArr;
		}
	}
}
