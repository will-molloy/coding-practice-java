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
 */
class P39CombinationSum {

  /**
   * Top down recursive (DFS) solution.
   *
   * <p>Runtime: TODO O(n^t) ???? it has short circuiting... hard to say, definitely does duplicate
   * work, since solutions are equivalent if they are equal when sorted
   */
  static class TopDownRecursive {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      Set<List<Integer>> result = new HashSet<>();
      List<Integer> temp = new ArrayList<>();
      return new ArrayList<>(solve(result, temp, candidates, target));
    }

    // typical 'permutations' (DFS) implementation
    private Set<List<Integer>> solve(
        Set<List<Integer>> result, List<Integer> temp, int[] candidates, int target) {
      if (target == 0) {
        List<Integer> copy = new ArrayList<>(temp);
        Collections.sort(copy);
        result.add(copy);
      }
      if (target <= 0) {
        // early exit
        return result;
      }

      for (int candidate : candidates) {
        temp.add(candidate);
        solve(result, temp, candidates, target - candidate);
        // remove last
        temp.remove(temp.size() - 1);
      }
      return result;
    }
  }

  /**
   * Bottom up iterative (dynamic programming) solution.
   *
   * <p>Runtime: O(nt)
   */
  static class BottomUpIterative {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
      // init results
      List<List<List<Integer>>> results = new ArrayList<>();
      for (int i = 0; i <= target; i++) {
        results.add(new ArrayList<>());
      }
      // base case, summation of empty set is 0, so result(0) = [[]]
      results.get(0).add(new ArrayList<>());

      // Standard DP:
      // outer loop: over the set of numbers
      // inner loop: current number to the limit
      for (int candidate : candidates) {
        for (int thisTarget = candidate; thisTarget <= target; thisTarget++) {
          // append candidate to all existing solutions of 'difference'
          // works since these solutions sum to a previous target (i.e. 'difference')
          // so summing candidate to these solutions yields 'thisTarget'
          // (thisTarget = difference + candidate)
          // E.g. thisTarget = 2, candidate = 2; diff = 0, result(0) = [[]]; append [2] to result(2)
          int difference = thisTarget - candidate;
          for (List<Integer> prevTargetResult : results.get(difference)) {
            List<Integer> newResult = new ArrayList<>(prevTargetResult);
            newResult.add(candidate);
            results.get(thisTarget).add(newResult);
          }
        }
      }
      return results.get(target);
    }
  }
}
