package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P938RangeSumOfBstTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P938RangeSumOfBstTest {

  private final P938RangeSumOfBst fun = new P938RangeSumOfBst();

  @Test
  void example1() {
    assertThat(fun.rangeSumBst(BinaryTreeNode.fromLevelOrder(10, 5, 15, 3, 7, null, 18), 7, 15))
        .isEqualTo(32);
  }

  @Test
  void example2() {
    assertThat(
            fun.rangeSumBst(
                BinaryTreeNode.fromLevelOrder(10, 5, 15, 3, 7, 13, 18, 1, null, 6), 6, 10))
        .isEqualTo(23);
  }
}
