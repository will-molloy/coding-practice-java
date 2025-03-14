package com.willmolloy.leetcode.problemset.algorithms.medium;

/**
 * <a
 * href=https://leetcode.com/problems/xor-queries-of-a-subarray>https://leetcode.com/problems/xor-queries-of-a-subarray/</a>
 *
 * <p>Runtime: O(a + q)
 *
 * <p>Extra space: O(a)
 *
 * <p>Key idea: XOR prefix sum.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1310XorQueriesOfASubarray {

  public int[] xorQueries(int[] arr, int[][] queries) {
    int[] xorPrefixSum = new int[arr.length];
    xorPrefixSum[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      xorPrefixSum[i] = xorPrefixSum[i - 1] ^ arr[i];
    }

    int[] answer = new int[queries.length];
    for (int i = 0; i < queries.length; i++) {
      int[] query = queries[i];
      int start = query[0];
      int end = query[1];
      // range [start, end] = [0, end] - [0, start)
      answer[i] = start > 0 ? xorPrefixSum[end] ^ xorPrefixSum[start - 1] : xorPrefixSum[end];
    }
    return answer;
  }
}
