package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * <a href=https://leetcode.com/problems/same-tree>https://leetcode.com/problems/same-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(log n) best case; O(n) worst case (recursion stack size)
 *
 * <p>Key: recursion
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P100SameTree {

  public boolean isSameTree(BinaryTreeNode p, BinaryTreeNode q) {
    // it's like overriding Objects#equals
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }
}
