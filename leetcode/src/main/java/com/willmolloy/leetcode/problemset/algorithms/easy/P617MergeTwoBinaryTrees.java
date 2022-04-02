package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * <a
 * href=https://leetcode.com/problems/merge-two-binary-trees>https://leetcode.com/problems/merge-two-binary-trees/</a>
 *
 * <p>Difficulty: Easy.
 *
 * <p>Runtime: O(min(t1, t2)) (stops at first null subtree, i.e. dictated by smallest tree)
 *
 * <p>Space: O(min(height(t1), height(t2))) (stops at first null subtree)
 *
 * <p>Key: Think about just one node.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P617MergeTwoBinaryTrees {

  public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
    if (t1 == null) {
      // if t2 has a large subtree while for t1 it is a large 'null' space then t1 will simply
      // inherit it
      return t2;
    }
    if (t2 == null) {
      return t1;
    }
    t1.val += t2.val;
    t1.left = mergeTrees(t1.left, t2.left);
    t1.right = mergeTrees(t1.right, t2.right);
    return t1;
  }

  /** TreeNode. */
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      TreeNode treeNode = (TreeNode) o;
      return val == treeNode.val
          && Objects.equals(left, treeNode.left)
          && Objects.equals(right, treeNode.right);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, left, right);
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", TreeNode.class.getSimpleName() + "[", "]")
          .add("val=" + val)
          .add("left=" + left)
          .add("right=" + right)
          .toString();
    }
  }
}
