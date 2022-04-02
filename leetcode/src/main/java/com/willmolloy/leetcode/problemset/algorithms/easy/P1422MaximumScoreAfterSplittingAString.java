package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-score-after-splitting-a-string>https://leetcode.com/problems/maximum-score-after-splitting-a-string/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Prefix sum.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1423MaximumPointsYouCanObtainFromCards
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1422MaximumScoreAfterSplittingAString {

  public int maxScore(String s) {
    int n = s.length();

    // left score, count of 0s so far (prefix sum)
    // (exclude last index of string as right substring must not be empty)
    int[] leftScore = new int[n - 1];
    for (int i = 0; i < n - 1; i++) {
      leftScore[i] = i > 0 ? leftScore[i - 1] : 0;
      if (s.charAt(i) == '0') {
        leftScore[i]++;
      }
    }

    // right score, count of 1s so far (suffix sum)
    // (exclude first index of string as left substring must not be empty)
    int[] rightScore = new int[n - 1];
    for (int i = n - 1; i > 0; i--) {
      rightScore[i - 1] = i < n - 1 ? rightScore[i] : 0;
      if (s.charAt(i) == '1') {
        rightScore[i - 1]++;
      }
    }

    int max = 0;
    for (int i = 0; i < n - 1; i++) {
      max = Math.max(max, leftScore[i] + rightScore[i]);
    }
    return max;
  }
}
