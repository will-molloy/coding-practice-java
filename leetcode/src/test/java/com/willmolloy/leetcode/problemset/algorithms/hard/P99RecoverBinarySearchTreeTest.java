package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import org.junit.jupiter.api.Test;

/**
 * P99RecoverBinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P99RecoverBinarySearchTreeTest {

  private final P99RecoverBinarySearchTree p99 = new P99RecoverBinarySearchTree();

  @Test
  void example1() {
    // inorder: [3, 2, 1] -> (swap 3 and 1) -> [1, 2, 3]
    TreeNode root = TreeNode.fromLevelOrder(1, 3, null, null, 2);
    p99.recoverTree(root);
    assertThat(root).isEqualTo(TreeNode.fromLevelOrder(3, 1, null, null, 2));
  }

  @Test
  void example2() {
    // inorder: [1, 3, 2, 4] -> (swap 3 and 2) -> [1, 2, 3, 4]
    TreeNode root = TreeNode.fromLevelOrder(3, 1, 4, null, null, 2);
    p99.recoverTree(root);
    assertThat(root).isEqualTo(TreeNode.fromLevelOrder(2, 1, 4, null, null, 3));
  }
}
