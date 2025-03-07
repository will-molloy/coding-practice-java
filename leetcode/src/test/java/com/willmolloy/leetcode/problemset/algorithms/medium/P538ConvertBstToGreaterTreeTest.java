package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P538ConvertBstToGreaterTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P538ConvertBstToGreaterTreeTest {

  private final P538ConvertBstToGreaterTree p538 = new P538ConvertBstToGreaterTree();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root, TreeNode expected) {
    assertThat(p538.convertBst(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            TreeNode.fromLevelOrder(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8),
            TreeNode.fromLevelOrder(
                30, 36, 21, 36, 35, 26, 15, null, null, null, 33, null, null, null, 8)),
        Arguments.of(TreeNode.fromLevelOrder(0, null, 1), TreeNode.fromLevelOrder(1, null, 1)),
        Arguments.of(TreeNode.fromLevelOrder(1, 0, 2), TreeNode.fromLevelOrder(3, 3, 2)),
        Arguments.of(TreeNode.fromLevelOrder(3, 2, 4, 1), TreeNode.fromLevelOrder(7, 9, 4, 10)));
  }
}
