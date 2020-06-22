package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-02-11. */
class P103BinaryTreeZigzagLevelOrderTraversalTest {

  private final P103BinaryTreeZigzagLevelOrderTraversal fun =
      new P103BinaryTreeZigzagLevelOrderTraversal();

  @Test
  void example() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.zigzagLevelOrder(root))
        .containsExactly(ImmutableList.of(3), ImmutableList.of(20, 9), ImmutableList.of(15, 7))
        .inOrder();
  }

  @Test
  void emptyTree() {
    assertThat(fun.zigzagLevelOrder(null)).isEmpty();
  }

  @Test
  void singleNodePerLevel() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, null, 3, null, null, null, 4);
    assertThat(fun.zigzagLevelOrder(root))
        .containsExactly(
            ImmutableList.of(1), ImmutableList.of(2), ImmutableList.of(3), ImmutableList.of(4))
        .inOrder();
  }
}
