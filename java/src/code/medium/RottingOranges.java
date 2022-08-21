package code.medium;

import java.util.*;

public class RottingOranges {
	public static int orangesRotting(int[][] grid) {
        int count = 0;
        
        int freshOranges = 0;
        Queue<int[]> q = new LinkedList<int[]>();
        
        for(int i = 0; i < grid.length; i++)
        {
        	for(int j = 0; j < grid[0].length; j++)
        	{
        		if(grid[i][j] == 1)
        		{
        			freshOranges++;
        		}
        		if(grid[i][j] == 2)
        		{
        			q.offer(new int[] {i, j});
        		}
        	}
        }
        
        while(!q.isEmpty() && freshOranges != 0)
        {
        	boolean madeChange = false;
        	Queue<int[]> qTemp = new LinkedList<int[]>();
        	while(!q.isEmpty())
        	{
        		int[] cell = q.poll();
        		if(cell[0] + 1 < grid.length)
        		{
        			if(grid[cell[0] + 1][cell[1]] == 1)
        			{
        				grid[cell[0] + 1][cell[1]] = 2;
        				freshOranges--;
        				qTemp.add(new int[] {cell[0] + 1, cell[1]});
        				madeChange = true;
        			}
        		}
        		if(cell[0] - 1 >= 0)
        		{
        			if(grid[cell[0] - 1][cell[1]] == 1)
        			{
        				grid[cell[0] - 1][cell[1]] = 2;
        				freshOranges--;
        				qTemp.add(new int[] {cell[0] - 1, cell[1]});
        				madeChange = true;
        			}
        		}
        		if(cell[1] + 1 < grid[0].length)
        		{
        			if(grid[cell[0]][cell[1] + 1] == 1)
        			{
        				grid[cell[0]][cell[1] + 1] = 2;
        				freshOranges--;
        				qTemp.add(new int[] {cell[0], cell[1] + 1});
        				madeChange = true;
        			}
        		}
        		if(cell[1] - 1 >= 0)
        		{
        			if(grid[cell[0]][cell[1] - 1] == 1)
        			{
        				grid[cell[0]][cell[1] - 1] = 2;
        				freshOranges--;
        				qTemp.add(new int[] {cell[0], cell[1] - 1});
        				madeChange = true;
        			}
        		}
        	}
        	if(madeChange)
        	{
        		count++;
        	}
        	else
        	{
        		break;
        	}
        	q = qTemp;
        }
        
        if(freshOranges == 0)
        	return count;
        else
        	return -1;
    }
}
