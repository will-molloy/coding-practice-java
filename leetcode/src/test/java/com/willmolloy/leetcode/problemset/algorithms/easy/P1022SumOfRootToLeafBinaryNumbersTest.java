package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1022SumOfRootToLeafBinaryNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1022SumOfRootToLeafBinaryNumbersTest {

  private final P1022SumOfRootToLeafBinaryNumbers p1022 = new P1022SumOfRootToLeafBinaryNumbers();

  @Test
  void example() {
    assertThat(p1022.sumRootToLeaf(TreeNode.fromLevelOrder(1, 0, 1, 0, 1, 0, 1))).isEqualTo(22);
  }
}
