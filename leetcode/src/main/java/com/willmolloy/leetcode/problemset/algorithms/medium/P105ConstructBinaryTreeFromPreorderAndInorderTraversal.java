package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal>https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal</a>
 *
 * <p>Runtime: O(n lgn) (recurrence T(n) = 2T(n/2 - 1) + O(n))
 *
 * <p>Space: O(h)
 *
 * <p>Key idea: the size of the left/right subtree ranges are the same in each array, since each
 * array is for the same tree
 *
 * @see P106ConstructBinaryTreeFromInorderAndPostorderTraversal
 * @see P1008ConstructBinarySearchTreeFromPreorderTraversal
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {

  // can assume no duplicate keys in the tree

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return buildTree(asList(preorder), asList(inorder));
  }

  private TreeNode buildTree(List<Integer> preorder, List<Integer> inorder) {
    if (preorder.isEmpty()) {
      return null;
    }
    // root of tree is head of preorder seq
    TreeNode root = new TreeNode(preorder.getFirst());
    if (preorder.size() == 1) {
      return root;
    }
    // find location of root in inorder seq
    int i;
    for (i = 0; i < inorder.size(); i++) {
      // only works because no duplicates exist
      if (Objects.equals(preorder.getFirst(), inorder.get(i))) {
        break;
      }
    }
    // elements in left subtree are left of root in inorder seq
    // elements in right subtree are right of root in inorder seq
    // take same size range for preorder seq
    // (in: left-node-right, pre: node-left-right)
    List<Integer> inorderLeft = inorder.subList(0, i);
    List<Integer> preorderLeft = preorder.subList(1, i + 1);
    List<Integer> inorderRight = inorder.subList(i + 1, inorder.size());
    List<Integer> preorderRight = preorder.subList(i + 1, preorder.size());
    // recursively build
    root.left = buildTree(preorderLeft, inorderLeft);
    root.right = buildTree(preorderRight, inorderRight);
    return root;
  }

  private static List<Integer> asList(int[] a) {
    return Arrays.stream(a).boxed().collect(Collectors.toList());
  }
}
