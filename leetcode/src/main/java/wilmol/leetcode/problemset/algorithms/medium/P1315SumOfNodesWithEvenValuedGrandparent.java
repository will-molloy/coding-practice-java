package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-04-03.
 *
 * <p><a
 * href=https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent>https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: cycle through node -> parent -> grandparent
 *
 * @see wilmol.leetcode.problemset.algorithms.easy.P404SumOfLeftLeaves
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
