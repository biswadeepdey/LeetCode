package code.hard;
import java.util.*;
public class CountUniqueSubstrChar {
	public static int uniqueLetterString(String s) {
        int[] lastFoundAt = new int[128];
        Arrays.fill(lastFoundAt, -1);
        int count = 0, result = 0, lastCharValue = 0;
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(lastFoundAt[c] != -1)
            {
                // 1 + # previous elements - last found location + last char value - current occurance
                lastCharValue = 1 + i - lastFoundAt[c] + (i + 1);
            }
            else
            {
                lastCharValue = 1 + i;
            }
            
            count += lastCharValue;
            result += count;
            lastFoundAt[c] = i;
        }
        
		return result;
    }
}
