package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P606ConstructStringFromBinaryTreeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P606ConstructStringFromBinaryTreeTest {

  private final P606ConstructStringFromBinaryTree fun = new P606ConstructStringFromBinaryTree();

  @Test
  void example1() {
    assertThat(fun.tree2str(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4))).isEqualTo("1(2(4))(3)");
  }

  @Test
  void example2() {
    assertThat(fun.tree2str(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 4)))
        .isEqualTo("1(2()(4))(3)");
  }
}
