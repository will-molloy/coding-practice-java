package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P111MinimumDepthOfBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P111MinimumDepthOfBinaryTreeTest {

  private final P111MinimumDepthOfBinaryTree fun = new P111MinimumDepthOfBinaryTree();

  @Test
  void example() {
    assertThat(fun.minDepth(TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7))).isEqualTo(2);
  }

  @Test
  void emptyTree() {
    assertThat(fun.minDepth(null)).isEqualTo(0);
  }

  @Test
  void singleNode() {
    assertThat(fun.minDepth(TreeNode.fromLevelOrder(1))).isEqualTo(1);
  }

  @Test
  void twoNodes() {
    assertThat(fun.minDepth(TreeNode.fromLevelOrder(1, 2))).isEqualTo(2);
  }
}
