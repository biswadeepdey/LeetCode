package code.medium;

import java.util.Arrays;

public class NextPermutationClass {
	public static void nextPermutation(int[] nums) {
		if (nums.length < 2) {
			return;
		}

		int i = nums.length - 2;

		// go from right till we see break in decrement
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i < 0) {
			// next permutation not possible
			Arrays.sort(nums);

			return;
		}

		// from right find the next closest higher value
		int j = nums.length - 1;

		while (j > i && nums[i] >= nums[j]) {
			j--;
		}

		// swap values at i and position
		int tmp = nums[j];
		nums[j] = nums[i];
		nums[i] = tmp;

		// sort the array from position i + 1
		int[] arr = new int[nums.length - (i + 1)];
		for (int k = i + 1, l = 0; l < arr.length; l++) {
			arr[l] = nums[k];
			k++;
		}
		Arrays.sort(arr);
		for (int k = i + 1, l = 0; l < arr.length; l++) {
			nums[k] = arr[l];
			k++;
		}
	}
}
