package code.hard;
import java.util.*;

class Sentence implements Comparable<Sentence>{
	String str;
	int priority;
	
	public Sentence(String s, int i)
	{
		str = s;
		priority = i;
	}
	
	public int compareTo(Sentence s)
	{
		int c = Integer.compare(this.priority, s.priority);
		return c == 0 ? this.str.compareTo(s.str) : c * (-1);
	}
}

public class AutocompleteSystem {
	List<Sentence> data;
	String keyword;
	List<Sentence> lastResult;
	
    public AutocompleteSystem(String[] sentences, int[] times) {
        data = new LinkedList<Sentence>();
        lastResult = new LinkedList<Sentence>();
        for(int i = 0; i < sentences.length; i++)
        {
        	data.add(new Sentence(sentences[i], times[i]));
        }
        Collections.sort(data);
        
        lastResult = data;
        keyword = "";
    }
    
    public List<String> input(char c) {
        String s = String.valueOf(c);
        keyword += s;
        
        List<Sentence> currResult = new LinkedList<>();
        for(Sentence sen : lastResult)
        {
        	if(sen.str.indexOf(keyword) == 0)
        	{
        		currResult.add(sen);
        	}
        }
        
        lastResult = currResult;
        
        List<String> result = new LinkedList<>();
        int resultCount = currResult.size() >= 3 ? 3 : currResult.size();
        int maxCount = resultCount;
//        for(Sentence ss : currResult)
        while(resultCount > 0 && currResult.size() >= resultCount)
        {
        	result.add(currResult.get(maxCount - resultCount--).str);
        }
        
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */