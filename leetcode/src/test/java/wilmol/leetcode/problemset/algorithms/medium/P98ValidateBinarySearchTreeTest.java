package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-09. */
class P98ValidateBinarySearchTreeTest {

  private final P98ValidateBinarySearchTree fun = new P98ValidateBinarySearchTree();

  @Test
  void example1() {
    BinaryTreeNode root = new BinaryTreeNode(2);
    root.left = new BinaryTreeNode(1);
    root.right = new BinaryTreeNode(3);
    assertThat(fun.isValidBst(root)).isTrue();
  }

  @Test
  void example2() {
    BinaryTreeNode root = new BinaryTreeNode(5);
    root.left = new BinaryTreeNode(1);
    root.right = new BinaryTreeNode(4);
    assertThat(fun.isValidBst(root)).isFalse();
  }

  @Test
  void brokenNotByDirectChild() {
    BinaryTreeNode root = new BinaryTreeNode(5);
    root.left = new BinaryTreeNode(1);
    root.right = new BinaryTreeNode(6);
    root.right.left = new BinaryTreeNode(4);
    assertThat(fun.isValidBst(root)).isFalse();
  }
}
