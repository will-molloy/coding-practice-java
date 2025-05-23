package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P129SumRootToLeafNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P129SumRootToLeafNumbersTest {

  @ParameterizedTest
  @MethodSource("p129")
  void example1(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(TreeNode.fromLevelOrder(1, 2, 3))).isEqualTo(25);
  }

  @ParameterizedTest
  @MethodSource("p129")
  void example2(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(TreeNode.fromLevelOrder(4, 9, 0, 5, 1))).isEqualTo(1026);
  }

  @ParameterizedTest
  @MethodSource("p129")
  void nullInput(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(null)).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("p129")
  void singlePath(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(TreeNode.fromLevelOrder(1, 2, null, 3))).isEqualTo(123);
  }

  static Stream<P129SumRootToLeafNumbers> p129() {
    return Stream.of(new P129SumRootToLeafNumbers.Bfs(), new P129SumRootToLeafNumbers.Dfs());
  }
}
