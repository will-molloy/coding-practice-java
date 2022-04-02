package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal>https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/</a>
 *
 * <p>Difficulty: Medium.
 *
 * @see P105ConstructBinaryTreeFromPreorderAndInorderTraversal
 * @see P106ConstructBinaryTreeFromInorderAndPostorderTraversal
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P1008ConstructBinarySearchTreeFromPreorderTraversal {

  BinaryTreeNode bstFromPreorder(int[] preorder);

  /**
   * Recursively splits the array into [node/left subtree/right subtree].
   *
   * <p>Runtime: O(n<sup>2</sup>) (O(n log n) if binary search is used to find left/right
   * transition)
   *
   * <p>Space: O(h)
   *
   * <p>Key: In BST all nodes in left subtree are smaller so can find where right subtree begins by
   * finding first larger node.
   */
  class SplitLeftAndRight implements P1008ConstructBinarySearchTreeFromPreorderTraversal {

    @Override
    public BinaryTreeNode bstFromPreorder(int[] preorder) {
      // preorder is this->left->right
      // in BST all nodes in left are smaller than nodes in right
      // so can determine when left becomes right by finding first node > current node
      return build(preorder, 0, preorder.length - 1);
    }

    // build tree for preorder[l, r]
    private BinaryTreeNode build(int[] preorder, int l, int r) {
      if (r < l) {
        return null;
      }
      int leftStart = l;
      // need this loop so it goes to end of the array if there are no smaller elements
      // (creating a null left subtree node)
      for (; leftStart <= r; leftStart++) {
        if (preorder[leftStart] < preorder[l]) {
          break;
        }
      }
      int rightStart = l;
      for (; rightStart <= r; rightStart++) {
        if (preorder[rightStart] > preorder[l]) {
          break;
        }
      }
      BinaryTreeNode node = new BinaryTreeNode(preorder[l]);
      node.left = build(preorder, leftStart, rightStart - 1);
      node.right = build(preorder, rightStart, r);
      return node;
    }
  }

  /**
   * Provides the {@code build} function the upper bound of the values it can handle. This works
   * similar to the previous solution ({@link SplitLeftAndRight}) except it doesn't repeatedly
   * iterate the array to find the left/right transition.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(h)
   *
   * <p>Key: In BST all nodes in left subtree are smaller, so the upper bound is the current node.
   */
  class ProvideUpperBound implements P1008ConstructBinarySearchTreeFromPreorderTraversal {

    @Override
    public BinaryTreeNode bstFromPreorder(int[] preorder) {
      // using singleton array so index writes are maintained between recursive calls (int ref)
      return build(preorder, new int[] {0}, Integer.MAX_VALUE);
    }

    private BinaryTreeNode build(int[] preorder, int[] i, int maxValue) {
      if (i[0] == preorder.length || preorder[i[0]] > maxValue) {
        return null;
      }
      BinaryTreeNode node = new BinaryTreeNode(preorder[i[0]]);
      i[0]++;
      node.left = build(preorder, i, node.val);
      node.right = build(preorder, i, maxValue);
      return node;
    }
  }
}
