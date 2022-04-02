package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/sort-array-by-parity>https://leetcode.com/problems/sort-array-by-parity/</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P905SortArrayByParity {

  int[] sortArrayByParity(int[] a);

  /**
   * Linear solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra space: O(n)
   *
   * <p>Key: Filter for evens then odds, more efficient than sorting.
   */
  class Linear implements P905SortArrayByParity {

    @Override
    public int[] sortArrayByParity(int[] a) {
      int n = a.length;
      int[] answer = new int[n];
      int i = 0;
      for (int value : a) {
        if (value % 2 == 0) {
          answer[i++] = value;
        }
      }
      for (int value : a) {
        if (value % 2 != 0) {
          answer[i++] = value;
        }
      }
      return answer;
    }
  }

  /**
   * Linear in place solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra space: O(1)
   *
   * <p>Key: Swap even values to the front.
   */
  class LinearInPlace implements P905SortArrayByParity {

    @Override
    public int[] sortArrayByParity(int[] a) {
      int n = a.length;
      int i = 0;
      for (int j = 0; j < n; j++) {
        if (a[j] % 2 == 0) {
          // swap even value to the front
          swap(a, i, j);
          i++;
        }
      }
      return a;
    }

    private void swap(int[] a, int i, int j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
  }
}
