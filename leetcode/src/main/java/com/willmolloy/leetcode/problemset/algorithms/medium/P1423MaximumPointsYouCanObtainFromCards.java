package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards>https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(k)
 *
 * <p>Space: O(k)
 *
 * <p>Key: Prefix sum; you are simply taking 'k' cards from the left/right sides, the order (of
 * taking them) doesn't matter.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P1422MaximumScoreAfterSplittingAString
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1423MaximumPointsYouCanObtainFromCards {

  public int maxScore(int[] cardPoints, int k) {
    int n = cardPoints.length;

    // prefix sum, score taking cards from left
    // (initially 0)
    int[] prefixSum = new int[k + 1];

    // suffix sum, score taking cards from right
    // (initially 0)
    int[] suffixSum = new int[k + 1];

    for (int i = 1; i <= k; i++) {
      prefixSum[i] = prefixSum[i - 1];
      prefixSum[i] += cardPoints[i - 1];

      suffixSum[k - i] = suffixSum[k - i + 1];
      suffixSum[k - i] += cardPoints[n - i];
    }

    int max = 0;
    for (int i = 0; i <= k; i++) {
      max = Math.max(max, prefixSum[i] + suffixSum[i]);
    }
    return max;
  }
}
