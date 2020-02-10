package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-09. */
class P98ValidateBinarySearchTreeTest {

  private final P98ValidateBinarySearchTree fun = new P98ValidateBinarySearchTree();

  @Test
  void example1() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(2, 1, 3);
    assertThat(fun.isValidBst(root)).isTrue();
  }

  @Test
  void example2() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(5, 1, 4);
    assertThat(fun.isValidBst(root)).isFalse();
  }

  @Test
  void brokenNotByDirectChild() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(5, 1, 6, null, null, 4);
    assertThat(fun.isValidBst(root)).isFalse();
  }
}
