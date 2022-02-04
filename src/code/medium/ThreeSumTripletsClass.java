package code.medium;
import java.util.*;

public class ThreeSumTripletsClass {
	static String key(int i, int j, int k)
    {
        return ""+i+j+k;
    }
    
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        Set<String> set = new HashSet<String>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        for(int i =0; i < N - 2; i++)
        {
            for(int j = i+1; j < N - 1; j++)
            {
                for(int k = j + 1; k < N; k++)
                {
                    if(nums[i]+nums[j]+nums[k] == 0)
                    {
                        if(!set.contains(key(nums[i],nums[j],nums[k])))
                        {
                            LinkedList<Integer> l = new LinkedList<Integer>();
                            l.add(nums[i]);
                            l.add(nums[j]);
                            l.add(nums[k]);
                            list.add(l);
                            set.add(key(nums[i],nums[j],nums[k]));
                        }
                    }
                }
            }
        }
        
        return list;
    }
    
    public static List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        int N = nums.length;
        int k = 0;
        Set<String> set = new HashSet<String>();
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        
        for(int i = 0; i < N-2; i++)
        {
            if(i == 0 || (i > 0 && nums[i] != nums[i -1]))
            {
                int nextSum = k - nums[i];
                int lo = i + 1;
                int hi = N - 1;
                
                while(lo < hi)
                {
                    int sum = nums[lo] + nums[hi];
                    if(sum == nextSum) /* && !set.contains(key(nums[i], nums[lo], nums[hi]))*/
                    {
                        // set.add(key(nums[i], nums[lo], nums[hi]));
                        LinkedList<Integer> l = new LinkedList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[lo]);
                        l.add(nums[hi]);
                        list.add(l);
                        break;
                    }
                    else
                    {
                        if(sum > nextSum)
                        {
                            hi--;
                        }
                        else
                        {
                            lo++;
                        }
                    }
                }
            }
            
            
        }
        
        return list;
    }
}
