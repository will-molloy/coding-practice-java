package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P669TrimABinarySearchTreeTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P669TrimABinarySearchTreeTest {

  private final P669TrimABinarySearchTree p669TrimABinarySearchTree =
      new P669TrimABinarySearchTree();

  @ParameterizedTest
  @MethodSource
  void examples(BinaryTreeNode root, int low, int high, BinaryTreeNode expected) {
    assertThat(p669TrimABinarySearchTree.trimBst(root, low, high)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(1, 0, 2),
            1,
            2,
            BinaryTreeNode.fromLevelOrder(1, null, 2)),
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(3, 0, 4, null, 2, null, null, null, null, 1),
            1,
            3,
            BinaryTreeNode.fromLevelOrder(3, 2, null, 1)),
        Arguments.of(BinaryTreeNode.fromLevelOrder(1), 1, 2, BinaryTreeNode.fromLevelOrder(1)),
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(1, null, 2),
            1,
            3,
            BinaryTreeNode.fromLevelOrder(1, null, 2)),
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(1, null, 2), 2, 4, BinaryTreeNode.fromLevelOrder(2)));
  }
}
