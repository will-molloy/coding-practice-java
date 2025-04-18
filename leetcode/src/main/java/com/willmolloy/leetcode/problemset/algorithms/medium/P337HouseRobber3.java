package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
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
 * <p>Key idea: Top down (with memoise) is easier for this one where you're traversing a tree rather
 * than an array.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P198HouseRobber
 * @see P213HouseRobber2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
final class P337HouseRobber3 {

  // dp is valid because solution to subtree is optimal and merging them is optimal (+ overlapping)

  private Map<TreeNode, Integer> dpRob;
  private Map<TreeNode, Integer> dpNotRob;

  public int rob(TreeNode root) {
    dpRob = new IdentityHashMap<>();
    dpNotRob = new IdentityHashMap<>();
    return rob(root, false);
  }

  private int rob(TreeNode current, boolean parentRobbed) {
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
