package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wilmol on 2020-02-07.
 *
 * <p><a href=https://leetcode.com/problems/subsets-ii>https://leetcode.com/problems/subsets-ii</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Space: O(2<sup>n</sup>)
 *
 * <p>Key: Set to implicitly filter dupes
 *
 * @see P78Subsets
 */
class P90Subsets2 {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    // cheaper to sort input rather than every subset generated?
    // below generation method guarantees duplicates will be detected without the need of (inner)
    // Sets if input is sorted
    Arrays.sort(nums);

    // standard power set generation, except use (outer) Set to implicitly filter duplicate subsets
    Set<List<Integer>> subsets = new HashSet<>();
    subsets.add(Collections.emptyList());

    for (int num : nums) {
      // best way to avoid CME ??? No way to get elements via. index like in P78
      Set<List<Integer>> newSubsets = new HashSet<>();
      for (List<Integer> subset : subsets) {
        List<Integer> newSubset = new ArrayList<>(subset);
        newSubset.add(num);
        newSubsets.add(newSubset);
      }
      subsets.addAll(newSubsets);
    }

    return new ArrayList<>(subsets);
  }
}
