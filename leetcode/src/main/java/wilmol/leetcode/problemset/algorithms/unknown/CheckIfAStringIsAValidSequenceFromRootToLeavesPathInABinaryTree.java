package wilmol.leetcode.problemset.algorithms.unknown;

// TODO categorise and change link when leetcode adds this as an official problem

import java.util.ArrayDeque;
import java.util.Queue;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-05-01.
 *
 * <p><a
 * href=https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315>https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/532/week-5/3315/</a>
 *
 * <p>TODO Difficulty: Medium?
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: Checking for {@code level < n - 1} in the loop condition so it leaves nodes in the queue
 * so can check if they're leaves afterwards. This works because we add nodes for the current level
 * we are processing rather than incrementing {@code level} after adding to the queue. Also avoids
 * need to check {@code level < n} (i.e. index safety) within the loop.
 */
class CheckIfAStringIsAValidSequenceFromRootToLeavesPathInABinaryTree {

  public boolean isValidSequence(BinaryTreeNode root, int[] arr) {
    int n = arr.length;
    if (n == 1) {
      return root.val == arr[0] && root.left == null && root.right == null;
    }

    // run BFS, each level traverse nodes which match arr[level] until level = n - 1
    Queue<BinaryTreeNode> queue = new ArrayDeque<>();
    int level = 0;
    if (arr[level] == root.val) {
      queue.add(root);
    }

    while (!queue.isEmpty() && level < n - 1) {
      level++;
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode node = queue.remove();
        if (node.left != null && node.left.val == arr[level]) {
          queue.add(node.left);
        }
        if (node.right != null && node.right.val == arr[level]) {
          queue.add(node.right);
        }
      }
    }

    // check reached end and ended with leaf
    return level == n - 1
        && queue.stream().anyMatch(node -> node.left == null && node.right == null);
  }
}
