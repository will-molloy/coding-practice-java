package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1305AllElementsInTwoBinarySearchTreesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1305AllElementsInTwoBinarySearchTreesTest {

  private final P1305AllElementsInTwoBinarySearchTrees p1305 =
      new P1305AllElementsInTwoBinarySearchTrees();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root1, TreeNode root2, List<Integer> expected) {
    assertThat(p1305.getAllElements(root1, root2)).containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            TreeNode.fromLevelOrder(2, 1, 4),
            TreeNode.fromLevelOrder(1, 0, 3),
            List.of(0, 1, 1, 2, 3, 4)),
        Arguments.of(
            TreeNode.fromLevelOrder(0, -10, 10),
            TreeNode.fromLevelOrder(5, 1, 7, 0, 2),
            List.of(-10, 0, 0, 1, 2, 5, 7, 10)),
        Arguments.of(null, TreeNode.fromLevelOrder(5, 1, 7, 0, 2), List.of(0, 1, 2, 5, 7)),
        Arguments.of(TreeNode.fromLevelOrder(0, -10, 10), null, List.of(-10, 0, 10)),
        Arguments.of(
            TreeNode.fromLevelOrder(1, null, 8),
            TreeNode.fromLevelOrder(8, 1),
            List.of(1, 1, 8, 8)));
  }
}
