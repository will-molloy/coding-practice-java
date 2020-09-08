package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1022SumOfRootToLeafBinaryNumbersTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1022SumOfRootToLeafBinaryNumbersTest {

  private final P1022SumOfRootToLeafBinaryNumbers p1022 = new P1022SumOfRootToLeafBinaryNumbers();

  @Test
  void example() {
    assertThat(p1022.sumRootToLeaf(BinaryTreeNode.fromLevelOrder(1, 0, 1, 0, 1, 0, 1)))
        .isEqualTo(22);
  }
}
