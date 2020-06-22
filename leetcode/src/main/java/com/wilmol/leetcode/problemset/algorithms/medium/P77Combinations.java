package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wilmol on 2020-01-20.
 *
 * <p><a
 * href=https://leetcode.com/problems/combinations>https://leetcode.com/problems/combinations</a>
 *
 * <p>Runtime: TODO O()
 *
 * <p>Space: O(n!/k!(n-k)!)
 *
 * <p>Key: permutations algorithm, (recursive backtracking, DFS)
 */
class P77Combinations {

  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> result = new ArrayList<>();
    Set<Integer> temp = new LinkedHashSet<>();
    combine(n, k, result, temp, 1);
    return result;
  }

  private void combine(int n, int k, List<List<Integer>> result, Set<Integer> temp, int start) {
    if (temp.size() == k) {
      result.add(new ArrayList<>(temp));
      return;
    }

    for (int i = start; i <= n; i++) {
      // add some starter value
      temp.add(i);
      // recursively add (all combinations of) larger values - TODO can cache this?
      combine(n, k, result, temp, i + 1);
      temp.remove(i);
    }
  }
}
