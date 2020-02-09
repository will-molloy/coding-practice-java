package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-02-09.
 *
 * <p><a
 * href=https://leetcode.com/problems/binary-tree-inorder-traversal>https://leetcode.com/problems/binary-tree-inorder-traversal</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: recursion to traverse depth first
 */
class P94BinaryTreeInorderTraversal {

  // iterative solutions (stack and more space efficient 'morris' traversal):
  // https://leetcode.com/problems/binary-tree-inorder-traversal/solution/

  // on leetcode its called 'TreeNode', fields may differ too...

  public List<Integer> inorderTraversal(BinaryTreeNode root) {
    List<Integer> traversal = new ArrayList<>();
    inorderTraversal(traversal, root);
    return traversal;
  }

  private void inorderTraversal(List<Integer> traversal, BinaryTreeNode root) {
    if (root == null) {
      return;
    }
    inorderTraversal(traversal, root.left);
    traversal.add(root.val);
    inorderTraversal(traversal, root.right);
  }
}
