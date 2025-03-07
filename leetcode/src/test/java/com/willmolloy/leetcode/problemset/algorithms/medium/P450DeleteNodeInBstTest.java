package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P450DeleteNodeInBstTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P450DeleteNodeInBstTest {

  private final P450DeleteNodeInBst p450 = new P450DeleteNodeInBst();

  @Test
  void example() {
    assertThat(p450.deleteNode(TreeNode.fromLevelOrder(5, 3, 6, 2, 4, null, 7), 3))
        .isAnyOf(
            TreeNode.fromLevelOrder(5, 4, 6, 2, null, null, 7),
            TreeNode.fromLevelOrder(5, 2, 6, null, 4, null, 7));
  }
}
