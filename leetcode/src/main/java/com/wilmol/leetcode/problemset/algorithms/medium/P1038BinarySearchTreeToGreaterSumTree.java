package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree>https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/</a>
 *
 * <p>Duplicates {@link P538ConvertBstToGreaterTree}.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1038BinarySearchTreeToGreaterSumTree {

  public BinaryTreeNode bstToGst(BinaryTreeNode root) {
    return new P538ConvertBstToGreaterTree().convertBst(root);
  }
}
