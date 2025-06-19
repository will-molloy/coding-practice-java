package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P987VerticalOrderTraversalOfABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P987VerticalOrderTraversalOfABinaryTreeTest {

  private final P987VerticalOrderTraversalOfABinaryTree p987 =
      new P987VerticalOrderTraversalOfABinaryTree();

  @Test
  void example1() {
    TreeNode root = TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(p987.verticalTraversal(root))
        .containsExactly(List.of(9), List.of(3, 15), List.of(20), List.of(7))
        .inOrder();
  }

  @Test
  void example2() {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7);
    assertThat(p987.verticalTraversal(root))
        .containsExactly(List.of(4), List.of(2), List.of(1, 5, 6), List.of(3), List.of(7))
        .inOrder();
  }
}
