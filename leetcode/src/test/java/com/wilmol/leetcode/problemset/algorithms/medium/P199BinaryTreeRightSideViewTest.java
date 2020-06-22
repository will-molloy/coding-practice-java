package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-16. */
class P199BinaryTreeRightSideViewTest {

  private final P199BinaryTreeRightSideView p199 = new P199BinaryTreeRightSideView();

  @Test
  void example() {
    assertThat(p199.rightSideView(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 5, null, 4)))
        .containsExactly(1, 3, 4)
        .inOrder();
  }

  @Test
  void emptyTree() {
    assertThat(p199.rightSideView(null)).isEmpty();
  }

  @Test
  void cantJustTraverseRightPath() {
    assertThat(p199.rightSideView(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 5)))
        .containsExactly(1, 3, 5)
        .inOrder();
  }
}
