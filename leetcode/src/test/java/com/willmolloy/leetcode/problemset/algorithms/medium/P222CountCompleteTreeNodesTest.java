package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P222CountCompleteTreeNodesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P222CountCompleteTreeNodesTest {

  private final P222CountCompleteTreeNodes fun = new P222CountCompleteTreeNodes();

  @Test
  void notFullTree() {
    assertThat(fun.countNodes(TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6))).isEqualTo(6);
  }

  @Test
  void fullTree() {
    assertThat(fun.countNodes(TreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7))).isEqualTo(7);
  }

  @Test
  void oneNode() {
    assertThat(fun.countNodes(TreeNode.fromLevelOrder(1))).isEqualTo(1);
  }

  @Test
  void noNodes() {
    assertThat(fun.countNodes(null)).isEqualTo(0);
  }
}
