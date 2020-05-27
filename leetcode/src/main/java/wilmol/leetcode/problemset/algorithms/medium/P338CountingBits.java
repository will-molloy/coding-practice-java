package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-05-27.
 *
 * <p><a
 * href=https://leetcode.com/problems/counting-bits>https://leetcode.com/problems/counting-bits/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Draw out the dp table to realise the pattern. In this case it repeats every power of 2.
 */
class P338CountingBits {

  public int[] countBits(int num) {
    int[] dp = new int[num + 1];
    int pow2 = 1;
    for (int i = 1; i <= num; i++) {
      if (i == 2 * pow2) {
        pow2 *= 2;
      }
      dp[i] = dp[i - pow2] + 1;
    }
    return dp;
  }
}
