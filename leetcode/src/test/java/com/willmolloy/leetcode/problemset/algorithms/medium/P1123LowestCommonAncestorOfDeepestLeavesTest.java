package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P1123LowestCommonAncestorOfDeepestLeavesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1123LowestCommonAncestorOfDeepestLeavesTest {

  private final P1123LowestCommonAncestorOfDeepestLeaves p1123 =
      new P1123LowestCommonAncestorOfDeepestLeaves();

  @Test
  void example1() {
    TreeNode root = TreeNode.fromLevelOrder(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4);
    assertThat(p1123.lcaDeepestLeaves(root)).isSameInstanceAs(root.left.right);
  }

  @Test
  void example2() {
    TreeNode root = new TreeNode(1);
    assertThat(p1123.lcaDeepestLeaves(root)).isSameInstanceAs(root);
  }

  @Test
  void example3() {
    TreeNode root = TreeNode.fromLevelOrder(0, 1, 3, null, 2);
    assertThat(p1123.lcaDeepestLeaves(root)).isSameInstanceAs(root.left.right);
  }
}
