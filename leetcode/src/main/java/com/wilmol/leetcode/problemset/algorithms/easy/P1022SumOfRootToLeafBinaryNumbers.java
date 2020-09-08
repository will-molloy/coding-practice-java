package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers>https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: Extend path by multiplying by 2 (the base), this way can build number starting from MSB.
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P129SumRootToLeafNumbers
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1022SumOfRootToLeafBinaryNumbers {

  private int totalSum;

  public int sumRootToLeaf(BinaryTreeNode root) {
    totalSum = 0;
    dfs(root, 0);
    return totalSum;
  }

  private void dfs(BinaryTreeNode root, int pathSum) {
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
