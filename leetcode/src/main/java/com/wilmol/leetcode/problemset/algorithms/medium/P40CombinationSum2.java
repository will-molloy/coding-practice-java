package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/combination-sum-ii>https://leetcode.com/problems/combination-sum-ii</a>
 *
 * <p>Runtime: O(2^n)
 *
 * @see P39CombinationSum
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P40CombinationSum2 {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] seen = new boolean[candidates.length];
    return new ArrayList<>(solve(result, temp, candidates, seen, target));
  }

  // same as before, but keep track of nodes which have been 'seen'/'visited'
  private Set<List<Integer>> solve(
      Set<List<Integer>> result, List<Integer> temp, int[] candidates, boolean[] seen, int target) {
    if (target < 0) {
      // early exit
      return result;
    }
    if (target == 0) {
      // sort to distinguish duplicate solutions
      List<Integer> copy = new ArrayList<>(temp);
      Collections.sort(copy);
      result.add(copy);
    }

    for (int i = 0; i < candidates.length; i++) {
      if (seen[i]) {
        continue;
      }
      temp.add(candidates[i]);
      seen[i] = true;
      solve(result, temp, candidates, seen, target - candidates[i]);
      // remove last
      temp.remove(temp.size() - 1);
      seen[i] = false;
    }
    return result;
  }
}
