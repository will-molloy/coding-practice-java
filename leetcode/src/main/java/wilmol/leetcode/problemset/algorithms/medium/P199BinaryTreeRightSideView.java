package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-06-16.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-right-side-view>https://leetcode.com/problems/binary-tree-right-side-view/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Take right most node in each level.
 */
class P199BinaryTreeRightSideView {

  public List<Integer> rightSideView(BinaryTreeNode root) {
    if (root == null) {
      return Collections.emptyList();
    }

    List<Integer> result = new ArrayList<>();

    // BFS
    Queue<BinaryTreeNode> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        BinaryTreeNode node = queue.remove();
        if (i == levelSize - 1) {
          // take right most node in level
          result.add(node.val);
        }
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
    }
    return result;
  }
}
