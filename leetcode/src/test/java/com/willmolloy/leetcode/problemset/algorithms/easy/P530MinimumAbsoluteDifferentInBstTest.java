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
  void example() {
    assertThat(fun.getMinimumDifference(TreeNode.fromLevelOrder(1, null, 3, null, null, 2)))
        .isEqualTo(1);
  }
}
