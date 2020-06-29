package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href=https://leetcode.com/problems/subsets>https://leetcode.com/problems/subsets</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Space: O(2<sup>n</sup>)
 *
 * <p>Key: iteratively building up result set. Caching size variable so only work on previous
 * 'state' helped.
 *
 * @see P90Subsets2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P78Subsets {

  // nums is distinct, basically Set<Integer>
  public List<List<Integer>> subsets(int[] nums) {

    List<List<Integer>> result = new ArrayList<>();
    // seed with empty set
    result.add(Collections.emptyList());

    // iteratively add each 'num' to the result set
    // e.g. nums = [1,2,3]
    // iteration0: [[]]
    // iteration1: [[], [1]]
    // iteration2: [[], [1], [2], [1,2]]
    // iteration3: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]

    for (int num : nums) {
      // cache size, so only add 'num' to the previous iteration's state of 'result'
      int size = result.size();
      for (int i = 0; i < size; i++) {
        List<Integer> prevSet = new ArrayList<>(result.get(i));
        prevSet.add(num);
        result.add(prevSet);
      }
    }

    return result;
  }
}
