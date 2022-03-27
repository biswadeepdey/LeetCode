package code.hard;

import java.util.*;

public class TrappingRainWater {
	public int trap(int[] height) {
        int[] maxFromRight = new int[height.length];
        int[] maxFromLeft = new int[height.length];
        
        Arrays.fill(maxFromRight, -1);
        Arrays.fill(maxFromLeft, -1);
        
        int maxLeft = 0;
        int maxRight = height.length - 1;
        for(int i = 0; i < height.length; i++)
        {
            int j = height.length - i - 1;
            
            if(i == 0 || height[i] > height[maxLeft])
            {
                maxLeft = i;
            }
            else if(height[i] != height[maxLeft])
            {
                maxFromLeft[i] = maxLeft;
            }
            
            if(j == height.length - 1 || height[j] > height[maxRight])
            {
                maxRight = j;
            }
            else if(height[j] != height[maxRight])
            {
                maxFromRight[j] = maxRight;
            }
        }
        
        int count = 0;
        for(int i = 0; i < height.length; i++)
        {
        	if(maxFromLeft[i] != -1 && maxFromRight[i] != -1)
        	{
        		count += Integer.min(height[maxFromLeft[i]], height[maxFromRight[i]]) - height[i];
        	}
        }
        
        return count;
    }
	
	
	public static void main(String[] args)
	{
		TrappingRainWater obj = new TrappingRainWater();
		System.out.println(obj.trap(new int[] {0,1,0,2,1,0,1,3,2,1,2,1}));
	}
}
