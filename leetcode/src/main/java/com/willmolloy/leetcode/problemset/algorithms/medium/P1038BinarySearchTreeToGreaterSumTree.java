package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree>https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/</a>
 *
 * <p>Duplicates {@link P538ConvertBstToGreaterTree}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1038BinarySearchTreeToGreaterSumTree {

  public TreeNode bstToGst(TreeNode root) {
    return new P538ConvertBstToGreaterTree().convertBst(root);
  }
}
