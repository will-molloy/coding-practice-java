package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P897IncreasingOrderSearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P897IncreasingOrderSearchTreeTest {

  @Test
  void example1() {
    assertThat(
            new P897IncreasingOrderSearchTree()
                .increasingBST(
                    TreeNode.fromLevelOrder(5, 3, 6, 2, 4, null, 8, 1, null, null, null, 7, 9)))
        .isEqualTo(
            TreeNode.fromLevelOrder(
                1, null, 2, null, 3, null, 4, null, 5, null, 6, null, 7, null, 8, null, 9));
  }

  @Test
  void example2() {
    assertThat(new P897IncreasingOrderSearchTree().increasingBST(TreeNode.fromLevelOrder(5, 1, 7)))
        .isEqualTo(TreeNode.fromLevelOrder(1, null, 5, null, 7));
  }
}
