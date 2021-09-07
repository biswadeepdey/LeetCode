import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import code.easy.*;

public class LeetCode {
	@Test
	public static void main(String[] args) {
		assertEquals(0, SearchInsertPositionClass.SearchInsertPosition(new int[] {1,3,5,6}, 1));
		assertEquals(1, SearchInsertPositionClass.SearchInsertPosition(new int[] {1,3,5,6}, 2));
		assertEquals(4, SearchInsertPositionClass.SearchInsertPosition(new int[] {1,3,5,6}, 7));
		assertEquals(0, SearchInsertPositionClass.SearchInsertPosition(new int[] {1,3,5,6}, 0));
		assertEquals(0, SearchInsertPositionClass.SearchInsertPosition(new int[] {1}, 0));
	}

}
