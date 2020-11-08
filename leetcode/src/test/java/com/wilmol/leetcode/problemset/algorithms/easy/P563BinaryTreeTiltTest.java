package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P563BinaryTreeTiltTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P563BinaryTreeTiltTest {

  private final P563BinaryTreeTilt p563 = new P563BinaryTreeTilt();

  @Test
  void example1() {
    assertThat(p563.findTilt(BinaryTreeNode.fromLevelOrder(1, 2, 3))).isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(p563.findTilt(BinaryTreeNode.fromLevelOrder(4, 2, 9, 3, 5, null, 7))).isEqualTo(15);
  }

  @Test
  void example3() {
    assertThat(p563.findTilt(BinaryTreeNode.fromLevelOrder(21, 7, 14, 1, 1, 2, 2, 3, 3)))
        .isEqualTo(9);
  }
}
