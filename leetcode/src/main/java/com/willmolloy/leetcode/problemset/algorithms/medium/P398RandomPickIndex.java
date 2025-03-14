package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/random-pick-index>https://leetcode.com/problems/random-pick-index/</a>
 *
 * <p>Extra space: O(n)
 *
 * <p>Key idea: Store indices by num in map for O(1) lookup.
 *
 * @see P380InsertDeleteGetRandomO1
 * @see P497RandomPointInNonOverlappingRectangles
 * @see P528RandomPickWithWeight
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P398RandomPickIndex {

  /** Solution. */
  static class Solution {

    private final Map<Integer, List<Integer>> numIndices = new HashMap<>();

    // O(n)
    Solution(int[] nums) {
      for (int i = 0; i < nums.length; i++) {
        numIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
      }
    }

    // O(1)
    public int pick(int target) {
      List<Integer> indices = numIndices.get(target);
      int bound = indices.size();
      int rand = ThreadLocalRandom.current().nextInt(bound);
      return indices.get(rand);
    }
  }
}
