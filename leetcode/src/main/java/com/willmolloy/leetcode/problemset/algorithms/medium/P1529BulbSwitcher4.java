package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/bulb-switcher-iv>https://leetcode.com/problems/bulb-switcher-iv/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Count flips from front. Must be min because you'd start flipping from the front to
 * avoid redundant flips.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1529BulbSwitcher4 {

  public int minFlips(String target) {
    char curr = '0';
    int count = 0;
    for (char c : target.toCharArray()) {
      if (curr != c) {
        count++;
        curr = c;
      }
    }
    return count;
  }
}
