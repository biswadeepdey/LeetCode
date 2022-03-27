package code.medium;
import java.util.*;

public class NumberOfIslands {
	List<List<Integer>> getNeighbors(int i, int j, char[][] arr)
    {
        List<List<Integer>> neighbours = new ArrayList<>();
        int[][] locations = new int[][] {
            new int[]{-1, 0},
            new int[]{0, 1},
            new int[]{1, 0},
            new int[]{0, -1}
        };
        
        for(int[] loca : locations)
        {
            if(
                (i + loca[0] >= 0 && i + loca[0] < arr.length) &&
                (j + loca[1] >= 0 && j + loca[1] < arr[0].length) &&
                arr[i + loca[0]][j + loca[1]] == '1'
            )
            {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(i + loca[0]);
                al.add(j + loca[1]);
                neighbours.add(al);
            }
        }
        
        return neighbours;
    }
    
    void dfs(int i, int j, char[][] arr, boolean[][] visited)
    {
        visited[i][j] = true;
        var neigh = getNeighbors(i, j, arr);
        for(List<Integer> li : neigh)
        {
            if(!visited[li.get(0)][li.get(1)])
            {
                dfs(li.get(0), li.get(1), arr, visited);
            }
        }
        
    }
    
    public int numIslands(char[][] grid) {
        int iLand  = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == '1' && !visited[i][j])
                {
                    iLand++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        
        return iLand;
    }
}
