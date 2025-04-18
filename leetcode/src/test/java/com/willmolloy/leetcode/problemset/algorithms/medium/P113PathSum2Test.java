package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P113PathSum2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P113PathSum2Test {

  private final P113PathSum2 fun = new P113PathSum2();

  @Test
  void example() {
    TreeNode root =
        TreeNode.fromLevelOrder(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, 5, 1);
    assertThat(fun.pathSum(root, 22))
        .containsExactly(ImmutableList.of(5, 4, 11, 2), ImmutableList.of(5, 8, 4, 5));
  }
}
