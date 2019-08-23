package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by wilmol on 2019-08-21.
 *
 * <p><a
 * href=https://leetcode.com/problems/combination-sum>https://leetcode.com/problems/combination-sum</a>
 *
 * <p>Runtime: TODO O()
 */
class P39CombinationSum {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Set<List<Integer>> result = new HashSet<>();
    List<Integer> temp = new ArrayList<>();
    return new ArrayList<>(solve(result, temp, candidates, target));
  }

  private Set<List<Integer>> solve(
      Set<List<Integer>> result, List<Integer> temp, int[] candidates, int target) {
    if (target == 0) {
      List<Integer> copy = new ArrayList<>(temp);
      Collections.sort(copy);
      result.add(copy);
    }
    if (target <= 0) {
      return result;
    }

    for (int candidate : candidates) {
      temp.add(candidate);
      solve(result, temp, candidates, target - candidate);
      temp.remove(temp.size() - 1);
    }
    return result;
  }
}
