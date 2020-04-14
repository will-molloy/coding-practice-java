package wilmol.leetcode.problemset.algorithms.unknown;

// TODO categorise and change link when leetcode adds this as an official problem

/**
 * Created by wilmol on 2020-04-14.
 *
 * <p><a
 * href=https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289>https://leetcode.com/explore/featured/card/30-day-leetcoding-challenge/528/week-1/3289</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: dump into table for O(1) contains check. Also the {@code i < 1000} guard expression.
 */
class CountingElements {

  public int countElements(int[] nums) {
    // dump into table for O(1) contains check
    int[] table = new int[1001];
    for (int i : nums) {
      table[i] = 1;
    }

    int count = 0;
    for (int i : nums) {
      if (i < 1000 && table[i + 1] == 1) {
        count += 1;
      }
    }
    return count;
  }
}
