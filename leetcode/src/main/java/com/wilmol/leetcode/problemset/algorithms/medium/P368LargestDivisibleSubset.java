package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by wilmol on 2020-06-14.
 *
 * <p><a
 * href=https://leetcode.com/problems/largest-divisible-subset>https://leetcode.com/problems/largest-divisible-subset/</a>
 *
 * <p>Runtime: O(n<sup>2</sup>)
 *
 * <p>Extra space: O(n<sup>2</sup>)
 *
 * <p>Key: Only need to test divisibility with largest element in subset.
 *
 * @see P300LongestIncreasingSubsequence
 */
class P368LargestDivisibleSubset {

  public List<Integer> largestDivisibleSubset(int[] nums) {
    int n = nums.length;

    // sort so we can apply the longest increasing subsequence solution
    // i.e. when building subsets, want to compare all smaller elements with current element
    Arrays.sort(nums);

    List<List<Integer>> subsets = new ArrayList<>();

    // find largest subset ending with each nums[i]
    for (int i = 0; i < n; i++) {
      subsets.add(new ArrayList<>());
      List<Integer> largestSubset = subsets.get(i);
      // search all nums[j] < nums[i]
      for (int j = 0; j < i; j++) {
        // only need to compare with last (largest) element in subset, because if it is a multiple
        // the other (smaller) elements must also be multiples
        if (nums[i] % nums[j] == 0) {
          // find largest subset ending with some nums[j] (with nums[i] as a multiple)
          if (largestSubset.size() < subsets.get(j).size()) {
            largestSubset = subsets.get(j);
          }
        }
      }
      // extend largest subset ending with some nums[j] (with nums[i] as a multiple) with nums[i]
      subsets.get(i).addAll(largestSubset);
      // (add nums[i] here, after, because largestSubset gets reassigned)
      subsets.get(i).add(nums[i]);
    }

    // return largest subset overall
    return subsets.stream().max(Comparator.comparing(List::size)).orElse(Collections.emptyList());
  }
}
