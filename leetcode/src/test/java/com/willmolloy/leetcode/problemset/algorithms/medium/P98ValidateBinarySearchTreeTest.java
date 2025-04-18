package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P98ValidateBinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P98ValidateBinarySearchTreeTest {

  private final P98ValidateBinarySearchTree fun = new P98ValidateBinarySearchTree();

  @Test
  void example1() {
    TreeNode root = TreeNode.fromLevelOrder(2, 1, 3);
    assertThat(fun.isValidBst(root)).isTrue();
  }

  @Test
  void example2() {
    TreeNode root = TreeNode.fromLevelOrder(5, 1, 4);
    assertThat(fun.isValidBst(root)).isFalse();
  }

  @Test
  void brokenNotByDirectChild() {
    TreeNode root = TreeNode.fromLevelOrder(5, 1, 6, null, null, 4);
    assertThat(fun.isValidBst(root)).isFalse();
  }
}
