package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.TreeNode;
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
 * <p>Key idea: returning singleton null node when end < start
 *
 * @see P96UniqueBinarySearchTrees
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P95UniqueBinarySearchTrees2 {

  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return Collections.emptyList();
    }
    return trees(1, n);
  }

  private List<TreeNode> trees(int start, int end) {
    if (end < start) {
      // need null node, so empty tree is paired with non-empty tree, otherwise non-empty tree is
      // ignored because (if returning empty list) the size would be 0
      return Collections.singletonList(null);
    }
    if (start == end) {
      return Collections.singletonList(new TreeNode(start));
    }

    ArrayList<TreeNode> trees = new ArrayList<>();
    // try every node as root
    for (int i = start; i <= end; i++) {
      // recursively build subtrees
      List<TreeNode> leftTrees = trees(start, i - 1);
      List<TreeNode> rightTrees = trees(i + 1, end);
      // pair every left tree with every right tree (cartesian product)
      for (TreeNode leftTree : leftTrees) {
        for (TreeNode rightTree : rightTrees) {
          // now construct root, so avoids need to copy trees
          TreeNode root = new TreeNode(i);
          root.left = leftTree;
          root.right = rightTree;
          trees.add(root);
        }
      }
    }
    return trees;
  }
}
