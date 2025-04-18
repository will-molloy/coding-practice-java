package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P100SameTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P100SameTreeTest {

  private final P100SameTree func = new P100SameTree();

  @Test
  void example1() {
    TreeNode p = TreeNode.fromLevelOrder(1, 2, 3);
    TreeNode q = TreeNode.fromLevelOrder(1, 2, 3);

    assertThat(func.isSameTree(p, q)).isTrue();
  }

  @Test
  void example2() {
    TreeNode p = TreeNode.fromLevelOrder(1, 2);
    TreeNode q = TreeNode.fromLevelOrder(1, null, 2);

    assertThat(func.isSameTree(p, q)).isFalse();
  }

  @Test
  void example3() {
    TreeNode p = TreeNode.fromLevelOrder(1, 2, 1);
    TreeNode q = TreeNode.fromLevelOrder(1, 1, 2);

    assertThat(func.isSameTree(p, q)).isFalse();
  }
}
