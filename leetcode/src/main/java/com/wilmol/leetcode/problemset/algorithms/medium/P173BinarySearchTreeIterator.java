package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wilmol on 2020-04-17.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-search-tree-iterator>https://leetcode.com/problems/binary-search-tree-iterator</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: Stack.
 */
class P173BinarySearchTreeIterator {

  static class BstIterator {
    private final Deque<BinaryTreeNode> stack = new ArrayDeque<>();

    BstIterator(BinaryTreeNode root) {
      // dump left path since that leads to the minimum element (inorder traversal, left first)
      addLeft(root);
    }

    private void addLeft(BinaryTreeNode node) {
      if (node == null) {
        return;
      }
      stack.addLast(node);
      addLeft(node.left);
    }

    int next() {
      BinaryTreeNode minNode = stack.removeLast();
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
