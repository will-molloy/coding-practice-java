package wilmol.leetcode.problemset.algorithms.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wilmol on 2020-04-27.
 *
 * <p><a
 * href=https://leetcode.com/problems/jump-game-iii>https://leetcode.com/problems/jump-game-iii/</a>
 *
 * <p>Difficulty: Medium.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: {@code Set seen} to detect and avoid cycles (stack overflows) in the DFS.
 *
 * @see P55JumpGame
 * @see wilmol.leetcode.problemset.algorithms.hard.P45JumpGame2
 * @see wilmol.leetcode.problemset.algorithms.hard.P1345JumpGame4
 */
class P1306JumpGame3 {

  public boolean canReach(int[] arr, int start) {
    return canReach(arr, start, new HashSet<>());
  }

  // DFS
  private boolean canReach(int[] arr, int i, Set<Integer> seen) {
    int n = arr.length;
    if (i < 0 || i >= n || !seen.add(i)) {
      return false;
    }
    if (arr[i] == 0) {
      return true;
    }
    return canReach(arr, i + arr[i], seen) || canReach(arr, i - arr[i], seen);
  }
}
