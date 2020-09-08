package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;

/**
 * <a
 * href=https://leetcode.com/problems/sum-root-to-leaf-numbers>https://leetcode.com/problems/sum-root-to-leaf-numbers/</a>
 *
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P126WordLadder2
 * @see com.wilmol.leetcode.problemset.algorithms.easy.P1022SumOfRootToLeafBinaryNumbers
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
interface P129SumRootToLeafNumbers {

  int sumNumbers(BinaryTreeNode root);

  /**
   * BFS solution.
   *
   * <p>Runtime: O(b<sup>d</sup>) = O(2<sup>lg n</sup>) = O(n) (see <a
   * href=https://en.wikipedia.org/wiki/Breadth-first_search>https://en.wikipedia.org/wiki/Breadth-first_search</a>)
   *
   * <p>Space: O(h * w) (worst case = full tree, have 'width' paths of size 'height' in the queue at
   * same instant)
   *
   * <p>Key: track queue of 'paths' rather than 'nodes'
   */
  class Bfs implements P129SumRootToLeafNumbers {

    @Override
    public int sumNumbers(BinaryTreeNode root) {
      if (root == null) {
        return 0;
      }

      // build all paths, chose bfs here but dfs would also work (have to process every node)

      Queue<List<BinaryTreeNode>> queue = new ArrayDeque<>();
      queue.add(new ArrayList<>(Collections.singletonList(root)));
      int sum = 0;

      while (!queue.isEmpty()) {
        List<BinaryTreeNode> path = queue.remove();
        BinaryTreeNode last = path.get(path.size() - 1);
        if (last.left == null && last.right == null) {
          // No more branching, create the number
          int number = createNumber(path);
          sum += number;
        } else if (last.left != null && last.right != null) {
          // Branches left and right, must create new paths
          queue.add(concat(path, last.left));
          queue.add(concat(path, last.right));
        } else if (last.left != null) {
          // Only branches left
          path.add(last.left);
          queue.add(path);
        } else {
          // Only branches right
          path.add(last.right);
          queue.add(path);
        }
      }
      return sum;
    }

    private int createNumber(List<BinaryTreeNode> path) {
      int number = 0;
      int multiplier = 1;
      for (int i = path.size() - 1; i >= 0; i--) {
        number += path.get(i).val * multiplier;
        multiplier *= 10;
      }
      return number;
    }

    private <T> List<T> concat(List<T> list, T t) {
      ArrayList<T> newList = new ArrayList<>(list);
      newList.add(t);
      return newList;
    }
  }

  /**
   * DFS solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Extra space: O(h)
   *
   * <p>Key: Global variable for total sum, local variable for path sum. Since {@code int} is passed
   * by value don't have to worry about creating new path on branching, as it does it implicitly.
   */
  class Dfs implements P129SumRootToLeafNumbers {

    private int total;

    @Override
    public int sumNumbers(BinaryTreeNode root) {
      total = 0;
      dfs(root, 0);
      return total;
    }

    private void dfs(BinaryTreeNode node, int pathSum) {
      if (node == null) {
        return;
      }
      pathSum = pathSum * 10 + node.val;
      if (node.left == null && node.right == null) {
        total += pathSum;
      } else {
        dfs(node.left, pathSum);
        dfs(node.right, pathSum);
      }
    }
  }
}
