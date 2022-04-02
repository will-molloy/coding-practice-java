package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P701InsertIntoABinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P701InsertIntoABinarySearchTreeTest {

  private final P701InsertIntoABinarySearchTree p701 = new P701InsertIntoABinarySearchTree();

  @Test
  void example1() {
    assertThat(p701.insertIntoBST(BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3), 5))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3, 5));
  }

  @Test
  void example2() {
    assertThat(p701.insertIntoBST(BinaryTreeNode.fromLevelOrder(40, 20, 60, 10, 30, 50, 70), 25))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(40, 20, 60, 10, 30, 50, 70, null, null, 25));
  }

  @Test
  void initiallyEmptyTree() {
    assertThat(p701.insertIntoBST(null, 1)).isEqualTo(BinaryTreeNode.fromLevelOrder(1));
  }
}
