package wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-03-30.
 *
 * <p><a
 * href=https://leetcode.com/problems/range-sum-of-bst>https://leetcode.com/problems/range-sum-of-bst</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: binary tree traversal
 */
class P938RangeSumOfBst {

  public int rangeSumBst(BinaryTreeNode root, int l, int r) {
    // traverse the tree somehow, chose BFS here

    Queue<BinaryTreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int sum = 0;

    while (!queue.isEmpty()) {
      BinaryTreeNode node = queue.remove();
      if (node.val >= l && node.val <= r) {
        sum += node.val;
      }
      Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(queue::add);
    }

    return sum;
  }
}
