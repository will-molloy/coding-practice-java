package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.BinaryTreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-09. */
class P700SearchInABinarySearchTreeTest {

  @ParameterizedTest
  @MethodSource("p700")
  void exampleValOnLeft(P700SearchInABinarySearchTree p700) {
    assertThat(p700.searchBst(BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3), 2))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(2, 1, 3));
  }

  @ParameterizedTest
  @MethodSource("p700")
  void valOnRight(P700SearchInABinarySearchTree p700) {
    assertThat(p700.searchBst(BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3), 7))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(7));
  }

  @ParameterizedTest
  @MethodSource("p700")
  void valNotFound(P700SearchInABinarySearchTree p700) {
    assertThat(p700.searchBst(BinaryTreeNode.fromLevelOrder(4, 2, 7, 1, 3), 0)).isNull();
  }

  static Stream<P700SearchInABinarySearchTree> p700() {
    return Stream.of(
        new P700SearchInABinarySearchTree.Recursive(),
        new P700SearchInABinarySearchTree.Iterative());
  }
}
