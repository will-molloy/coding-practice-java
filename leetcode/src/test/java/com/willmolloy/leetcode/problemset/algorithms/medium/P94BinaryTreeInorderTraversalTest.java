package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P94BinaryTreeInorderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P94BinaryTreeInorderTraversalTest {

  private final P94BinaryTreeInorderTraversal func = new P94BinaryTreeInorderTraversal();

  @Test
  void example1() {
    assertThat(func.inorderTraversal(TreeNode.fromLevelOrder(1, null, 2, 3)))
        .containsExactly(1, 3, 2)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            func.inorderTraversal(
                TreeNode.fromLevelOrder(1, 2, 3, 4, 5, null, 8, null, null, 6, 7, 9)))
        .containsExactly(4, 2, 6, 5, 7, 1, 3, 9, 8)
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(func.inorderTraversal(null)).isEmpty();
  }

  @Test
  void example4() {
    assertThat(func.inorderTraversal(new TreeNode(1))).containsExactly(1).inOrder();
  }

  @Test
  void threeLevels() {
    assertThat(func.inorderTraversal(TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7)))
        .containsExactly(4, 2, 5, 1, 6, 3, 7)
        .inOrder();
  }
}
