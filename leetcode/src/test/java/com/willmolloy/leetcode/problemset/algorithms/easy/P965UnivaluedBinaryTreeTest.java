package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P965UnivaluedBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P965UnivaluedBinaryTreeTest {

  private final P965UnivaluedBinaryTree p965 = new P965UnivaluedBinaryTree();

  @Test
  void example1() {
    assertThat(p965.isUnivalTree(TreeNode.fromLevelOrder(1, 1, 1, 1, 1, null, 1))).isTrue();
  }

  @Test
  void example2() {
    assertThat(p965.isUnivalTree(TreeNode.fromLevelOrder(2, 2, 2, 5, 2))).isFalse();
  }
}
