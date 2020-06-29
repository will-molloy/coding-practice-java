package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P965UnivaluedBinaryTreeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P965UnivaluedBinaryTreeTest {

  private final P965UnivaluedBinaryTree p965 = new P965UnivaluedBinaryTree();

  @Test
  void example1() {
    assertThat(p965.isUnivalTree(BinaryTreeNode.fromLevelOrder(1, 1, 1, 1, 1, null, 1))).isTrue();
  }

  @Test
  void example2() {
    assertThat(p965.isUnivalTree(BinaryTreeNode.fromLevelOrder(2, 2, 2, 5, 2))).isFalse();
  }
}
