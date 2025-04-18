package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P199BinaryTreeRightSideViewTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P199BinaryTreeRightSideViewTest {

  private final P199BinaryTreeRightSideView p199 = new P199BinaryTreeRightSideView();

  @Test
  void example() {
    assertThat(p199.rightSideView(TreeNode.fromLevelOrder(1, 2, 3, null, 5, null, 4)))
        .containsExactly(1, 3, 4)
        .inOrder();
  }

  @Test
  void emptyTree() {
    assertThat(p199.rightSideView(null)).isEmpty();
  }

  @Test
  void cantJustTraverseRightPath() {
    assertThat(p199.rightSideView(TreeNode.fromLevelOrder(1, 2, 3, null, 5)))
        .containsExactly(1, 3, 5)
        .inOrder();
  }
}
