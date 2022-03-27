package code.medium;

import java.util.*;

public class SellColoredBalls {
	public static int maxProfit(int[] inventory, int orders) 
	{
		int count = 1;
		Arrays.sort(inventory);
		
		int sum = 0;
		int modDiv = (int)Math.pow(10, 9) + 7;
		
		if(inventory.length == 1)
		{
			int init = inventory[0];
			while(orders-- > 0)
			{
				sum = (sum + init) % modDiv;
				init--;
			}
			
			return sum;
		}
		
		for(int i = inventory.length - 1; i > 0; i--)
		{
			int diff = 0;
			if(inventory[i - 1] != inventory[i])
			{
				diff = inventory[i] - inventory[i - 1]; 
			}
			else
			{
				while(i > 0 && inventory[i - 1] == inventory[i])
				{
					i--;
					count++;
				}
				
				diff = i == 0 ? inventory[i] : inventory[i] - inventory[i - 1];
			}
			
			
			int j = inventory[i];
			while(diff-- > 0 && orders > 0)
			{
				int toReduce = orders - count <= 0 ? orders : count;
				sum = (sum + (j * toReduce)) % modDiv;
				j--;
				orders -= count;
			}
			
			count++;
		}
		
		return sum;
	}
}
