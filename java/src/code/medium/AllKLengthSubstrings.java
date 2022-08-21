package code.medium;
import java.util.*;
public class AllKLengthSubstrings {
	public int numKLenSubstrNoRepeats(String s, int k) {
        boolean[] ref = new boolean[128];
        Arrays.fill(ref, false);
        
        int result = 0;
        
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length(); i++)
        {
        	char c = s.charAt(i);
        	if(!ref[c - 'a'])
        	{
        		ref[c - 'a'] = true;
        		q.add(c);
        	}
        	else
        	{
        		while(q.peek() != c)
        		{
        			char p = q.poll();
        			ref[p - 'a'] = false;
        		}
        		char p = q.poll();
        		ref[p - 'a'] = false;
        		q.add(c);
        		ref[c - 'a'] = true;
        	}
        	if(q.size() == k)
    		{
        		char p = q.poll();
        		ref[p - 'a'] = false;
    			result++;
    		}
        }
        
        return result;
    }
	
	public static void main(String[] args)
	{
		AllKLengthSubstrings obj = new AllKLengthSubstrings();
		System.out.println(obj.numKLenSubstrNoRepeats("aaaaaaabcdeaa", 5));
	}
}
