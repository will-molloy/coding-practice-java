package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wilmol on 2019-12-01.
 *
 * <p>Input doesn't have duplicates.
 *
 * <p><a
 * href=https://leetcode.com/problems/permutations>https://leetcode.com/problems/permutations</a>
 *
 * <p>Runtime: O(n!), Space: O(n!)
 *
 * <p>Key: bruteforce (gather all candidates), recursive backtracking
 *
 * @see P47Permutations2
 */
class P46Permutations {

  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    permute(result, temp, nums);
    return result;
  }

  // temp (call stack size)[state]:
  // (1)[1] -> (2)[1,2], -> (3)[1,2,3] -> (3)[1,2] -> (2)[1] -> (2)[1,3] -> (3)[1,3,2] etc.
  // So E.g. first add '2' after '1' (2nd state above), then next time will add '3' (6th state)

  private void permute(List<List<Integer>> result, List<Integer> temp, int[] nums) {
    if (temp.size() == nums.length) {
      // add a copy of temp, want to keep current contents for backtracking
      result.add(new ArrayList<>(temp));
      // (optimisation) return here because the loop won't do anything
      return;
    }

    for (int num : nums) {
      // TODO can optimise O(n) contains here by using boolean array or Set, or specify start
      // index
      if (temp.contains(num)) {
        continue;
      }
      temp.add(num);
      // dfs
      permute(result, temp, nums);
      // remove most recently added (backtrack)
      temp.remove(temp.size() - 1);
    }
  }
}
