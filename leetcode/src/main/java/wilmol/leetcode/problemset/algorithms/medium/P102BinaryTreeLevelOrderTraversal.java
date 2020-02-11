package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-level-order-traversal>https://leetcode.com/problems/binary-tree-level-order-traversal</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(log n) best case, O(n) worst case (recursion stack size)
 *
 * <p>Key: recursion, knowledge of BT traversal
 */
class P102BinaryTreeLevelOrderTraversal {

  public List<List<Integer>> levelOrder(BinaryTreeNode root) {
    return levelOrder(new ArrayList<>(), root, 0);
  }

  public List<List<Integer>> levelOrder(
      List<List<Integer>> levels, BinaryTreeNode node, int depth) {
    if (node == null) {
      return levels;
    }

    if (!(levels.size() > depth)) {
      levels.add(new ArrayList<>());
    }
    levels.get(depth).add(node.val);

    levelOrder(levels, node.left, depth + 1);
    levelOrder(levels, node.right, depth + 1);
    return levels;
  }
}
