package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1315SumOfNodesWithEvenValuedGrandparentTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1315SumOfNodesWithEvenValuedGrandparentTest {

  private final P1315SumOfNodesWithEvenValuedGrandparent fun =
      new P1315SumOfNodesWithEvenValuedGrandparent();

  @Test
  void example1() {
    assertThat(
            fun.sumEvenGrandparent(
                TreeNode.fromLevelOrder(6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)))
        .isEqualTo(18);
  }
}
