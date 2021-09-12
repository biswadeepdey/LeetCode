package code.easy;

//int[] a = new int[] {2,5,6,7,8,0,0,0};
//int[] b = new int[] {1,2,3};

public class MergeSortedArrayClass {
	public static void MergeSortedArray(int[] nums1, int m, int[] nums2, int n)
	{
		int i = 0, j = 0, l = 0;
		int[] k = new int[m + n];
		
		while(i < m || j < n)
		{
			if(i >= m)
			{
				k[l++] = nums2[j++];
			}
			else if(j >= n)
			{
				k[l++] = nums1[i++];
			}
			else
			{
				if(nums1[i] < nums2[j])
				{
					k[l++] = nums1[i++];
				}
				else
				{
					k[l++] = nums2[j++];
				}
			}
		}
		
		for(int o = 0; o < k.length; o++)
		{
			nums1[o] = k[o];
		}
	}
}
