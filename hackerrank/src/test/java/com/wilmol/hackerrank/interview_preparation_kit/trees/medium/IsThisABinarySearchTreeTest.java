package com.wilmol.hackerrank.interview_preparation_kit.trees.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.trees.medium.IsThisABinarySearchTree.checkBST;

import com.wilmol.hackerrank.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

class IsThisABinarySearchTreeTest {

  @Test
  void isBst() {
    BinaryTreeNode root = BinaryTreeNode.of(4);
    root.left = BinaryTreeNode.of(2);
    root.right = BinaryTreeNode.of(6);
    root.left.left = BinaryTreeNode.of(1);
    root.left.right = BinaryTreeNode.of(3);
    root.right.left = BinaryTreeNode.of(5);
    root.right.right = BinaryTreeNode.of(7);
    assertThat(checkBST(root)).isTrue();
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
    assertThat(checkBST(root)).isFalse();
  }
}
