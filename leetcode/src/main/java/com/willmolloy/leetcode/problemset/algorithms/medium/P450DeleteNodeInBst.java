package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/delete-node-in-a-bst>https://leetcode.com/problems/delete-node-in-a-bst/</a>
 *
 * <p>Runtime: O(h)
 *
 * <p>Extra memory: O(h)
 *
 * <p>Key: When both children exist promote the successor.
 *
 * @see com.willmolloy.dsa.trees.TreeDeleteImpl
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P450DeleteNodeInBst {

  public BinaryTreeNode deleteNode(BinaryTreeNode root, int key) {
    if (root == null) {
      return null;
    }

    if (key < root.val) {
      // node to delete in left subtree
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      // node to delete in right subtree
      root.right = deleteNode(root.right, key);
    } else {
      // found node to delete (root.val == key)
      if (root.left == null) {
        // no left subtree, can just promote right subtree
        return root.right;
      } else if (root.right == null) {
        // no right subtree, can just promote left subtree
        return root.left;
      } else {
        // left and right subtrees exist

        // find successor
        // since right subtree exists successor is simply smallest node in right subtree
        BinaryTreeNode successor = min(root.right);

        // promote successor by overriding node to deletes value with its value
        root.val = successor.val;
        // delete old, now duplicate, successor
        root.right = deleteNode(root.right, successor.val);

        // TODO there is a way to promote successor without rewriting TreeNode.val using
        //  'transplant' procedure, but that is a bit more involved, need to track node parents etc)
      }
    }
    return root;
  }

  private BinaryTreeNode min(BinaryTreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
}
