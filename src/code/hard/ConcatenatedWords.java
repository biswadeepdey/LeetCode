package code.hard;
import java.util.*;
public class ConcatenatedWords {
	public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        List<String> resultList = new ArrayList<>();
        
        Set<String> preWords = new HashSet<String>();
        
        for(String word : words)
        {
            if(canFormWord(word, preWords))
            {
            	resultList.add(word);
            }
            
            preWords.add(word);
        }
        
        return resultList;
    }
	
	static boolean canFormWord(String word, Set<String> set)
	{
		if(set.size() == 0)
			return false;
		
		boolean[] status = new boolean[word.length() + 1];
        status[0] = true;
        int wordCount = 0;
        for(int j = 1; j <= word.length(); j++)
        {
        	for(int i = j - 1; i >= 0; i--)
        	{
        		if(status[i] == true && set.contains(word.substring(i, j)))
        		{
        			wordCount++;
        			status[j] = true;
        		}
        	}
        }
        
        return wordCount > 1 && status[word.length()] == true;
	}
}
