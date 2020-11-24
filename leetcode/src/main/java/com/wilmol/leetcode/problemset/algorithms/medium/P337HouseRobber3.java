package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.IdentityHashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/house-robber-iii>https://leetcode.com/problems/house-robber-iii/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Top down (with memoise) is easier for this one where you're traversing a tree rather than
 * an array.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P198HouseRobber
 * @see P213HouseRobber2
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
class P337HouseRobber3 {

  // dp is valid because solution to subtree is optimal and merging them is optimal (+ overlapping)

  private Map<BinaryTreeNode, Integer> dpRob;
  private Map<BinaryTreeNode, Integer> dpNotRob;

  public int rob(BinaryTreeNode root) {
    dpRob = new IdentityHashMap<>();
    dpNotRob = new IdentityHashMap<>();
    return rob(root, false);
  }

  private int rob(BinaryTreeNode current, boolean parentRobbed) {
    if (current == null) {
      return 0;
    }
    // choice: rob or notRob
    int rob =
        dpRob.computeIfAbsent(
            current, k -> current.val + rob(current.left, true) + rob(current.right, true));
    int notRob =
        dpNotRob.computeIfAbsent(
            current, k -> rob(current.left, false) + rob(current.right, false));

    if (parentRobbed) {
      // parent robbed, can't rob this one as it's adjacent
      return notRob;
    } else {
      return Math.max(rob, notRob);
    }
  }
}
