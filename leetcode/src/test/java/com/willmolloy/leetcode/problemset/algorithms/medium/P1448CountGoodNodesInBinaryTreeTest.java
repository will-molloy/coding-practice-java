package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1448CountGoodNodesInBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1448CountGoodNodesInBinaryTreeTest {

  private final P1448CountGoodNodesInBinaryTree p1448CountGoodNodesInBinaryTree =
      new P1448CountGoodNodesInBinaryTree();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root, int expected) {
    assertThat(p1448CountGoodNodesInBinaryTree.goodNodes(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(TreeNode.fromLevelOrder(3, 1, 4, 3, null, 1, 5), 4),
        Arguments.of(TreeNode.fromLevelOrder(3, 3, null, 4, 2), 3),
        Arguments.of(TreeNode.fromLevelOrder(1), 1));
  }
}
