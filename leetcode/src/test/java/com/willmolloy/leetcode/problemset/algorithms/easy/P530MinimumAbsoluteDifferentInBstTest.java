package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P530MinimumAbsoluteDifferentInBstTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P530MinimumAbsoluteDifferentInBstTest {

  private final P530MinimumAbsoluteDifferentInBst fun = new P530MinimumAbsoluteDifferentInBst();

  @Test
  void example1() {
    assertThat(fun.getMinimumDifference(TreeNode.fromLevelOrder(4, 2, 6, 1, 3))).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(fun.getMinimumDifference(TreeNode.fromLevelOrder(1, 0, 48, null, null, 12, 49)))
        .isEqualTo(1);
  }
}
