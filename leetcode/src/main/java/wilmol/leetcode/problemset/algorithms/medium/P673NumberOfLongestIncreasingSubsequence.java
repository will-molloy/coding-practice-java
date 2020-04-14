package wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2020-04-15.
 *
 * <p><a
 * href=https://leetcode.com/problems/number-of-longest-increasing-subsequence>https://leetcode.com/problems/number-of-longest-increasing-subsequence</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Tracking 2 things in the dp (in this case length and count).
 */
class P673NumberOfLongestIncreasingSubsequence {

  // TODO more optimal solution using 'segment trees' (O(n log n))

  public int findNumberOfLis(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }

    // dp[i][0] = length of longest subsequence ending with nums[i]
    // dp[i][1] = count of longest subsequences ending with nums[i]
    // (emphasis on longest)
    int[][] dp = new int[nums.length][2];

    // base case
    // count all the singleton subsequences
    for (int i = 0; i < nums.length; i++) {
      dp[i][0] = 1;
      dp[i][1] = 1;
    }

    // recursive case
    // left to right test all nums[i] > nums[j] where i > j, building up the sequences
    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {

        if (nums[i] > nums[j]) {
          // nums[i] extends all sequences ending in nums[j]

          if (dp[i][0] == dp[j][0] + 1) {
            // sequences ending with nums[i] and nums[j] are now equal in length
            // e.g. <1, 3, 5, 7> and <1, 3, 4> ++ <7> (nums[i]=7, nums[j]=4)
            // combine the counts
            dp[i][1] += dp[j][1];
          } else if (dp[i][0] < dp[j][0] + 1) {
            // sequences ending with nums[j] will now be longer than those ending with nums[i]
            // e.g. <1, 3, 7> and <1, 3, 5> ++ <7> (nums[i]=7, nums[j]=5)
            // update the length
            // override the count
            dp[i][0] = dp[j][0] + 1;
            dp[i][1] = dp[j][1];
          }
        }
      }
    }

    // count number of sequences with the max length
    int maxLength = 0;
    for (int[] x : dp) {
      maxLength = Math.max(maxLength, x[0]);
    }
    int count = 0;
    for (int[] x : dp) {
      if (x[0] == maxLength) {
        count += x[1];
      }
    }
    return count;
  }
}
