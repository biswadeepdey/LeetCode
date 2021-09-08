import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
		int[] output = PlusOneClass.PlusOne(new int[] {8,9,9,9});
		for(int t : output)
		{
			System.out.print(t + "\t");
		}
	}

}
