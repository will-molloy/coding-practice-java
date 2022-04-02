package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P865SmallestSubtreeWithAllTheDeepestNodesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P865SmallestSubtreeWithAllTheDeepestNodesTest {

  private final P865SmallestSubtreeWithAllTheDeepestNodes p865 =
      new P865SmallestSubtreeWithAllTheDeepestNodes();

  @Test
  void example1() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    assertThat(p865.subtreeWithAllDeepest(root)).isSameInstanceAs(root.left.right);
  }

  @Test
  void example2() {
    BinaryTreeNode root = new BinaryTreeNode(1);
    assertThat(p865.subtreeWithAllDeepest(root)).isSameInstanceAs(root);
  }

  @Test
  void example3() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(0, 1, 3, null, 2);
    assertThat(p865.subtreeWithAllDeepest(root)).isSameInstanceAs(root.left.right);
  }
}
