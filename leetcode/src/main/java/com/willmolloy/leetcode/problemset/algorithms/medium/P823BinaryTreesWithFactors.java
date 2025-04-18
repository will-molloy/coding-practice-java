package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/binary-trees-with-factors>https://leetcode.com/problems/binary-trees-with-factors/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: A valid tree would have the root being larger than its children, and its children
 * (recursively) being valid trees. So memoise the result from smaller trees and build up to larger
 * trees (dynamic programming). I.e. {@code dp[root] = dp[left] * dp[right]}; summed over all
 * possible left/right children.
 *
 * <p>Need to consider all nodes as roots, i.e. result = sum(dp).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P823BinaryTreesWithFactors {

  private static final long MOD = (long) 1e9 + 7;

  public int numFactoredBinaryTrees(int[] a) {
    // sort for bottom up dp; larger roots depend on the result of smaller roots
    Arrays.sort(a);
    // dp[i] - number of valid trees with root as node 'i'
    Map<Integer, Long> dp = new HashMap<>();
    long result = 0;

    // consider every node as root
    for (int root = 0; root < a.length; root++) {
      // base case - single node tree
      dp.put(a[root], 1L);
      // recursive case - consider every possible left/right child of 'root'
      for (int leftChild = 0; leftChild < root; leftChild++) {
        if (a[root] % a[leftChild] == 0) {
          int rightChild = a[root] / a[leftChild];
          dp.put(
              a[root],
              (dp.get(a[root]) + dp.get(a[leftChild]) * dp.getOrDefault(rightChild, 0L)) % MOD);
        }
      }
      result = (result + dp.get(a[root])) % MOD;
    }
    return (int) result;
  }
}
