package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P226InvertBinaryTreeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P226InvertBinaryTreeTest {

  @Test
  void example() {
    BinaryTreeNode input = BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3, 6, 9);
    BinaryTreeNode output = new P226InvertBinaryTree().invertTree(input);
    assertThat(output).isEqualTo(BinaryTreeNode.fromLevelOrder(4, 7, 2, 9, 6, 3, 1));
  }
}
