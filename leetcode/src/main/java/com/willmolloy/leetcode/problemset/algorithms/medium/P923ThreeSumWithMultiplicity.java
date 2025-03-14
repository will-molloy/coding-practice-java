package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/3sum-with-multiplicity>https://leetcode.com/problems/3sum-with-multiplicity/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra memory: O(n) TODO O(1) is space possible
 *
 * <p>Key idea: {@code arr[k] = target - arr[i] - arr[j]}, use hashmap to lookup.
 *
 * @see P15ThreeSum
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P923ThreeSumWithMultiplicity {

  private static final int MOD = (int) 1e9 + 7;

  public int threeSumMulti(int[] arr, int target) {
    int n = arr.length;

    // want:
    // arr[i] + arr[j] + arr[k] = target
    // same as:
    // arr[k] = target - arr[i] - arr[j]
    // so iterate all pairs (i, j) looking up count of arr[k]

    Map<Integer, Integer> map = new HashMap<>();

    long count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        count += map.getOrDefault(target - arr[i] - arr[j], 0);
      }
      // only increase count now to satisfy the condition i < j < k (now considering i as k)
      map.merge(arr[i], 1, Integer::sum);
    }
    return (int) (count % MOD);
  }
}
