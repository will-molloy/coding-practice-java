package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1026MaximumDifferenceBetweenNodeAndAncestorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1026MaximumDifferenceBetweenNodeAndAncestorTest {

  private final P1026MaximumDifferenceBetweenNodeAndAncestor p1026 =
      new P1026MaximumDifferenceBetweenNodeAndAncestor();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root, int expected) {
    assertThat(p1026.maxAncestorDiff(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(TreeNode.fromLevelOrder(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13), 7),
        Arguments.of(TreeNode.fromLevelOrder(1, null, 2, null, 0, 3), 3));
  }
}
