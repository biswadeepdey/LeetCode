import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;
import code.nodes.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
		int[] a = new int[] {2,5,6,7,8,0,0,0};
		int[] b = new int[] {1,2,3};
		
		MergeSortedArrayClass.MergeSortedArray(a, 5, b, 3);
		for(int o : a)
		{
			System.out.println(o);
		}
	}

}
