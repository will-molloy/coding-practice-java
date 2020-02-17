package wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/minimum-depth-of-binary-tree>https://leetcode.com/problems/minimum-depth-of-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(w)
 *
 * <p>Key: a leaf is a node with no children
 */
class P111MinimumDepthOfBinaryTree {

  public int minDepth(BinaryTreeNode root) {
    if (root == null) {
      return 0;
    }
    // BFS, find first leaf
    Queue<BinaryTreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    int minDepth = 1;
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode node = queue.remove();
        if (node.left == null && node.right == null) {
          // node has no children, therefore leaf
          return minDepth;
        }
        Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(queue::add);
      }
      minDepth++;
    }
    return minDepth;
  }
}
