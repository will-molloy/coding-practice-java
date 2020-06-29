package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.function.UnaryOperator;

/**
 * <a
 * href=https://leetcode.com/problems/count-complete-tree-nodes>https://leetcode.com/problems/count-complete-tree-nodes</a>
 *
 * <p>Runtime: O((log(n))<sup>2</sup>)
 *
 * <p>Space: O(log(n))
 *
 * <p>Key: recursive step: can simply add num nodes in left and right subtrees
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P222CountCompleteTreeNodes {

  // precondition:
  // binary tree represented by root is complete

  public int countNodes(BinaryTreeNode root) {
    int leftHeight = height(root, node -> node.left);
    int rightHeight = height(root, node -> node.right);

    if (leftHeight == rightHeight) {
      // full tree: 2^h - 1 nodes
      return pow2(leftHeight) - 1;
    }

    // compute recursively: 1 (this node) + num nodes in left and right subtrees
    return 1 + countNodes(root.left) + countNodes(root.right);
  }

  private int height(BinaryTreeNode node, UnaryOperator<BinaryTreeNode> next) {
    // TODO doesn't this repeat work? I.e. see path 1 -> 2 -> 4, then see path 2 -> 4 again
    int height = 0;
    while (node != null) {
      height += 1;
      node = next.apply(node);
    }
    return height;
  }

  private int pow2(int exponent) {
    return 1 << exponent;
  }
}
