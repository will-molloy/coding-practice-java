package wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-24.
 *
 * <p><a
 * href=https://leetcode.com/problems/power-of-two>https://leetcode.com/problems/power-of-two/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(bitlen(n))
 *
 * <p>Space: O(1)
 *
 * <p>Key: Power of two has one '1' bit.
 */
class P231PowerOfTwo {

  public boolean isPowerOfTwo(int n) {
    return n > 0 && Integer.bitCount(n) == 1;
  }
}
