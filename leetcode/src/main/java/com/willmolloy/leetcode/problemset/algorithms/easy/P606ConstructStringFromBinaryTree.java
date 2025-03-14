package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/construct-string-from-binary-tree>https://leetcode.com/problems/construct-string-from-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: can just check for the case where left child is NULL and right child isn't (i.e.
 * DONT have to omit parenthesis after the fact)
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P449SerializeAndDeserializeBst
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P297SerializeAndDeserializeBinaryTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P606ConstructStringFromBinaryTree {

  public String tree2str(TreeNode t) {
    StringBuilder s = new StringBuilder();
    tree2str(t, s);
    return s.toString();
  }

  private void tree2str(TreeNode t, StringBuilder s) {
    if (t == null) {
      return;
    }
    s.append(t.val);
    if (t.left != null) {
      s.append("(");
      tree2str(t.left, s);
      s.append(")");
    }
    if (t.right != null) {
      if (t.left == null) {
        // case where NULL is represented
        s.append("()");
      }
      s.append("(");
      tree2str(t.right, s);
      s.append(")");
    }
  }
}
