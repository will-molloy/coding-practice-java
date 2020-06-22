package com.wilmol.leetcode.problemset.algorithms.medium;

/**
 * Created by wilmol on 2019-11-03.
 *
 * <p><a href=https://leetcode.com/problems/jump-game>https://leetcode.com/problems/jump-game</a>
 *
 * <p>Key: greedy algorithm; if you can reach beyond something then you can reach that thing.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P45JumpGame2
 * @see P1306JumpGame3
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P1345JumpGame4
 */
interface P55JumpGame {

  boolean canJump(int[] nums);

  /**
   * Backtracking solution. Backtrack on each zero and check if it can be passed.
   *
   * <p>Runtime: TODO greater than O(n)... There is backtracking. Really it's a graph, the 'jumps'
   * can be thought of as edges. So something to do with avg number of nodes without edges (i.e.
   * zeros).
   */
  class BackTracking implements P55JumpGame {

    public boolean canJump(int[] nums) {
      // just find the zeros and check if they can be passed
      // (don't need to process last element, truth condition has been reached)

      for (int i = 0; i < nums.length - 1; i++) {
        if (nums[i] == 0) {
          // found a zero
          // check if there exists any element which can pass the zero
          boolean canPass = false;
          for (int distFromZero = 1; distFromZero <= i; distFromZero++) {
            if (nums[i - distFromZero] > distFromZero) {
              // can pass if possible to jump beyond the zero
              canPass = true;
              break;
            }
          }
          if (!canPass) {
            return false;
          }
        }
      }
      return true;
    }
  }

  /**
   * Greedy solution. Take largest possible jump each iteration.
   *
   * <p>Runtime: O(n)
   */
  class Greedy implements P55JumpGame {

    public boolean canJump(int[] nums) {
      int maxPos = 0;
      for (int i = 0; i < nums.length; i++) {
        if (i > maxPos) {
          // couldn't reach i, therefore can't continue
          break;
        }
        maxPos = Math.max(maxPos, i + nums[i]);
      }
      // check if the end could be reached
      return maxPos >= nums.length - 1;
    }
  }
}
