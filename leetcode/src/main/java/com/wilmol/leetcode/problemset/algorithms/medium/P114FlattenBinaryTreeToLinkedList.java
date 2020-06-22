package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wilmol on 2020-02-22.
 *
 * <p><a
 * href=https://leetcode.com/problems/flatten-binary-tree-to-linked-list>https://leetcode.com/problems/flatten-binary-tree-to-linked-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: binary tree traversal, pointer manipulation, stack to track most recent right node
 *
 * @see P430FlattenAMultilevelDoublyLinkedList
 */
class P114FlattenBinaryTreeToLinkedList {

  // TODO some smarter answers on leetcode.com ("reversed pre-order traversal")

  public void flatten(BinaryTreeNode root) {
    if (root == null) {
      return;
    }
    Deque<BinaryTreeNode> stack = new ArrayDeque<>();

    flatten(root, stack);
  }

  private void flatten(BinaryTreeNode node, Deque<BinaryTreeNode> stack) {
    if (node.left == null && node.right == null && stack.isEmpty()) {
      // no children, no stack
      // nothing left to process
      return;
    } else if (node.left == null && node.right == null && !stack.isEmpty()) {
      // no children
      // process stack contents
      BinaryTreeNode next = stack.removeFirst();
      flatten(next, stack);
      node.right = next;
    } else if (node.left != null && node.right == null) {
      // only left child
      // flatten left tree and set as right tree
      BinaryTreeNode next = node.left;
      flatten(next, stack);
      node.right = next;
      node.left = null;
    } else if (node.left == null && node.right != null) {
      // only right child
      // flatten right tree
      flatten(node.right, stack);
    } else if (node.left != null && node.right != null) {
      // have both left and right child
      // store right in stack
      stack.addFirst(node.right);
      // flatten left tree and set as right tree
      BinaryTreeNode next = node.left;
      flatten(next, stack);
      node.right = next;
      node.left = null;
    }
  }
}
