package code.medium;

public class SearchInRotatedSortedArray {
	public boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        
        while(lo <= hi)
        {
        	int mid = lo + ((hi - lo) / 2);
        	if(target == nums[mid])
        	{
        		return true;
        	}
        	else if(target > nums[mid])
        	{
        		if(nums[hi] < target)
        		{
        			hi = mid - 1;
        		}
        		else
        		{
        			lo = mid + 1;
        		}
        	}
        	else if(target < nums[mid])
        	{
        		if(nums[lo] > target)
        		{
        			lo = mid + 1;
        		}
        		else
        		{
        			hi = mid - 1;
        		}
        	}
        }
        
        return false;
    }
	
	public static void main(String[] args) {
		SearchInRotatedSortedArray obj = new SearchInRotatedSortedArray();
		System.out.println(obj.search(new int[] {5,1,2,3,4,5}, 1));
	}
}
