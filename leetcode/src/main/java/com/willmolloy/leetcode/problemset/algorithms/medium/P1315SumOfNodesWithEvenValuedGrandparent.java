package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent>https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: cycle through node -> parent -> grandparent
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P404SumOfLeftLeaves
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1315SumOfNodesWithEvenValuedGrandparent {

  // alternatively, find even valued nodes and sum their grandchildren (this is not as efficient,
  // nor as elegant)

  public int sumEvenGrandparent(TreeNode root) {
    return sum(root, null, null, 0);
  }

  private int sum(TreeNode node, TreeNode parent, TreeNode grandparent, int sum) {
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
