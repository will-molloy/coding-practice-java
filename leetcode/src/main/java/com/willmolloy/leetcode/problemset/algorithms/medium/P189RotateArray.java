package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/rotate-array>https://leetcode.com/problems/rotate-array/</a>
 *
 * @see P1625LexicographicallySmallestStringAfterApplyingOperations
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P189RotateArray {

  void rotate(int[] nums, int k);

  /**
   * Naive linear solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra memory: O(n)
   *
   * <p>Key idea: Modulo operator.
   */
  final class CopyArray implements P189RotateArray {

    @Override
    public void rotate(int[] nums, int k) {
      int n = nums.length;
      k %= n;

      int[] copy = nums.clone();
      for (int i = 0; i < n; i++) {
        nums[i] = copy[(i + (n - k)) % n];
      }
    }
  }

  /**
   * A constant space solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra memory: O(1)
   *
   * <p>Key idea: Result array can be partitioned into those which wrap around and those that don't.
   * I.e. {@code <wrapped> + <not wrapped>}, where {@code <wrapped>} has size {@code k}. Reversing
   * creates such a partition, then just need to undo the reversal for each partition.
   */
  final class ReverseArray implements P189RotateArray {

    @Override
    public void rotate(int[] nums, int k) {
      int n = nums.length;
      k %= n;

      // reverse all
      reverse(nums, 0, n - 1);
      // undo reverse for each partition
      reverse(nums, 0, k - 1);
      reverse(nums, k, n - 1);
    }

    private void reverse(int[] a, int start, int end) {
      while (start < end) {
        swap(a, start, end);
        start++;
        end--;
      }
    }

    private void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}
