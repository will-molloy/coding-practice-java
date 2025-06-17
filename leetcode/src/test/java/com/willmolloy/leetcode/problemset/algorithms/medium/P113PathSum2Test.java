package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link P113PathSum2}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P113PathSum2Test {

  private final P113PathSum2 fun = new P113PathSum2();

  @Test
  void example() {
    TreeNode root = TreeNode.fromLevelOrder(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1);
    assertThat(fun.pathSum(root, 22)).containsExactly(List.of(5, 4, 11, 2), List.of(5, 8, 4, 5));
  }
}
