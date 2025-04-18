package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P106ConstructBinaryTreeFromInorderAndPostorderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P106ConstructBinaryTreeFromInorderAndPostorderTraversalTest {

  private final P106ConstructBinaryTreeFromInorderAndPostorderTraversal fun =
      new P106ConstructBinaryTreeFromInorderAndPostorderTraversal();

  @Test
  void example() {
    assertThat(fun.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3}))
        .isEqualTo(TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7));
  }
}
