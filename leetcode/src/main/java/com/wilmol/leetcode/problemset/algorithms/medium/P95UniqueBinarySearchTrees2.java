package com.wilmol.leetcode.problemset.algorithms.medium;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/unique-binary-search-trees-ii>https://leetcode.com/problems/unique-binary-search-trees-ii</a>
 *
 * <p>Runtime: O(n<sup>log n</sup>) (recurrence: T(n) = SUMi(0 to n-1)T(i)+T(n-i-1))
 *
 * <p>Space: O(n) (recursion depth)
 *
 * <p>Key: returning singleton null node when end < start
 *
 * @see P96UniqueBinarySearchTrees
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P95UniqueBinarySearchTrees2 {

  public List<BinaryTreeNode> generateTrees(int n) {
    if (n == 0) {
      return Collections.emptyList();
    }
    return trees(1, n);
  }

  private List<BinaryTreeNode> trees(int start, int end) {
    if (end < start) {
      // need null node, so empty tree is paired with non-empty tree, otherwise non-empty tree is
      // ignored because (if returning empty list) the size would be 0
      return Collections.singletonList(null);
    }
    if (start == end) {
      return Collections.singletonList(new BinaryTreeNode(start));
    }

    ArrayList<BinaryTreeNode> trees = new ArrayList<>();
    // try every node as root
    for (int i = start; i <= end; i++) {
      // recursively build subtrees
      List<BinaryTreeNode> leftTrees = trees(start, i - 1);
      List<BinaryTreeNode> rightTrees = trees(i + 1, end);
      // pair every left tree with every right tree (cartesian product)
      for (BinaryTreeNode leftTree : leftTrees) {
        for (BinaryTreeNode rightTree : rightTrees) {
          // now construct root, so avoids need to copy trees
          BinaryTreeNode root = new BinaryTreeNode(i);
          root.left = leftTree;
          root.right = rightTree;
          trees.add(root);
        }
      }
    }
    return trees;
  }
}
