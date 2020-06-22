package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-16. */
class P530MinimumAbsoluteDifferentInBstTest {

  private final P530MinimumAbsoluteDifferentInBst fun = new P530MinimumAbsoluteDifferentInBst();

  @Test
  void example() {
    assertThat(fun.getMinimumDifference(BinaryTreeNode.fromLevelOrder(1, null, 3, null, null, 2)))
        .isEqualTo(1);
  }
}
