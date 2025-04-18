package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/kth-smallest-element-in-a-bst>https://leetcode.com/problems/kth-smallest-element-in-a-bst/</a>
 *
 * <p>Runtime: O(n) (could reduce to O(k) by short circuit when {@code ans} is set, but worst case k
 * = n anyway)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key idea: Inorder traversal of BST gets the nodes in order!
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P230KthSmallestElementInABst {

  private int count;
  private int ans;
  private int k;

  public int kthSmallest(TreeNode root, int k) {
    this.k = k;
    this.count = 0;
    this.ans = -1;
    inorderDfs(root);
    return ans;
  }

  private void inorderDfs(TreeNode node) {
    if (node == null) {
      return;
    }
    inorderDfs(node.left);
    count++;
    if (count == k) {
      ans = node.val;
    }
    inorderDfs(node.right);
  }
}
