package wilmol.leetcode.problemset.algorithms.medium;

import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-05-20.
 *
 * <p><a
 * href=https://leetcode.com/problems/kth-smallest-element-in-a-bst>https://leetcode.com/problems/kth-smallest-element-in-a-bst/</a>
 *
 * <p>Runtime: O(n) (could reduce to O(k) by short circuit when {@code ans} is set, but worst case k
 * = n anyway)
 *
 * <p>Extra space: O(h)
 *
 * <p>Key: Inorder traversal of BST gets the nodes in order!
 */
class P230KthSmallestElementInABst {

  private int count;
  private int ans;
  private int k;

  public int kthSmallest(BinaryTreeNode root, int k) {
    this.k = k;
    this.count = 0;
    this.ans = -1;
    inorderDfs(root);
    return ans;
  }

  private void inorderDfs(BinaryTreeNode node) {
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
