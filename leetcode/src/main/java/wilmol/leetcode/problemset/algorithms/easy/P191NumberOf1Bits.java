package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-24.
 *
 * <p><a
 * href=https://leetcode.com/problems/number-of-1-bits>https://leetcode.com/problems/number-of-1-bits/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(bitlen(n))
 *
 * <p>Space: O(1)
 *
 * <p>Key: {@link Integer#bitCount} method.
 */
class P191NumberOf1Bits {

  // you need to treat n as an unsigned value
  public int hammingWeight(int n) {
    return Integer.bitCount(n);
  }
}
