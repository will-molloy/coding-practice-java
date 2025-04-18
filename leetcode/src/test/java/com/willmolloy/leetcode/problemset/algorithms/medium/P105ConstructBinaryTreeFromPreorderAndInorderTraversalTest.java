package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P105ConstructBinaryTreeFromPreorderAndInorderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P105ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

  private final P105ConstructBinaryTreeFromPreorderAndInorderTraversal fun =
      new P105ConstructBinaryTreeFromPreorderAndInorderTraversal();

  @Test
  void example() {
    assertThat(fun.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7}))
        .isEqualTo(TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7));
  }
}
