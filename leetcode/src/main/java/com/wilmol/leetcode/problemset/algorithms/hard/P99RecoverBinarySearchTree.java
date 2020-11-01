package com.wilmol.leetcode.problemset.algorithms.hard;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/recover-binary-search-tree>https://leetcode.com/problems/recover-binary-search-tree/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h) TODO O(1) which is asked as followup and is why question is 'hard'
 *
 * <p>Key: Inorder traversal. Keep track of previous node.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P99RecoverBinarySearchTree {

  public void recoverTree(BinaryTreeNode root) {
    inorder(root);

    // swap the two (exactly two nodes were swapped)
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
  }

  // first node in swap
  private BinaryTreeNode first;
  // second node in swap
  private BinaryTreeNode second;
  // will track previous node in inorder traversal state, initially INT_MIN
  private BinaryTreeNode prev = new BinaryTreeNode(Integer.MIN_VALUE);

  // inorder is traversing the BST in sorted order
  // think of it like going left to right on sorted list
  private void inorder(BinaryTreeNode node) {
    if (node == null) {
      return;
    }

    inorder(node.left);

    // compare previous node (left) and current node (right)
    // if sorted it would be: prev <= node
    if (prev.val > node.val) {
      if (first == null) {
        // first swap is previous node (larger on left which should be on right)
        first = prev;
      }
      // second swap is current node (smaller on right which should be on left)
      second = node;
    }
    prev = node;

    inorder(node.right);
  }
}
