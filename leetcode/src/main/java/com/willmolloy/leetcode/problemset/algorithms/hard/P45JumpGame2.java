package com.willmolloy.leetcode.problemset.algorithms.hard;

/**
 * <a
 * href=https://leetcode.com/problems/jump-game-ii>https://leetcode.com/problems/jump-game-ii/</a>
 *
 * <p>Difficulty: Hard.
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: Maintain range/interval of where we can jump, then greedily jumping as far as we
 * can. This is basically how a BFS/Dijkstra's algorithm would work.
 *
 * @see <a href=https://www.youtube.com/watch?v=0RHXjBKY9EM>Errichto's video</a>
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P55JumpGame
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P1306JumpGame3
 * @see P1345JumpGame4
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P45JumpGame2 {

  public int jump(int[] nums) {
    int n = nums.length;

    // maintain range of where we could have jumped (basically perform a BFS)
    // (initially only first index)
    int start = 0;
    int end = 0;

    int jumps = 0;

    while (end < n - 1) {
      jumps++;
      int newEnd = 0;
      // try jumps from nodes we are able to reach so far (BFS)
      for (int i = start; i <= end; i++) {
        newEnd = Math.max(newEnd, i + nums[i]);
      }
      start = end + 1;
      end = newEnd;
    }
    return jumps;
  }
}
