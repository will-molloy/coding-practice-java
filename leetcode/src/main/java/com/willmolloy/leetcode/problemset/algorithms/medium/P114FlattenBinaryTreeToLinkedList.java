package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a
 * href=https://leetcode.com/problems/flatten-binary-tree-to-linked-list>https://leetcode.com/problems/flatten-binary-tree-to-linked-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(h)
 *
 * <p>Key: binary tree traversal, pointer manipulation, stack to track most recent right node
 *
 * @see P430FlattenAMultilevelDoublyLinkedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P114FlattenBinaryTreeToLinkedList {

  // TODO some smarter answers on leetcode.com ("reversed pre-order traversal")

  public void flatten(TreeNode root) {
    if (root == null) {
      return;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();

    flatten(root, stack);
  }

  private void flatten(TreeNode node, Deque<TreeNode> stack) {
    if (node.left == null && node.right == null && stack.isEmpty()) {
      // no children, no stack
      // nothing left to process
      return;
    } else if (node.left == null && node.right == null && !stack.isEmpty()) {
      // no children
      // process stack contents
      TreeNode next = stack.removeFirst();
      flatten(next, stack);
      node.right = next;
    } else if (node.left != null && node.right == null) {
      // only left child
      // flatten left tree and set as right tree
      TreeNode next = node.left;
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
      TreeNode next = node.left;
      flatten(next, stack);
      node.right = next;
      node.left = null;
    }
  }
}
