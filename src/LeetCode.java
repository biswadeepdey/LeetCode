import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
		assertEquals(6, MaximumSubarrayClass.MaximumSubarray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
		assertEquals(-1, MaximumSubarrayClass.MaximumSubarray(new int[] {-2,-1,-3,-4,-1,-2,-1,-5,-4}));
		assertEquals(1, MaximumSubarrayClass.MaximumSubarray(new int[] {-1,1}));
	}

}
