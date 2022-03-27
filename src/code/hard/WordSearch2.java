package code.hard;

import java.util.*;

public class WordSearch2 {
	static int currIndex = 0;
	public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new LinkedList<>();
        for(String word : words)
        {
        	List<int[]> startPoints = new LinkedList<>();
        	for(int i = 0; i < board.length; i++)
        	{
        		for(int j = 0; j < board[0].length; j++)
        		{
        			if(board[i][j] == word.charAt(0))
        			{
        				startPoints.add(new int[] {i, j});
        			}
        		}
        	}
        	
        	
        	for(int o = 0; o < startPoints.size(); o++)
        	{
        		StringBuilder sb = new StringBuilder();
        		int[] point = startPoints.get(o);
        		if(dfs(board, new boolean[board.length][board[0].length],point[0], point[1], word, sb))
        		{
        			result.add(word);
        			break;
        		}
        	}
        }
        
        return result;
    }
	
	boolean dfs(char[][] board, boolean[][] visited, int i, int j, String word, StringBuilder lastWord)
	{
		lastWord.append(board[i][j]);
		visited[i][j] = true;
		if(lastWord.toString().equals(word)) {
			return true;
		}
		else if(lastWord.length() == word.length())
		{
			return false;
		}
		
		boolean wordFound = false;
		if(!wordFound && i - 1 >= 0 && currIndex + 1 < word.length() && !visited[i - 1][j] && board[i - 1][j] == word.charAt(currIndex + 1))
		{
			currIndex += 1;
			wordFound = dfs(board, visited, i - 1, j, word, lastWord);
			currIndex -= 1;
		}
		if(!wordFound && j + 1 < board[0].length && currIndex + 1 < word.length() && !visited[i][j + 1] && board[i][j + 1] == word.charAt(currIndex + 1))
		{
			currIndex += 1;
			wordFound = dfs(board, visited, i, j + 1, word, lastWord);
			currIndex -= 1;
		}
		if(!wordFound && i + 1 < board.length && currIndex + 1 < word.length() && !visited[i + 1][j] && board[i + 1][j] == word.charAt(currIndex + 1))
		{
			currIndex += 1;
			wordFound = dfs(board, visited, i + 1, j, word, lastWord);
			currIndex -= 1;
		}
		if(!wordFound && j - 1 >= 0 && currIndex + 1 < word.length() && !visited[i][j - 1] && board[i][j - 1] == word.charAt(currIndex + 1))
		{
			currIndex += 1;
			wordFound = dfs(board, visited, i, j - 1, word, lastWord);
			currIndex -= 1;
		}
		
		visited[i][j] = false;
		lastWord.deleteCharAt(lastWord.length() - 1);
		return wordFound;
	}
	
	
	public static void main(String[] args)
	{
		WordSearch2 obj = new WordSearch2();
		System.out.println(obj.findWords(new char[][] {
			new char[] {'b','b','b','a','b','a'},
			new char[] {'b','b','a','b','a','a'},
			new char[] {'b','b','b','b','b','b'},
			new char[] {'a','a','a','b','a','a'},
			new char[] {'a','b','a','a','b','b'}
		}, new String[] {"abbbababaa"}));
	}
}
