package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P662MaximumWidthOfBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P662MaximumWidthOfBinaryTreeTest {

  private final P662MaximumWidthOfBinaryTree fun = new P662MaximumWidthOfBinaryTree();

  @Test
  void example1() {
    assertThat(fun.widthOfBinaryTree(TreeNode.fromLevelOrder(1, 3, 2, 5, 3, null, 9))).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(fun.widthOfBinaryTree(TreeNode.fromLevelOrder(1, 3, null, 5, 3))).isEqualTo(2);
  }

  @Test
  void example3() {
    assertThat(fun.widthOfBinaryTree(TreeNode.fromLevelOrder(1, 3, 2, 5))).isEqualTo(2);
  }

  @Test
  void example4() {
    assertThat(
            fun.widthOfBinaryTree(
                TreeNode.fromLevelOrder(
                    1, 3, 2, 5, null, null, 9, 6, null, null, null, null, null, null, 7)))
        .isEqualTo(8);
  }

  @Test
  void emptyTree() {
    assertThat(fun.widthOfBinaryTree(null)).isEqualTo(0);
  }

  @Test
  void gapOfTwo() {
    assertThat(fun.widthOfBinaryTree(TreeNode.fromLevelOrder(1, 2, 3, 4, null, null, 7)))
        .isEqualTo(4);
  }

  @Test
  void gapOfSix() {
    assertThat(
            fun.widthOfBinaryTree(
                TreeNode.fromLevelOrder(
                    1, 2, 3, 4, 5, 6, 7, 8, null, null, null, null, null, null, 15)))
        .isEqualTo(8);
  }

  @Test
  void firstInLevelIsNull() {
    assertThat(
            fun.widthOfBinaryTree(
                TreeNode.fromLevelOrder(
                    1, 2, 3, 4, 5, 6, 7, null, 9, null, null, null, null, null, 15)))
        .isEqualTo(7);
  }
}
