package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.BinaryTreeNode;

/**
 * <a
 * href=https://leetcode.com/problems/serialize-and-deserialize-bst>https://leetcode.com/problems/serialize-and-deserialize-bst</a>
 *
 * <p>Key: Pretty standard to use recursion to traverse/build tree. So I'd say the key thing was
 * index handling (+1,-1 to skip parenthesis, knowing where they start (in this case consistently
 * '('), knowing if they're inclusive/exclusive (including library methods) etc.).
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.easy.P606ConstructStringFromBinaryTree
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P297SerializeAndDeserializeBinaryTree
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P449SerializeAndDeserializeBst {

  // Runtime: O(n)
  // Space: O(h)
  // TODO string isn't as compact as possible? Apparently don't need to represent null nodes
  public String serialize(BinaryTreeNode root) {
    // want to prefer the structure, so inorder traversal wont work
    // can store it by level order, and omit null nodes unless needed
    // (when left is null and right isnt)
    // (like that other problem with the parenthesis...)
    StringBuilder s = new StringBuilder();
    ser(root, s);
    return s.toString();
  }

  private void ser(BinaryTreeNode node, StringBuilder s) {
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
  public BinaryTreeNode deserialize(String data) {
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
      return new BinaryTreeNode(Integer.parseInt(data));
    } else {
      String thisData = data.substring(0, leftStart);
      BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(thisData));
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
