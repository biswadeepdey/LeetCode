package code.medium;

import java.util.*;

public class ShortestPathToFood {
	
	private int bfs(char[][] grid, int sr, int sc)
	{
		int iteration = 0;
		int maxRow = grid.length, maxCol = grid[0].length;
		boolean foundFood = false;
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sr, sc, 0});
		while(!q.isEmpty())
		{
			int qLength = q.size();
			for(int k = 0; k < qLength; k++)
			{
				int[] data = q.poll();
				int x = data[0];
				int y = data[1];
				
				// if already visited
				if(grid[x][y] == 'v')
				{
					continue;
				}
				
				grid[x][y] = 'v';
				
				if(grid[x][y] == '#')
				{
					foundFood = true;
					break;
				}
				else
				{
					if(x - 1 >= 0 && (grid[x - 1][y] != 'X' && grid[x - 1][y] != 'v'))
					{
						if(grid[x - 1][y] == '#')
						{
							foundFood = true;
							break;
						}
						q.add(new int[] {x - 1, y});
					}
					if(y + 1 < maxCol && (grid[x][y + 1] != 'X' && grid[x][y + 1] != 'v'))
					{
						if(grid[x][y + 1] == '#')
						{
							foundFood = true;
							break;
						}
						q.add(new int[] {x, y + 1});
					}
					if(x + 1 < maxRow && (grid[x + 1][y] != 'X' && grid[x + 1][y] != 'v'))
					{
						if(grid[x + 1][y] == '#')
						{
							foundFood = true;
							break;
						}
						q.add(new int[] {x + 1, y});
					}
					if(y - 1 >= 0 && (grid[x][y - 1] != 'X' && grid[x][y - 1] != 'v'))
					{
						if(grid[x][y - 1] == '#')
						{
							foundFood = true;
							break;
						}
						q.add(new int[] {x, y - 1});
					}
				}
			}
			if(foundFood)
			{
				break;
			}
			
			iteration++;
		}
		
		return foundFood ? iteration + 1 : -1;
	}
	
	public int getFood(char[][] grid)
	{
		int maxRow = grid.length, maxCol = grid[0].length;
		if(maxRow == 0 || maxCol == 0)
		{
			return -1;
		}
		
		// find * location
		int sr = -1, sc = -1;
		for(int i = 0; i < maxRow; i++)
		{
			for(int j = 0; j < maxCol; j++)
			{
				if(grid[i][j] == '*')
				{
					sr = i;
					sc = j;
					break;
				}
			}
		}
		
		// no *
		if(sr == -1 || sc == -1)
		{
			return -1;
		}
		
		return bfs(grid, sr, sc);
	}
	
	public static void main(String[] args)
	{
		ShortestPathToFood obj = new ShortestPathToFood();
		char[][] grid = new char[][] {
			new char[] {'X','X','X','X','X','X'},
			new char[] {'X','*','O','O','O','X'},
			new char[] {'X','O','O','#','O','X'},
			new char[] {'X','X','X','X','X','X'}
//			new char[] {'*'}
		};
		
		System.out.println(obj.getFood(grid));
	}
}
