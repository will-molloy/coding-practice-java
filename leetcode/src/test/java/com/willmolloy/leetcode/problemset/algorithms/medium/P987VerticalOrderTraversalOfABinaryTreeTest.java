package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P987VerticalOrderTraversalOfABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P987VerticalOrderTraversalOfABinaryTreeTest {

  private final P987VerticalOrderTraversalOfABinaryTree p987 =
      new P987VerticalOrderTraversalOfABinaryTree();

  @Test
  void example1() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(p987.verticalTraversal(root))
        .containsExactly(
            ImmutableList.of(9), ImmutableList.of(3, 15), ImmutableList.of(20), ImmutableList.of(7))
        .inOrder();
  }

  @Test
  void example2() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertThat(p987.verticalTraversal(root))
        .containsExactly(
            ImmutableList.of(4),
            ImmutableList.of(2),
            ImmutableList.of(1, 5, 6),
            ImmutableList.of(3),
            ImmutableList.of(7))
        .inOrder();
  }
}
