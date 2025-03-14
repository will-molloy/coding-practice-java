package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence>https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/</a>
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1630ArithmeticSubarrays
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1502CanMakeArithmeticProgressionFromSequence {

  boolean canMakeArithmeticProgression(int[] copy);

  /**
   * Naive solution.
   *
   * <p>Runtime: O(n * log(n))
   *
   * <p>Extra memory: O(1)
   *
   * <p>Key idea: Sort the array and test every distance is the same.
   */
  class Sort implements P1502CanMakeArithmeticProgressionFromSequence {

    @Override
    public boolean canMakeArithmeticProgression(int[] a) {
      int n = a.length;
      assert n >= 2;

      Arrays.sort(a);

      int step = a[1] - a[0];
      for (int i = 2; i < n; i++) {
        if (a[i] - a[i - 1] != step) {
          return false;
        }
      }
      return true;
    }
  }

  /**
   * Smarter solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra memory: O(n)
   *
   * <p>Key idea: Compute {@code step = (max - min) / (n - 1)} and test each value offset by min is
   * on the step.
   */
  class DivisibleByStep implements P1502CanMakeArithmeticProgressionFromSequence {

    @Override
    public boolean canMakeArithmeticProgression(int[] a) {
      int n = a.length;
      assert n >= 2;

      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;
      for (int value : a) {
        min = Math.min(min, value);
        max = Math.max(max, value);
      }

      if (max == min) {
        // array has a single unique value which is valid (the one case where dupes are allowed)
        return true;
      }

      if ((max - min) % (n - 1) != 0) {
        // step isn't an integer, so can't space out the integer values evenly
        return false;
      }
      int step = (max - min) / (n - 1);

      // set to test no dupes (already tested the case where dupes are allowed)
      Set<Integer> set = new HashSet<>();
      for (int value : a) {
        if ((value - min) % step != 0) {
          // value offset by min isn't on the step
          return false;
        }
        if (!set.add(value)) {
          // value is duplicate
          return false;
        }
      }
      return true;
    }
  }
}
