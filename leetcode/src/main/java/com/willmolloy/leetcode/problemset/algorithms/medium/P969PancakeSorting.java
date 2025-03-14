package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/pancake-sorting>https://leetcode.com/problems/pancake-sorting/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Each iteration swap the maximum element (of the sub array) to its final position by
 * first swapping to the front and then the end of the sub array; where the sub array is initially
 * a[0, n), then a[0, n-1) etc until a[0, 1) (sort done). I.e. the loop maintains the invariant that
 * the suffix is always sorted.
 *
 * <p>Conveniently, in this case, the array is always a permutation of the integers [1, n] so know
 * the current maximum and the final position of {@code a[i]} is {@code i - 1}. Otherwise would need
 * to search for the maximum each iteration.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P969PancakeSorting {

  public List<Integer> pancakeSort(int[] a) {
    // result is 1-indexed
    List<Integer> result = new ArrayList<>();

    int currMax = a.length;
    while (currMax > 1) {
      int i = search(a, currMax);

      if (i != currMax - 1) {
        // swap currMax to front
        result.add(i + 1);
        reverse(a, i);

        // swap currMax to its final position
        result.add(currMax);
        reverse(a, currMax - 1);
      }

      currMax--;
    }
    return result;
  }

  private int search(int[] a, int key) {
    for (int i = 0; i < a.length; i++) {
      if (a[i] == key) {
        return i;
      }
    }
    throw new AssertionError("search failed");
  }

  private void reverse(int[] a, int end) {
    int l = 0;
    int r = end;
    while (l < r) {
      int temp = a[l];
      a[l] = a[r];
      a[r] = temp;
      l++;
      r--;
    }
  }
}
