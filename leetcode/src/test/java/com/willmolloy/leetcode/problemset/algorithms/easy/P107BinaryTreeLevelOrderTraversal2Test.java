package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P107BinaryTreeLevelOrderTraversal2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P107BinaryTreeLevelOrderTraversal2Test {

  private final P107BinaryTreeLevelOrderTraversal2 fun = new P107BinaryTreeLevelOrderTraversal2();

  @Test
  void example() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.levelOrderBottom(root))
        .containsExactly(ImmutableList.of(15, 7), ImmutableList.of(9, 20), ImmutableList.of(3))
        .inOrder();
  }
}
