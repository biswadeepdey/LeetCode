package code.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FourSumClass {

	public static void main(String[] args)
	{
		int[] nums = new int[] {0,0,0,0};
		List<List<Integer>> ll = fourSum(nums, 4, 0);
		for(List<Integer> l : ll)
		{
			for(int i : l)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int n, int target)
	{
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		for(int i = 0; i <= nums.length - n; i++)
		{
			for(int j = i+1; j <= nums.length -(n -1); j++)
			{
				int lo = j + 1; int hi = nums.length - 1;
				
				while(lo < hi)
				{
					int currSum = nums[i] + nums[j] + nums[lo] + nums[hi];
					if(currSum == target)
					{
						ArrayList<Integer> arList = new ArrayList<Integer>();
						arList.add(nums[i]);
						arList.add(nums[j]);
						arList.add(nums[lo]);
						arList.add(nums[hi]);
						set.add(arList);
						while(lo + 1 < hi && nums[lo] == nums[lo + 1])
                        {
                            lo += 1;
                        }
						lo++;
					}
					else
					{
						if(currSum > target)
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
		
		ArrayList<List<Integer>> ll =  new ArrayList<List<Integer>>();
		ll.addAll(set);
		return ll;
	}		
}
