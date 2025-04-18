package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/binary-search-tree-iterator>https://leetcode.com/problems/binary-search-tree-iterator</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: Stack.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P173BinarySearchTreeIterator {

  /** BstIterator. */
  static final class BstIterator {
    private final Deque<TreeNode> stack = new ArrayDeque<>();

    BstIterator(TreeNode root) {
      // dump left path since that leads to the minimum element (inorder traversal, left first)
      addLeft(root);
    }

    private void addLeft(TreeNode node) {
      if (node == null) {
        return;
      }
      stack.addLast(node);
      addLeft(node.left);
    }

    int next() {
      TreeNode minNode = stack.removeLast();
      // now that we have processed the left node (and now this node)
      // we can process the right node, put it on top of the stack
      // i.e. inorder traversal left -> this -> right
      addLeft(minNode.right);
      return minNode.val;
    }

    boolean hasNext() {
      return !stack.isEmpty();
    }
  }
}
