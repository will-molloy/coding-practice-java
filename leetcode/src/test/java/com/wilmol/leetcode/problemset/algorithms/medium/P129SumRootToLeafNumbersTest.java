package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-03-11. */
class P129SumRootToLeafNumbersTest {

  @ParameterizedTest
  @MethodSource("p129")
  void example1(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(BinaryTreeNode.fromLevelOrder(1, 2, 3))).isEqualTo(25);
  }

  @ParameterizedTest
  @MethodSource("p129")
  void example2(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(BinaryTreeNode.fromLevelOrder(4, 9, 0, 5, 1))).isEqualTo(1026);
  }

  @ParameterizedTest
  @MethodSource("p129")
  void nullInput(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(null)).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("p129")
  void singlePath(P129SumRootToLeafNumbers p129) {
    assertThat(p129.sumNumbers(BinaryTreeNode.fromLevelOrder(1, 2, null, 3))).isEqualTo(123);
  }

  static Stream<P129SumRootToLeafNumbers> p129() {
    return Stream.of(new P129SumRootToLeafNumbers.Bfs(), new P129SumRootToLeafNumbers.Dfs());
  }
}
