package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P783MinimumDistanceBetweenBstNodesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P783MinimumDistanceBetweenBstNodesTest {

  private final P783MinimumDistanceBetweenBstNodes fun = new P783MinimumDistanceBetweenBstNodes();

  @Test
  void example() {
    assertThat(fun.minDiffInBst(BinaryTreeNode.fromLevelOrder(4, 2, 6, 1, 3))).isEqualTo(1);
  }
}
