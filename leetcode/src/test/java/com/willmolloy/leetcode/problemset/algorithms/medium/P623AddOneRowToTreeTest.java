package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import org.junit.jupiter.api.Test;

/**
 * P623AddOneRowToTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P623AddOneRowToTreeTest {

  private final P623AddOneRowToTree p623AddOneRowToTree = new P623AddOneRowToTree();

  @Test
  void example1() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(4, 2, 6, 3, 1, 5);
    assertThat(p623AddOneRowToTree.addOneRow(root, 1, 2))
        .isEqualTo(
            BinaryTreeNode.fromLevelOrder(
                4, 1, 1, 2, null, null, 6, 3, 1, null, null, null, null, 5));
  }

  @Test
  void example2() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(4, 2, null, 3, 1);
    assertThat(p623AddOneRowToTree.addOneRow(root, 1, 3))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(4, 2, null, 1, 1, null, null, 3, null, null, 1));
  }

  @Test
  void insertNewRoot() {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1);
    assertThat(p623AddOneRowToTree.addOneRow(root, 9, 1))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(9, 1));
  }
}
