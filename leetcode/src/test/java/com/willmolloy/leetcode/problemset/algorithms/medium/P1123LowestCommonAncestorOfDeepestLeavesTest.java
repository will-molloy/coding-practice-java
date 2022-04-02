package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1123LowestCommonAncestorOfDeepestLeavesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1123LowestCommonAncestorOfDeepestLeavesTest {

  private final P1123LowestCommonAncestorOfDeepestLeaves p1123 =
      new P1123LowestCommonAncestorOfDeepestLeaves();

  @Test
  void example1() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    assertThat(p1123.lcaDeepestLeaves(root)).isSameInstanceAs(root.left.right);
  }

  @Test
  void example2() {
    BinaryTreeNode root = new BinaryTreeNode(1);
    assertThat(p1123.lcaDeepestLeaves(root)).isSameInstanceAs(root);
  }

  @Test
  void example3() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(0, 1, 3, null, 2);
    assertThat(p1123.lcaDeepestLeaves(root)).isSameInstanceAs(root.left.right);
  }
}
