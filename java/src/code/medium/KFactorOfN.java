package code.medium;
import java.util.*;

public class KFactorOfN {
	public static int kthFactor(int n, int k) {
        SortedSet<Integer> set = new TreeSet<>();
        
        int divider = 1;
        while( divider <= n )
        {
        	if(set.contains(divider))
        	{
        		break;
        	}
        	
        	if(n % divider == 0)
        	{
        		set.add(divider);
        		set.add(n / divider);
        	}
        	
        	divider++;
        }
        
        if(set.size() < k)
        	return -1;
        
        int result = 0;
        Iterator<Integer> itr = set.iterator();
        int count = 1;
        while(itr.hasNext())
        {
        	result = itr.next();
        	if(count == k)
        	{
        		break;
        	}
        	count++;
        }
        
        return result;
    }
}
