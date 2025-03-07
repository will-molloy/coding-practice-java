package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P783MinimumDistanceBetweenBstNodesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P783MinimumDistanceBetweenBstNodesTest {

  private final P783MinimumDistanceBetweenBstNodes fun = new P783MinimumDistanceBetweenBstNodes();

  @Test
  void example() {
    assertThat(fun.minDiffInBst(TreeNode.fromLevelOrder(4, 2, 6, 1, 3))).isEqualTo(1);
  }
}
