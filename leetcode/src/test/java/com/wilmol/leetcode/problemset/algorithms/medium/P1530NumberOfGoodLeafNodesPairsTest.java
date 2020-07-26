package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1530NumberOfGoodLeafNodesPairsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1530NumberOfGoodLeafNodesPairsTest {

  private final P1530NumberOfGoodLeafNodesPairs p1530 = new P1530NumberOfGoodLeafNodesPairs();

  @ParameterizedTest
  @MethodSource
  void examples(BinaryTreeNode root, int distance, int expected) {
    assertThat(p1530.countPairs(root, distance)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(BinaryTreeNode.fromLevelOrder(1, 2, 3, null, 4), 3, 1),
        Arguments.of(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5, 6, 7), 3, 2),
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(7, 1, 4, 6, null, 5, 3, null, null, null, null, null, 2),
            3,
            1),
        Arguments.of(BinaryTreeNode.fromLevelOrder(100), 1, 0),
        Arguments.of(BinaryTreeNode.fromLevelOrder(1, 1, 1), 2, 1));
  }
}
