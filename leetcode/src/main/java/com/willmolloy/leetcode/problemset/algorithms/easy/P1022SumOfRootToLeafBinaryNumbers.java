package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers>https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key idea: Extend path by multiplying by 2 (the base), this way can build number starting from
 * MSB.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P129SumRootToLeafNumbers
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1022SumOfRootToLeafBinaryNumbers {

  private int totalSum;

  public int sumRootToLeaf(TreeNode root) {
    totalSum = 0;
    dfs(root, 0);
    return totalSum;
  }

  private void dfs(TreeNode root, int pathSum) {
    if (root == null) {
      return;
    }
    pathSum *= 2;
    pathSum += root.val;
    if (root.left == null && root.right == null) {
      totalSum += pathSum;
    }
    dfs(root.left, pathSum);
    dfs(root.right, pathSum);
  }
}
