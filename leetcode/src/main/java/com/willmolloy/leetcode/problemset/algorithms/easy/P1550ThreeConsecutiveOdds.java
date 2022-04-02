package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/three-consecutive-odds>https://leetcode.com/problems/three-consecutive-odds/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Count consecutive odd.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1550ThreeConsecutiveOdds {

  // O(n)
  public boolean threeConsecutiveOdds(int[] arr) {
    int odds = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] % 2 != 0) {
        odds++;
        if (odds == 3) {
          return true;
        }
      } else {
        odds = 0;
      }
    }
    return false;
  }
}
