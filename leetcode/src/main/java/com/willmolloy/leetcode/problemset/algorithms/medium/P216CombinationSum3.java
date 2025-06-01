package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/combination-sum-iii>https://leetcode.com/problems/combination-sum-iii/</a>
 *
 * <p>Runtime: O(9<sup>k</sup>)
 *
 * <p>Extra memory: O(k)
 *
 * <p>Key idea: DFS with backtracking. Making child nodes larger than parent nodes to avoid
 * duplicates.
 *
 * @see P39CombinationSum
 * @see P40CombinationSum2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P216CombinationSum3 {

  public List<List<Integer>> combinationSum3(int k, int n) {
    return dfs(new ArrayList<>(), new ArrayList<>(), 0, k, n, 0);
  }

  private List<List<Integer>> dfs(
      List<List<Integer>> result, List<Integer> path, int sum, int k, int n, int last) {
    if (path.size() == k) {
      if (sum == n) {
        result.add(new ArrayList<>(path));
      }
    } else {
      for (int i = last + 1; i <= 9; i++) {
        path.add(i);
        dfs(result, path, sum + i, k, n, i);
        path.removeLast();
      }
    }
    return result;
  }
}
