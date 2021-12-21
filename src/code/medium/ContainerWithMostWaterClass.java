package code.medium;

public class ContainerWithMostWaterClass {
	public static int ContainerWithMostWater(int[] height)
	{
		int i = 0, j = height.length -1;
		int maxCapacity = 0;
		
		while(i < j)
		{
			int width = j - 1;
			int minHeight = Integer.min(height[i], height[j]);
			maxCapacity = Integer.max(maxCapacity, (width * minHeight));
			
			if(height[i] < height[j])
			{
				i++;
			}
			else
			{
				j--;
			}
		}
		
		return maxCapacity;
	}
}
