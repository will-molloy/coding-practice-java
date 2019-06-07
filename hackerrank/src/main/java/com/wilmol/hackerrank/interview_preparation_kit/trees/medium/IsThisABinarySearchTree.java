package com.wilmol.hackerrank.interview_preparation_kit.trees.medium;

import com.wilmol.hackerrank.common.BinaryTreeNode;

/**
 * Created by Will on 24/03/2019
 * <p>
 * https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=trees
 * <p>
 * Runtime: O(n) - must check all nodes
 */
class IsThisABinarySearchTree
{

  static boolean checkBST(BinaryTreeNode root)
  {
    return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  private static boolean checkBST(BinaryTreeNode node, int minValue, int maxValue)
  {
    return node == null
        || node.data >= minValue && node.data <= maxValue
            && checkBST(node.left, minValue, node.data - 1)
            && checkBST(node.right, node.data + 1, maxValue);
  }

}
