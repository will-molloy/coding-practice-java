package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/permutation-sequence>https://leetcode.com/problems/permutation-sequence</a>
 *
 * <p>Runtime: O(nk) TODO apparently there is an O(n^2) solution. Given n is in 1..9 and k is in
 * 1..n!, that would be faster.
 *
 * <p>Key: knowledge of next permutation algorithm, just something you have to memorise I guess?
 *
 * @see P31NextPermutation
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P60PermutationSequence {

  public String getPermutation(int n, int k) {
    // create the sequence as an int array for efficiency
    int[] nums = new int[n];
    for (int i = 1; i <= n; i++) {
      nums[i - 1] = i;
    }

    // simply compute next permutation 'k' times
    while (k-- > 1) {
      nextPermutation(nums);
    }

    // return as string
    return Arrays.stream(nums).mapToObj(String::valueOf).collect(Collectors.joining());
  }

  /**
   * Gets the next permutation of {@code nums} in place.
   *
   * <p>Runtime: O(n)
   *
   * @see P31NextPermutation
   */
  private static void nextPermutation(int[] nums) {
    // find increasing pair (from the right) (a, b)

    // get left of pair, a
    int a = nums.length - 1;
    while (a > 0 && nums[a - 1] >= nums[a]) {
      a -= 1;
    }
    a -= 1;

    // get right of pair, b
    int b = nums.length - 1;
    while (a >= 0 && b >= 0 && nums[b] <= nums[a]) {
      b -= 1;
    }

    // swap a with b
    // (a could be -1 if no increasing pair, i.e. nums is in descending order, in this case the
    // reversal puts the array in ascending sorted order)
    if (a >= 0) {
      swap(nums, a, b);
    }

    // reverse elements beyond a
    reverse(nums, a + 1);
  }

  /** Swaps {@code nums[a]} with {@code nums[b]} in place. */
  private static void swap(int[] nums, int a, int b) {
    int temp = nums[a];
    nums[a] = nums[b];
    nums[b] = temp;
  }

  /** Reverses {@code nums} in place from the given index to the end. */
  private static void reverse(int[] nums, int fromIndex) {
    int i = nums.length - 1;
    int j = fromIndex;
    while (i > j) {
      swap(nums, i, j);
      i -= 1;
      j += 1;
    }
  }
}
