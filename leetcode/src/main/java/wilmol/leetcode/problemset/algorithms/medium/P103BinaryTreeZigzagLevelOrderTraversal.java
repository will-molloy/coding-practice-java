package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-11.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal>https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(w) = O(n)
 *
 * <p>Key: double ended queue, reversing logic when traversing level in reverse order
 *
 * <p>Notes: call {@code addLast} at end of an iteration, then next iteration {@code removeLast} is
 * the first call (and vice versa with {@code addFirst}/{@code removeFirst}); hence get a 'FIFO'
 * ordering between levels but without reaching depth.
 *
 * @see P102BinaryTreeLevelOrderTraversal
 */
class P103BinaryTreeZigzagLevelOrderTraversal {

  // alternatively use standard level order and insert into back/front of 'level' list depending on
  // forward/reverse
  // but that isn't really a true zigzag traversal (want the node encounter order to be zigzagging)

  public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
    List<List<Integer>> levels = new ArrayList<>();
    if (root == null) {
      return levels;
    }

    // BFS
    Deque<BinaryTreeNode> deque = new ArrayDeque<>();
    deque.addLast(root);
    boolean forward = true;

    while (!deque.isEmpty()) {

      List<Integer> level = new ArrayList<>();
      // cache size since we'll be adding the next level's nodes to the deque
      int levelSize = deque.size();

      for (int i = 0; i < levelSize; i++) {
        if (forward) {
          // standard level order
          // remove from front of queue
          BinaryTreeNode node = deque.removeFirst();
          level.add(node.val);
          // add to back of queue; left node first
          // (want to receive right node first on next iteration)
          if (node.left != null) {
            deque.addLast(node.left);
          }
          if (node.right != null) {
            deque.addLast(node.right);
          }
        } else {
          // reverse level order
          // remove from back of queue
          BinaryTreeNode node = deque.removeLast();
          level.add(node.val);
          // add to front of queue; right node first
          // (want to receive left node first on next iteration)
          if (node.right != null) {
            deque.addFirst(node.right);
          }
          if (node.left != null) {
            deque.addFirst(node.left);
          }
        }
      }

      levels.add(level);
      forward = !forward;
    }
    return levels;
  }
}
