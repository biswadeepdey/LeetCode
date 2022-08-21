package code.easy;
import java.util.*;

public class KWeakestRows {
	public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->{
        	int com = Integer.compare(a[1], b[1]);
        	if(com != 0)
        		return com;
        	else
        		return Integer.compare(a[0], b[0]);
        }); 
        
        for(int row = 0; row < mat.length; row++)
        {
        	int count = 0;
        	for(int col = 0; col < mat[0].length; col++)
        	{
        		if(mat[row][col] == 1)
        		{
        			count++;
        		}
        		else
        		{
        			break;
        		}
        	}
        	
        	pq.add(new int[] {row, count});
        }
        
        int[] result = new int[k];
        
        int count = 0;
        while(!pq.isEmpty() && count < k)
        {
        	result[count++] = pq.poll()[0];
        }
        
        return result;
    }
	
	public static void main(String[] args)
	{
		KWeakestRows obj = new KWeakestRows();
		
		int[][] mat = new int[][] {
			new int[] {1,1,0,0,0},
			new int[] {1,1,1,1,0},
			new int[] {1,0,0,0,0},
			new int[] {1,1,0,0,0},
			new int[] {1,1,1,1,1}
		};
		
		int[] result =  obj.kWeakestRows(mat, 3);
		
		for(int j : result)
		{
			System.out.println(j);
		}
	}
}
