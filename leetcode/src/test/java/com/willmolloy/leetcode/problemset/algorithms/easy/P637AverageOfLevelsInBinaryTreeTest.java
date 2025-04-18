package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P637AverageOfLevelsInBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P637AverageOfLevelsInBinaryTreeTest {

  private final P637AverageOfLevelsInBinaryTree p637 = new P637AverageOfLevelsInBinaryTree();

  @Test
  void example1() {
    assertThat(p637.averageOfLevels(TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7)))
        .containsExactly(3d, 14.5d, 11d)
        .inOrder();
  }

  @Test
  void integerOverflow() {
    assertThat(
            p637.averageOfLevels(
                TreeNode.fromLevelOrder(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE)))
        .containsExactly(
            Integer.valueOf(Integer.MAX_VALUE).doubleValue(),
            Integer.valueOf(Integer.MAX_VALUE).doubleValue())
        .inOrder();
  }
}
