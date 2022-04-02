package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Input can have duplicates, results should be unique.
 *
 * <p><a
 * href=https://leetcode.com/problems/permutations-ii>https://leetcode.com/problems/permutations-ii</a>
 *
 * <p>Runtime: O(n!), Space: O(n!)
 *
 * <p>Key: bruteforce (gather all candidates), recursive backtracking. This time used {@code
 * boolean[] used} array, because the input can have duplicates so contains check must be applied to
 * index instead.
 *
 * <p>TODO can make various optimisations... but would still be O(n!)
 *
 * @see P46Permutations
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P47Permutations2 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    permuteUnique(result, temp, nums, used);
    return result;
  }

  private void permuteUnique(
      List<List<Integer>> result, List<Integer> temp, int[] nums, boolean[] used) {
    if (temp.size() == nums.length) {
      if (!result.contains(temp)) {
        result.add(new ArrayList<>(temp));
      }
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i]) {
        continue;
      }
      temp.add(nums[i]);
      used[i] = true;
      // dfs
      permuteUnique(result, temp, nums, used);
      // remove last added (backtrack)
      used[i] = false;
      temp.remove(temp.size() - 1);
    }
  }
}
