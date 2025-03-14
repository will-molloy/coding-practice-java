package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/arithmetic-subarrays>https://leetcode.com/problems/arithmetic-subarrays/</a>
 *
 * <p>Runtime: O(m * n * log(n)) - O(m*n) is possible, see {@link
 * com.willmolloy.leetcode.problemset.algorithms.easy.P1502CanMakeArithmeticProgressionFromSequence}
 *
 * <p>Extra memory: O(n) (array copy)
 *
 * <p>Key idea: Brute force - test every subarray with the code in P1502.
 *
 * @see
 *     com.willmolloy.leetcode.problemset.algorithms.easy.P1502CanMakeArithmeticProgressionFromSequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1630ArithmeticSubarrays {

  public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
    int m = l.length;
    List<Boolean> list = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      list.add(canFormArithmeticSequence(nums, l[i], r[i]));
    }
    return list;
  }

  private boolean canFormArithmeticSequence(int[] a, int l, int r) {
    // copy because we only want to sort a[l, r], also because sorting modifies the array and we
    // need to preserve the element indices for further queries
    int[] copy = Arrays.copyOfRange(a, l, r + 1);
    int n = copy.length;
    assert n >= 2;
    Arrays.sort(copy);
    int step = copy[1] - copy[0];
    for (int i = 2; i < n; i++) {
      if (copy[i] - copy[i - 1] != step) {
        return false;
      }
    }
    return true;
  }
}
