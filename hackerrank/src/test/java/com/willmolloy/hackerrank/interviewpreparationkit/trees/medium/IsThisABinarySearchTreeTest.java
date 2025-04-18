package com.willmolloy.hackerrank.interviewpreparationkit.trees.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.hackerrank.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * IsThisABinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class IsThisABinarySearchTreeTest {

  @Test
  void isBst() {
    BinaryTreeNode root = BinaryTreeNode.of(4);
    root.left = BinaryTreeNode.of(2);
    root.right = BinaryTreeNode.of(6);
    root.left.left = BinaryTreeNode.of(1);
    root.left.right = BinaryTreeNode.of(3);
    root.right.left = BinaryTreeNode.of(5);
    root.right.right = BinaryTreeNode.of(7);
    assertThat(IsThisABinarySearchTree.checkBst(root)).isTrue();
  }

  @Test
  void isNotBst() {
    BinaryTreeNode root = BinaryTreeNode.of(3);
    root.left = BinaryTreeNode.of(2);
    root.right = BinaryTreeNode.of(5);
    root.left.right = BinaryTreeNode.of(1);
    root.left.left = BinaryTreeNode.of(3);
    root.right.left = BinaryTreeNode.of(6);
    root.right.right = BinaryTreeNode.of(1);
    assertThat(IsThisABinarySearchTree.checkBst(root)).isFalse();
  }
}
