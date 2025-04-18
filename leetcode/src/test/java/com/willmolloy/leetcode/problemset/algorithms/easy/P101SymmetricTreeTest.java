package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P101SymmetricTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P101SymmetricTreeTest {

  private final P101SymmetricTree func = new P101SymmetricTree();

  @Test
  void example1() {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, 2, 3, 4, 4, 3);
    assertThat(func.isSymmetric(root)).isTrue();
  }

  @Test
  void example2() {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, 2, null, 3, null, 3);
    assertThat(func.isSymmetric(root)).isFalse();
  }
}
