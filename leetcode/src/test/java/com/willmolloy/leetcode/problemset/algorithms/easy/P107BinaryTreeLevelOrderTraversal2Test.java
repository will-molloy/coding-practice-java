package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P107BinaryTreeLevelOrderTraversal2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P107BinaryTreeLevelOrderTraversal2Test {

  private final P107BinaryTreeLevelOrderTraversal2 fun = new P107BinaryTreeLevelOrderTraversal2();

  @Test
  void example() {
    TreeNode root = TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.levelOrderBottom(root))
        .containsExactly(List.of(15, 7), List.of(9, 20), List.of(3))
        .inOrder();
  }
}
