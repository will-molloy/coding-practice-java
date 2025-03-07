package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P226InvertBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P226InvertBinaryTreeTest {

  @Test
  void example() {
    TreeNode input = TreeNode.fromLevelOrder(4, 2, 7, 1, 3, 6, 9);
    TreeNode output = new P226InvertBinaryTree().invertTree(input);
    assertThat(output).isEqualTo(TreeNode.fromLevelOrder(4, 7, 2, 9, 6, 3, 1));
  }
}
