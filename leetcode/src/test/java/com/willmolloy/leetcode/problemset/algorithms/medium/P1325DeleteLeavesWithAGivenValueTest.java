package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1325DeleteLeavesWithAGivenValueTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1325DeleteLeavesWithAGivenValueTest {

  private final P1325DeleteLeavesWithAGivenValue fun = new P1325DeleteLeavesWithAGivenValue();

  @Test
  void example1() {
    assertThat(fun.removeLeafNodes(TreeNode.fromLevelOrder(1, 2, 3, 2, null, 2, 4), 2))
        .isEqualTo(TreeNode.fromLevelOrder(1, null, 3, null, null, null, 4));
  }

  @Test
  void example2() {
    assertThat(fun.removeLeafNodes(TreeNode.fromLevelOrder(1, 3, 3, 3, 2), 3))
        .isEqualTo(TreeNode.fromLevelOrder(1, 3, null, null, 2));
  }

  @Test
  void example3() {
    assertThat(fun.removeLeafNodes(TreeNode.fromLevelOrder(1, 2, null, 2, null, null, null, 2), 2))
        .isEqualTo(TreeNode.fromLevelOrder(1));
  }

  @Test
  void example4() {
    assertThat(fun.removeLeafNodes(TreeNode.fromLevelOrder(1, 1, 1), 1)).isNull();
  }

  @Test
  void example5() {
    assertThat(fun.removeLeafNodes(TreeNode.fromLevelOrder(1, 2, 3), 1))
        .isEqualTo(TreeNode.fromLevelOrder(1, 2, 3));
  }
}
