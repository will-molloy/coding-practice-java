package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * <a
 * href=https://leetcode.com/problems/numbers-with-same-consecutive-differences>https://leetcode.com/problems/numbers-with-same-consecutive-differences/</a>
 *
 * <p>Runtime: O(n * 2<sup>n</sup>), {@code dfs} depth n, branching factor 2
 *
 * <p>Extra memory: O(2<sup>n</sup>)
 *
 * <p>Key idea: The number generation forms a tree. Traverse it to get the results (root to leaf
 * paths).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P967NumbersWithSameConsecutiveDifferences {

  public int[] numsSameConsecDiff(int n, int k) {
    if (n > 1) {
      Set<Integer> result = new HashSet<>();
      for (int i = 1; i <= 9; i++) {
        dfs(result, i, 1, n, k);
      }
      return result.stream().mapToInt(Integer::intValue).toArray();
    } else {
      // 1 digit, roots only
      return IntStream.rangeClosed(0, 9).toArray();
    }
  }

  private void dfs(Set<Integer> result, int temp, int len, int n, int k) {
    if (len == n) {
      result.add(temp);
      return;
    }

    int last = temp % 10;
    if (last - k >= 0) {
      dfs(result, temp * 10 + (last - k), len + 1, n, k);
    }
    if (last + k <= 9) {
      dfs(result, temp * 10 + (last + k), len + 1, n, k);
    }
  }
}
