package com.wilmol.leetcode.problems.trees.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

import com.wilmol.leetcode.common.BinaryTreeNode;

class P226_InvertBinaryTreeTest
{

  @Test
  void example()
  {
    BinaryTreeNode input = new BinaryTreeNode(4, 2, 7, 1, 3, 6, 9);
    BinaryTreeNode output = new P226_InvertBinaryTree().invertTree(input);
    assertThat(output).isEqualTo(new BinaryTreeNode(4, 7, 2, 9, 6, 3, 1));
  }

}
