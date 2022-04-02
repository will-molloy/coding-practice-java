package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P437PathSum3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P437PathSum3Test {

  private final P437PathSum3 p437 = new P437PathSum3();

  @Test
  void example() {
    assertThat(
            p437.pathSum(
                BinaryTreeNode.fromLevelOrder(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1), 8))
        .isEqualTo(3);
  }

  @Test
  void wa1() {
    assertThat(p437.pathSum(BinaryTreeNode.fromLevelOrder(0, 1, 1), 1)).isEqualTo(4);
  }

  @Test
  void wa2() {
    assertThat(
            p437.pathSum(
                BinaryTreeNode.fromLevelOrder(1, 0, 1, 1, 2, 0, -1, 0, 1, -1, 0, -1, 0, 1, 0), 2))
        .isEqualTo(13);
  }
}
