package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P337HouseRobber3Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P337HouseRobber3Test {

  private final P337HouseRobber3 p337 = new P337HouseRobber3();

  @ParameterizedTest
  @MethodSource
  void examples(TreeNode root, int expected) {
    assertThat(p337.rob(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(TreeNode.fromLevelOrder(3, 2, 3, null, 3, null, 1), 7),
        Arguments.of(TreeNode.fromLevelOrder(3, 4, 5, 1, 3, null, 1), 9));
  }
}
