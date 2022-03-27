package code.medium;

import java.util.*;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
        int colLo = 0, colHi = matrix[0].length - 1;
        int rowLo = 0, rowHi = matrix.length - 1;
        
        List<Integer> output = new LinkedList<>();
        int n = matrix.length * matrix[0].length;
        
        int direction = 0; // 0R 1D 2L 3U 
        while(output.size() < n)
        {
            if(direction == 0)
            {
                for(int i = colLo; i <= colHi; i++)
                {
                    output.add(matrix[rowLo][i]);
                }
                if(output.size() == n) break;
                rowLo++;
                direction = 1;
            }
            if(direction == 1)
            {
                for(int i = rowLo; i <= rowHi; i++)
                {
                    output.add(matrix[i][colHi]);
                }
                if(output.size() == n) break;
                colHi--;
                direction = 2;
            }
            if(direction == 2)
            {
                for(int i = colHi; i >= colLo; i--)
                {
                    output.add(matrix[rowHi][i]);
                }
                if(output.size() == n) break;
                rowHi--;
                direction = 3;
            }
            if(direction == 3)
            {
                for(int i = rowHi; i >= rowLo; i--)
                {
                    output.add(matrix[i][colLo]);
                }
                if(output.size() == n) break;
                colLo++;
                direction = 0;
            }
        }
        
        return output;
    }
	
	public static void main(String[] args)
	{
		SpiralMatrix obj = new SpiralMatrix();
		int[][] matrix = new int[][] {
			new int[] {1,2,3},
			new int[] {4,5,6},
			new int[] {7,8,9}
		};
	
		System.out.println(obj.spiralOrder(matrix));
	}
}
