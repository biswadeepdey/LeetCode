package code.easy;
import java.util.*;

public class IntersectionOfArraysClass {
	public static int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        
        for(int i : nums1)
        {
            if(map1.get(i) == null)
            {
                map1.put(i, 1);
            }
            else
            {
                map1.put(i, map1.get(i) + 1);
            }
        }
        
        for(int i : nums2)
        {
            if(map2.get(i) == null)
            {
                map2.put(i, 1);
            }
            else
            {
                map2.put(i, map2.get(i) + 1);
            }
        }
        
        Vector<Integer> v = new Vector<Integer>();
        for(Map.Entry<Integer, Integer> e : map1.entrySet())
        {
            if(map2.get(e.getKey()) != null)
            {
                int minOcc = Integer.min(map2.get(e.getKey()), map1.get(e.getKey()));
                for(int i = 0; i < minOcc; i++)
                {
                    v.add(e.getKey());
                }
            }
        }
        
        int[] arr = new int[v.size()];
        int i = 0;
        for(int j : v)
        {
        	arr[i++] = j;
        }
        
        return arr;
    }
	
	public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0; int j = 0;
        ArrayList<Integer> al = new ArrayList<Integer>();
        
        while(i < nums1.length && j < nums2.length)
        {
            if(nums1[i] == nums2[j])
            {
                al.add(nums1[i]);
                i++;
                j++;
            }
            else
            {
                if(nums1[i] > nums2[j])
                {
                    j++;
                }
                else
                {
                    i++;
                }
            }
        }
        
        int[] result = new int[al.size()];
        int k = 0;
        for(int e : al)
        {
            result[k++] = e;
        }
        
        return result;
    }
}
