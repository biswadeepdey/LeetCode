package code.exercise;
import java.util.*;


public class CountIslandClass {
	String key(int i, int j)
	{
		return i +"-" +j;
	}
	
	Vector<int[]> allValidNodes(int i, int j, int[][] matrix)
	{
		Vector<int[]> nodeHelper = new Vector<int[]>();
		nodeHelper.add(new int[] {-1, 0});
		nodeHelper.add(new int[] {-1, 1});
		nodeHelper.add(new int[] {0, 1});
		nodeHelper.add(new int[] {1, 1});
		nodeHelper.add(new int[] {1, 0});
		nodeHelper.add(new int[] {1, -1});
		nodeHelper.add(new int[] {0, -1});
		nodeHelper.add(new int[] {-1, -1});
		
		Vector<int[]> result = new Vector<int[]>();
		
		for(int[] node : nodeHelper)
		{
			int row = i + node[0];
			int col = j + node[1];
			
			if((row>=0 && row < matrix.length) && (col >=0 && col < matrix[0].length) && matrix[row][col] == 1)
			{
				result.add(new int[] {row, col});
			}
		}
		
		return result;
	}
	
	Set<String> dfs(int i, int j, int[][] matrix, Set<String> visited, Set<String> currentSet)
	{
		String currKey = key(i, j);
		if(matrix[i][j] == 1 && !visited.contains(currKey))
		{
			visited.add(currKey);
			currentSet.add(currKey);
			Vector<int[]> validNodes = allValidNodes(i, j, matrix);
			for(int[] node : validNodes)
			{
				dfs(node[0], node[1], matrix, visited, currentSet);
			}
		}
		
		return currentSet;
	}
	
	public int countIsland(int[][] matrix)
	{
		int iCount = 0;
		Set<String> visited = new HashSet<String>();
		for(int i = 0; i < matrix.length; i++)
		{
			for(int j = 0; j < matrix[0].length; j++)
			{
				Set<String> s = dfs(i, j, matrix, visited, new HashSet<String>());
				if(s.size() > 0)
				{
					iCount++;
				}
			}
		}
		
		return iCount;
	}
}
