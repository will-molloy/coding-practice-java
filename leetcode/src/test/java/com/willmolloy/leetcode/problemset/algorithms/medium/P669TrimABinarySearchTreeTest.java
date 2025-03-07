package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P669TrimABinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P669TrimABinarySearchTreeTest {

  private final P669TrimABinarySearchTree p669TrimABinarySearchTree =
      new P669TrimABinarySearchTree();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root, int low, int high, TreeNode expected) {
    assertThat(p669TrimABinarySearchTree.trimBst(root, low, high)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(TreeNode.fromLevelOrder(1, 0, 2), 1, 2, TreeNode.fromLevelOrder(1, null, 2)),
        Arguments.of(
            TreeNode.fromLevelOrder(3, 0, 4, null, 2, null, null, null, null, 1),
            1,
            3,
            TreeNode.fromLevelOrder(3, 2, null, 1)),
        Arguments.of(TreeNode.fromLevelOrder(1), 1, 2, TreeNode.fromLevelOrder(1)),
        Arguments.of(
            TreeNode.fromLevelOrder(1, null, 2), 1, 3, TreeNode.fromLevelOrder(1, null, 2)),
        Arguments.of(TreeNode.fromLevelOrder(1, null, 2), 2, 4, TreeNode.fromLevelOrder(2)));
  }
}
