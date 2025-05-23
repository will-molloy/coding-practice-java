package com.willmolloy.leetcode.problemset.algorithms.hard;

import com.willmolloy.leetcode.common.TreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/serialize-and-deserialize-binary-tree>https://leetcode.com/problems/serialize-and-deserialize-binary-tree/</a>
 *
 * <p>Difficulty: Hard.
 *
 * <p>Key idea: Solution duplicates {@link
 * com.willmolloy.leetcode.problemset.algorithms.medium.P449SerializeAndDeserializeBst}.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P606ConstructStringFromBinaryTree
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P449SerializeAndDeserializeBst
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P297SerializeAndDeserializeBinaryTree {

  // Runtime: O(n)
  // Space: O(h)
  // TODO string isn't as compact as possible? Apparently don't need to represent null nodes
  public String serialize(TreeNode root) {
    // want to prefer the structure, so inorder traversal wont work
    // can store it by level order, and omit null nodes unless needed
    // (when left is null and right isnt)
    // (like that other problem with the parenthesis...)
    StringBuilder s = new StringBuilder();
    ser(root, s);
    return s.toString();
  }

  private void ser(TreeNode node, StringBuilder s) {
    if (node == null) {
      return;
    }
    s.append(node.val);
    if (node.left != null) {
      s.append("(");
      ser(node.left, s);
      s.append(")");
    }
    if (node.right != null) {
      if (node.left == null) {
        s.append("()");
      }
      s.append("(");
      ser(node.right, s);
      s.append(")");
    }
  }

  // Runtime: O(n^2)
  // TODO or is it O(nh)? Basically, there is repeated computation when determining start of right
  //  subtree
  // TODO surely exists an O(n) solution
  // Space: O(h)
  public TreeNode deserialize(String data) {
    if (data.isEmpty()) {
      return null;
    }

    int balance = 0;
    int leftStart = 0;
    int rightStart = 0;
    for (int i = 0; i < data.length(); i++) {
      if (leftStart == 0 && data.charAt(i) == '(') {
        leftStart = i;
        balance++;
      } else if (leftStart > 0) {
        if (data.charAt(i) == '(') {
          balance++;
        } else if (data.charAt(i) == ')') {
          balance--;
          if (balance == 0) {
            rightStart = i + 1;
            break;
          }
        }
      }
    }

    if (leftStart == 0) {
      return new TreeNode(Integer.parseInt(data));
    } else {
      String thisData = data.substring(0, leftStart);
      TreeNode node = new TreeNode(Integer.parseInt(thisData));
      // +1, -1, to skip parenthesis
      String leftData = data.substring(leftStart + 1, rightStart - 1);
      node.left = deserialize(leftData);
      if (rightStart < data.length()) {
        String rightData = data.substring(rightStart + 1, data.length() - 1);
        node.right = deserialize(rightData);
      }
      return node;
    }
  }
}
