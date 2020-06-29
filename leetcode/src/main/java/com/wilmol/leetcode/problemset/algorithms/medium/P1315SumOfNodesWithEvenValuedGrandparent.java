package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent>https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: cycle through node -> parent -> grandparent
 *
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P404SumOfLeftLeaves
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1315SumOfNodesWithEvenValuedGrandparent {

  // alternatively, find even valued nodes and sum their grandchildren (this is not as efficient,
  // nor as elegant)

  public int sumEvenGrandparent(BinaryTreeNode root) {
    return sum(root, null, null, 0);
  }

  private int sum(BinaryTreeNode node, BinaryTreeNode parent, BinaryTreeNode grandparent, int sum) {
    if (node == null) {
      // bottomed out
      return sum;
    }
    if (grandparent != null && isEven(grandparent.val)) {
      sum += node.val;
    }
    sum = sum(node.left, node, parent, sum);
    sum = sum(node.right, node, parent, sum);
    return sum;
  }

  private boolean isEven(int i) {
    return i % 2 == 0;
  }
}
