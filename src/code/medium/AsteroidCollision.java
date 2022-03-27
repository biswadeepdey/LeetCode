package code.medium;

import java.util.*;

public class AsteroidCollision {
	public static int[] asteroidCollision(int[] asteroids) {
        // Initialize a Stack
		Stack<Integer> stack = new Stack<Integer>();
        stack.push(asteroids[0]);
        
        // For each entry from index 1 till end
		for(int i = 1; i < asteroids.length; i++ )
		{
			// destroy asteroids till asteroids[i] is bigger
			while(!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0)
			{
				int curr = asteroids[i];
				if(Math.abs(curr) > stack.peek())
				{
					stack.pop();
					if(stack.isEmpty())
					{
						break;
					}
				}
				else
				{
					break;
				}
			}
			
			if(stack.isEmpty())
			{
				stack.push(asteroids[i]);
				continue;
			}
			
			if((stack.peek() > 0 && asteroids[i] < 0) && stack.peek() == Math.abs(asteroids[i]))
			{
				stack.pop();
			}
			else if((stack.peek() < 0 && asteroids[i] < 0) || (stack.peek() > 0 && asteroids[i] > 0)
					|| (stack.peek() < 0 && asteroids[i] > 0))
			{
				stack.push(asteroids[i]);
			}
		}
		
		int[] result = new int[stack.size()];
		int count = 0;
		while(!stack.isEmpty())
		{
			result[count++] = stack.pop();
		}
		
		return result;
    }
}
