package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P230KthSmallestElementInABstTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P230KthSmallestElementInABstTest {

  @Test
  void example1() {
    assertThat(
            new P230KthSmallestElementInABst()
                .kthSmallest(TreeNode.fromLevelOrder(3, 1, 4, null, 2), 1))
        .isEqualTo(1);
  }

  @Test
  void example2() {
    assertThat(
            new P230KthSmallestElementInABst()
                .kthSmallest(TreeNode.fromLevelOrder(5, 3, 6, 2, 4, null, null, 1), 3))
        .isEqualTo(3);
  }
}
