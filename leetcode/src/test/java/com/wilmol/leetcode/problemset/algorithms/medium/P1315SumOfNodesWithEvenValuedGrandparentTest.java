package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1315SumOfNodesWithEvenValuedGrandparentTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1315SumOfNodesWithEvenValuedGrandparentTest {

  private final P1315SumOfNodesWithEvenValuedGrandparent fun =
      new P1315SumOfNodesWithEvenValuedGrandparent();

  @Test
  void example1() {
    assertThat(
            fun.sumEvenGrandparent(
                BinaryTreeNode.fromLevelOrder(
                    6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)))
        .isEqualTo(18);
  }
}
