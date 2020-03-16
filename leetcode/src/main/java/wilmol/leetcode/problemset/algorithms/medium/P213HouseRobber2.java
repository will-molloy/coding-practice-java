package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by wilmol on 2020-03-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/house-robber-ii>https://leetcode.com/problems/house-robber-ii</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: modify existing algorithm
 *
 * @see wilmol.leetcode.problemset.algorithms.easy.P198HouseRobber
 */
class P213HouseRobber2 {

  public int rob(int[] nums) {
    if (nums.length <= 3) {
      return Arrays.stream(nums).max().orElse(0);
    }

    // difference is we can't take head and last at the same time since they're considered adjacent
    int takeHead = nums[0] + rob0(Arrays.copyOfRange(nums, 2, nums.length - 1));
    int takeLast = nums[nums.length - 1] + rob0(Arrays.copyOfRange(nums, 1, nums.length - 2));
    int takeNeither = rob0(Arrays.copyOfRange(nums, 1, nums.length - 1));
    return IntStream.of(takeHead, takeLast, takeNeither).max().getAsInt();
  }

  // copied P198HouseRobber.BottomUpConstantSpace.rob
  private int rob0(int[] nums) {
    int dpIMinus1 = 0; // dp[i - 1]
    int dp = nums[0]; // dp[i]

    for (int i = 1; i < nums.length; i++) {
      int take = nums[i] + dpIMinus1;
      int skip = dp;
      int dpIPlus1 = Math.max(take, skip);
      // swap
      int temp = dp;
      dp = dpIPlus1;
      dpIMinus1 = temp;
    }
    return dp; // dp[n]
  }
}
