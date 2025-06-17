package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link P110BalancedBinaryTree}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P110BalancedBinaryTreeTest {

  private final P110BalancedBinaryTree solution = new P110BalancedBinaryTree();

  @Test
  void example1() {
    assertThat(solution.isBalanced(TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7))).isTrue();
  }

  @Test
  void example2() {
    assertThat(solution.isBalanced(TreeNode.fromLevelOrder(1, 2, 2, 3, 3, null, null, 4, 4)))
        .isFalse();
  }

  @Test
  void unbalancedLeftChild() {
    assertThat(solution.isBalanced(TreeNode.fromLevelOrder(1, 2, 3, 4, null, 5, 6, 7))).isFalse();
  }

  @Test
  void unbalancedRightChild() {
    assertThat(
            solution.isBalanced(
                TreeNode.fromLevelOrder(1, 2, 3, 4, 5, null, 6, null, null, null, null, null, 7)))
        .isFalse();
  }

  @Test
  void emptyTree() {
    assertThat(solution.isBalanced(null)).isTrue();
  }
}
