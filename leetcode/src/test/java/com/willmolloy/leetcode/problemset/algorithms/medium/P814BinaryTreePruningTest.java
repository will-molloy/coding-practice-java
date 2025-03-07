package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P814BinaryTreePruningTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P814BinaryTreePruningTest {

  private final P814BinaryTreePruning p814BinaryTreePruning = new P814BinaryTreePruning();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root, TreeNode expected) {
    assertThat(p814BinaryTreePruning.pruneTree(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            TreeNode.fromLevelOrder(1, null, 0, null, null, 0, 1),
            TreeNode.fromLevelOrder(1, null, 0, null, null, null, 1)),
        Arguments.of(
            TreeNode.fromLevelOrder(1, 0, 1, 0, 0, 0, 1),
            TreeNode.fromLevelOrder(1, null, 1, null, null, null, 1)),
        Arguments.of(
            TreeNode.fromLevelOrder(1, 1, 0, 1, 1, 0, 1, 0),
            TreeNode.fromLevelOrder(1, 1, 0, 1, 1, null, 1)));
  }
}
