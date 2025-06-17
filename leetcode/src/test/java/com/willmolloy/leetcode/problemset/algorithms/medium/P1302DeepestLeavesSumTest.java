package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1302DeepestLeavesSumTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1302DeepestLeavesSumTest {

  private final P1302DeepestLeavesSum fun = new P1302DeepestLeavesSum();

  @Test
  void example1() {
    assertThat(
            fun.deepestLeavesSum(
                TreeNode.fromLevelOrder(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8)))
        .isEqualTo(15);
  }

  @Test
  void example2() {
    assertThat(
            fun.deepestLeavesSum(
                TreeNode.fromLevelOrder(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)))
        .isEqualTo(19);
  }

  @Test
  void singleNode() {
    assertThat(fun.deepestLeavesSum(TreeNode.fromLevelOrder(1))).isEqualTo(1);
  }

  @Test
  void twoNodes() {
    assertThat(fun.deepestLeavesSum(TreeNode.fromLevelOrder(1, 2))).isEqualTo(2);
  }

  @Test
  void deepestSumIsNotLargest() {
    assertThat(fun.deepestLeavesSum(TreeNode.fromLevelOrder(2, 1))).isEqualTo(1);
  }
}
