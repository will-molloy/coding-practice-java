package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P700SearchInABinarySearchTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P700SearchInABinarySearchTreeTest {

  @ParameterizedTest
  @MethodSource("p700")
  void exampleValOnLeft(P700SearchInABinarySearchTree p700) {
    assertThat(p700.searchBst(TreeNode.fromLevelOrder(4, 2, 7, 1, 3), 2))
        .isEqualTo(TreeNode.fromLevelOrder(2, 1, 3));
  }

  @ParameterizedTest
  @MethodSource("p700")
  void valOnRight(P700SearchInABinarySearchTree p700) {
    assertThat(p700.searchBst(TreeNode.fromLevelOrder(4, 2, 7, 1, 3), 7))
        .isEqualTo(TreeNode.fromLevelOrder(7));
  }

  @ParameterizedTest
  @MethodSource("p700")
  void valNotFound(P700SearchInABinarySearchTree p700) {
    assertThat(p700.searchBst(TreeNode.fromLevelOrder(4, 2, 7, 1, 3), 0)).isNull();
  }

  static Stream<P700SearchInABinarySearchTree> p700() {
    return Stream.of(
        new P700SearchInABinarySearchTree.Recursive(),
        new P700SearchInABinarySearchTree.Iterative());
  }
}
