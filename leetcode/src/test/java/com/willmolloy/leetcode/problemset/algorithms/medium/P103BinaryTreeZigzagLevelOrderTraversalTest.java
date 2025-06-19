package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P103BinaryTreeZigzagLevelOrderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P103BinaryTreeZigzagLevelOrderTraversalTest {

  private final P103BinaryTreeZigzagLevelOrderTraversal fun =
      new P103BinaryTreeZigzagLevelOrderTraversal();

  @Test
  void example() {
    TreeNode root = TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.zigzagLevelOrder(root))
        .containsExactly(List.of(3), List.of(20, 9), List.of(15, 7))
        .inOrder();
  }

  @Test
  void emptyTree() {
    assertThat(fun.zigzagLevelOrder(null)).isEmpty();
  }

  @Test
  void singleNodePerLevel() {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, null, 3, null, 4);
    assertThat(fun.zigzagLevelOrder(root))
        .containsExactly(List.of(1), List.of(2), List.of(3), List.of(4))
        .inOrder();
  }
}
