package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers>https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Answer is the max digit, since you would need at minimum that many 1s in that place,
 * the rest you can fill with 0s.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1689PartitioningIntoMinimumNumberOfDeciBinaryNumbers {

  public int minPartitions(String n) {
    int maxDigit = 0;
    for (char c : n.toCharArray()) {
      maxDigit = Math.max(maxDigit, Character.digit(c, 10));
    }
    return maxDigit;
  }
}
