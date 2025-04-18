package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P993CousinsInBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P993CousinsInBinaryTreeTest {

  private final P993CousinsInBinaryTree p993 = new P993CousinsInBinaryTree();

  @Test
  void example1() {
    assertThat(p993.isCousins(TreeNode.fromLevelOrder(1, 2, 3, 4), 4, 3)).isFalse();
  }

  @Test
  void example2() {
    assertThat(p993.isCousins(TreeNode.fromLevelOrder(1, 2, 3, null, 4, null, 5), 5, 4)).isTrue();
  }

  @Test
  void example3() {
    assertThat(p993.isCousins(TreeNode.fromLevelOrder(1, 2, 3, null, 4), 2, 3)).isFalse();
  }
}
