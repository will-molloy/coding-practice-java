package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.BinaryTreeNode;

/**
 * Created by wilmol on 2020-04-13.
 *
 * <p><a
 * href=https://leetcode.com/problems/construct-string-from-binary-tree>https://leetcode.com/problems/construct-string-from-binary-tree</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key: can just check for the case where left child is NULL and right child isn't (i.e. DONT
 * have to omit parenthesis after the fact)
 *
 * @see com.wilmol.leetcode.problemset.algorithms.medium.P449SerializeAndDeserializeBst
 * @see com.wilmol.leetcode.problemset.algorithms.hard.P297SerializeAndDeserializeBinaryTree
 */
class P606ConstructStringFromBinaryTree {

  public String tree2str(BinaryTreeNode t) {
    StringBuilder s = new StringBuilder();
    tree2str(t, s);
    return s.toString();
  }

  private void tree2str(BinaryTreeNode t, StringBuilder s) {
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
