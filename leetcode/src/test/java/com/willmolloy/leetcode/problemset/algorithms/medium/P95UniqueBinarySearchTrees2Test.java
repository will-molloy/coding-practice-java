package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P95UniqueBinarySearchTrees2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P95UniqueBinarySearchTrees2Test {

  private final P95UniqueBinarySearchTrees2 fun = new P95UniqueBinarySearchTrees2();

  @Test
  void example() {
    assertThat(fun.generateTrees(3))
        .containsExactly(
            BinaryTreeNode.fromLevelOrder(1, null, 3, null, null, 2),
            BinaryTreeNode.fromLevelOrder(3, 2, null, 1),
            BinaryTreeNode.fromLevelOrder(3, 1, null, null, 2),
            BinaryTreeNode.fromLevelOrder(2, 1, 3),
            BinaryTreeNode.fromLevelOrder(1, null, 2, null, null, null, 3));
  }

  @Test
  void zero() {
    assertThat(fun.generateTrees(0)).isEmpty();
  }

  @Test
  void one() {
    assertThat(fun.generateTrees(1)).containsExactly(new BinaryTreeNode(1));
  }
}
