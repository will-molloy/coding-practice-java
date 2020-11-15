package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1026MaximumDifferenceBetweenNodeAndAncestorTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1026MaximumDifferenceBetweenNodeAndAncestorTest {

  private final P1026MaximumDifferenceBetweenNodeAndAncestor p1026 =
      new P1026MaximumDifferenceBetweenNodeAndAncestor();

  @ParameterizedTest
  @MethodSource
  void examples(BinaryTreeNode root, int expected) {
    assertThat(p1026.maxAncestorDiff(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(
                8, 3, 10, 1, 6, null, 14, null, null, 4, 7, null, null, 13),
            7),
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(
                1, null, 2, null, null, null, 0, null, null, null, null, null, null, 3),
            3));
  }
}
