package code.medium;
import java.util.*;

public class LongestIncreasingSubsequenceClass {
	public static int LongestIncreasingSubsequence(int[] nums)
	{
		int[] arr = new int[nums.length];
        for(int i =0; i< arr.length; i++)
        {
            arr[i] = 1;
        }
        
        
        for(int j = 1; j < arr.length; j++)
        {
            int i = 0;
            while(i != j)
            {
                if(nums[j] > nums[i])
                {
                    arr[j] = Integer.max(arr[j], arr[i] + 1);
                }
                i++;
            }
        }
        
        Arrays.sort(arr);
        
        return arr[arr.length - 1];
	}
}
