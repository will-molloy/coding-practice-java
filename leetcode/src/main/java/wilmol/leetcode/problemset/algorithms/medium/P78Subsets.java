package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by wilmol on 2020-01-21.
 *
 * <p><a href=https://leetcode.com/problems/subsets>https://leetcode.com/problems/subsets</a>
 *
 * <p>Runtime: O(2<sup>n</sup>)
 *
 * <p>Space: O(2<sup>n</sup>)
 *
 * <p>TODO Key:
 */
class P78Subsets {

  // nums is distinct, basically Set<Integer>
  public List<List<Integer>> subsets(int[] nums) {

    // TODO correct but inefficient!
    //  Don't need to foreach all the results, rather only the ones added in previous iteration

    Set<Set<Integer>> result = new HashSet<>();
    result.add(new HashSet<>());

    for (int i = 0; i < nums.length; i++) {

      // avoid CME
      Set<Set<Integer>> resultCopy = new HashSet<>(result);
      for (Set<Integer> set : resultCopy) {
        for (int num : nums) {
          Set<Integer> newSet = new HashSet<>(set);
          newSet.add(num);
          result.add(newSet);
        }
      }
    }

    return result.stream().map(ArrayList::new).collect(Collectors.toList());
  }
}
