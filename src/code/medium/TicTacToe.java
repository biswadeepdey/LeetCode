package code.medium;

public class TicTacToe {
	int[][] grid;
	boolean complete;
	public TicTacToe(int n) {
		grid = new int[n][n];
		complete = false;
    }
    
    public int move(int row, int col, int player) {
    	if(complete)
    		return 0;
        // check for row and col
    	boolean failedRow = false, failedCol = false, failedDiag1 = false, failedDiag2 = false;
    	grid[row][col] = player;
    	for(int i = 0; i < grid.length; i++)
    	{
    		if(grid[row][i] != player)
    			failedRow = true;
    		
    		if(grid[i][col] != player)
    			failedCol = true;
    		
    		if(grid[i][i] != player)
    			failedDiag1 = true;
    		
    		if(grid[i][grid.length - i - 1] != player)
    			failedDiag2 = true;	
    	}
    	
    	if(!failedRow || !failedCol || !failedDiag1 || !failedDiag2)
    		return player;
    	
    	return 0;
    }
}
