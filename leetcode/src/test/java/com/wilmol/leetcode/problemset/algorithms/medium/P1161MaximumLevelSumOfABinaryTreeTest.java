package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-16. */
class P1161MaximumLevelSumOfABinaryTreeTest {

  private final P1161MaximumLevelSumOfABinaryTree fun = new P1161MaximumLevelSumOfABinaryTree();

  @Test
  void example() {
    assertThat(fun.maxLevelSum(BinaryTreeNode.fromLevelOrder(1, 7, 0, -7, -8))).isEqualTo(2);
  }

  @Test
  void emptyTree() {
    assertThat(fun.maxLevelSum(null)).isEqualTo(0);
  }

  @Test
  void levelSumsAreEqualTakeFirst() {
    assertThat(fun.maxLevelSum(BinaryTreeNode.fromLevelOrder(4, 2, 2, 1, 1, 1, 1))).isEqualTo(1);
  }
}
