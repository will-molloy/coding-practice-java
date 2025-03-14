package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/length-of-longest-fibonacci-subsequence>https://leetcode.com/problems/length-of-longest-fibonacci-subsequence</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Space: O(n<sup>2</sup>)
 *
 * <p>Key idea: Map to store indices (reduced it from O(n<sup>2</sup>log n) (was using {@link
 * Arrays#binarySearch} to find {@code k}) to O(n<sup>2</sup>)).
 *
 * @see P300LongestIncreasingSubsequence
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P873LengthOfLongestFibonacciSequence {

  public int lenLongestFibSubseq(int[] a) {
    // seq is strictly increasing, so elements are unique, so can inverse to get their index safely
    Map<Integer, Integer> indices = new HashMap<>();
    for (int i = 0; i < a.length; i++) {
      indices.put(a[i], i);
    }

    // dp[j][i] = length of sequence ending with <a[j], a[i]>
    // need to store all sequences (rather than just the longest) because final result may come from
    // a sequence that was overridden by another sequence that was longer at the time
    int[][] dp = new int[a.length][a.length];
    int max = 0;

    // try all j < i
    for (int i = 1; i < a.length; i++) {
      for (int j = 0; j < i; j++) {
        // see if we can extend some sequence ending with <a[k], a[j]> with a[i]
        // i.e. see if there exists some a[k] = a[i] - a[j] (with k < j < i) in the array
        int k = indices.getOrDefault(a[i] - a[j], -1);
        if (k >= 0 && k < j) {
          // (reiterating) sequence ending with <a[j], a[i]> extends one ending with <a[k], a[j]>
          dp[j][i] = dp[k][j] + 1;
          max = Math.max(max, dp[j][i]);
        }
      }
    }
    // dp table stored length=1 when we discovered a new sequence (<a[k], a[j], a[i]>)
    // but really that had length=3, so need to add 2
    return max >= 1 ? max + 2 : 0;
  }
}
