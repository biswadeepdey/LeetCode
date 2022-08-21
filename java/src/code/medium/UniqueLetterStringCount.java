package code.medium;

import java.util.*;

public class UniqueLetterStringCount {
	public int uniqueLetterString(String s) {
        int[] lastFoundAt = new int[128];
        int[] lastOccCount = new int[128];
        
        Arrays.fill(lastFoundAt, -1);
        Arrays.fill(lastOccCount, -1);
        
        int result = 0;
        int count = 0;
        
        for(int i = 0; i < s.length(); i++)
        {
            if(lastFoundAt[s.charAt(i)] == -1)
            {
                count += 1 + i;
                result += count;
            }
            else
            {
                int aCount = count + 1 + i;
                count = aCount - (lastFoundAt[s.charAt(i)] + lastOccCount[s.charAt(i)]);
                result += count;
            }
            
            lastFoundAt[s.charAt(i)] = i;
            lastOccCount[s.charAt(i)] = count;
        }
        
        return result;
    }
}
