package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal>https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(h) - excluding {@code flipped}
 *
 * <p>Key idea: Perform the pre-order traversal and:
 *
 * <ol>
 *   <li>Test the current node - if it doesn't match {@code voyage[i]} return [-1]
 *   <li>Test the next node - if it doesn't match {@code voyage[i]} our only choice is to flip the
 *       current node
 * </ol>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P971FlipBinaryTreeToMatchPreorderTraversal {

  private List<Integer> flipped;
  private int i;

  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    flipped = new ArrayList<>();
    i = 0;

    dfs(root, voyage);

    if (!flipped.isEmpty() && flipped.getFirst().equals(-1)) {
      // if any node set 'flipped' to [-1] then we must return [-1] overall
      return List.of(-1);
    }
    return flipped;
  }

  // dfs - pre-order traversal
  private void dfs(TreeNode node, int[] voyage) {
    if (node == null) {
      return;
    }

    // test current node
    if (node.val != voyage[i]) {
      // current node does not match the expected voyage, return [-1]
      flipped = new ArrayList<>(List.of(-1));
      return;
    }
    i++;

    // test next node
    if (i < voyage.length && node.left != null && node.left.val != voyage[i]) {
      // next node (node.left) does not match the expected voyage
      // only choice we have is to flip the current node
      // next node (now node.right) will be tested as the current node in the next recursive call
      flipped.add(node.val);
      dfs(node.right, voyage);
      dfs(node.left, voyage);
    } else {
      // next node does match the expected voyage
      // continue the pre-order traversal
      dfs(node.left, voyage);
      dfs(node.right, voyage);
    }
  }
}
