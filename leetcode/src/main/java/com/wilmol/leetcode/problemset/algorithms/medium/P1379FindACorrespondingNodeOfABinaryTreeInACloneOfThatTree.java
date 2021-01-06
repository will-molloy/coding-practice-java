package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree>https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: Traverse the trees in lockstep, when original is target, cloned node must be the answer.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1379FindACorrespondingNodeOfABinaryTreeInACloneOfThatTree {

  private BinaryTreeNode ans;

  public BinaryTreeNode getTargetCopy(
      BinaryTreeNode original, BinaryTreeNode cloned, BinaryTreeNode target) {
    dfs(original, cloned, target);
    return ans;
  }

  private void dfs(BinaryTreeNode original, BinaryTreeNode cloned, BinaryTreeNode target) {
    if (original == null) {
      return;
    }
    if (original == target) {
      ans = cloned;
    }
    dfs(original.left, cloned.left, target);
    dfs(original.right, cloned.right, target);
  }
}
