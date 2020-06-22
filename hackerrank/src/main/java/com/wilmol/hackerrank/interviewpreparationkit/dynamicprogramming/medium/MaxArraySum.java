package com.wilmol.hackerrank.interviewpreparationkit.dynamicprogramming.medium;

import static java.lang.Math.max;

/**
 * Created by wilmol on 2020-05-15.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming>https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: {@code dp[i]} represents answer for {@code arr[0, i]}.
 */
final class MaxArraySum {

  static int maxSubsetSum(int... arr) {
    int n = arr.length;

    if (n == 1) {
      return max(0, arr[0]);
    } else if (n == 2) {
      return max(max(0, arr[0]), arr[1]);
    }

    // dp[i] = answer for arr[0, i]
    int[] dp = new int[n];
    dp[0] = max(0, arr[0]);
    dp[1] = max(dp[0], arr[1]);

    // dp[i] = max(dp[i - 1], dp[i - 2], arr[i] + dp[i - 2])
    // i.e. try extend with arr[i] or take previous best
    for (int i = 2; i < n; i++) {
      dp[i] = max(max(dp[i - 1], dp[i - 2]), arr[i] + dp[i - 2]);
    }

    return dp[n - 1];
  }

  private MaxArraySum() {}
}
