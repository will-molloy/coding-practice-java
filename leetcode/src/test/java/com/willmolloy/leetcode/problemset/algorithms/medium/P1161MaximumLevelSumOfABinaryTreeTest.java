package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1161MaximumLevelSumOfABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1161MaximumLevelSumOfABinaryTreeTest {

  private final P1161MaximumLevelSumOfABinaryTree fun = new P1161MaximumLevelSumOfABinaryTree();

  @Test
  void example() {
    assertThat(fun.maxLevelSum(TreeNode.fromLevelOrder(1, 7, 0, -7, -8))).isEqualTo(2);
  }

  @Test
  void emptyTree() {
    assertThat(fun.maxLevelSum(null)).isEqualTo(0);
  }

  @Test
  void levelSumsAreEqualTakeFirst() {
    assertThat(fun.maxLevelSum(TreeNode.fromLevelOrder(4, 2, 2, 1, 1, 1, 1))).isEqualTo(1);
  }
}
