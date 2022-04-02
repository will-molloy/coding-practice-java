package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P112PathSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P112PathSumTest {

  private final P112PathSum fun = new P112PathSum();

  @Test
  void example() {
    assertThat(
            fun.hasPathSum(
                BinaryTreeNode.fromLevelOrder(
                    5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1),
                22))
        .isTrue();
  }

  @Test
  void exampleBut2IsntALeaf() {
    assertThat(
            fun.hasPathSum(
                BinaryTreeNode.fromLevelOrder(
                    5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1, null, null,
                    null, 3),
                22))
        .isFalse();
  }

  @Test
  void emptyTreeZeroSum() {
    assertThat(fun.hasPathSum(null, 0)).isFalse();
  }

  @Test
  void singleNode() {
    assertThat(fun.hasPathSum(BinaryTreeNode.fromLevelOrder(100), 100)).isTrue();
  }

  @Test
  void twoNodes() {
    assertThat(fun.hasPathSum(BinaryTreeNode.fromLevelOrder(1, 2), 3)).isTrue();
  }
}
