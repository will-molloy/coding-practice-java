package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1008ConstructBinarySearchTreeFromPreorderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1008ConstructBinarySearchTreeFromPreorderTraversalTest {

  @ParameterizedTest
  @MethodSource("p1008")
  void example(P1008ConstructBinarySearchTreeFromPreorderTraversal p1008) {
    assertThat(p1008.bstFromPreorder(new int[] {8, 5, 1, 7, 10, 12}))
        .isEqualTo(TreeNode.fromLevelOrder(8, 5, 10, 1, 7, null, 12));
  }

  @ParameterizedTest
  @MethodSource("p1008")
  void emptyArray(P1008ConstructBinarySearchTreeFromPreorderTraversal p1008) {
    assertThat(p1008.bstFromPreorder(new int[0])).isEqualTo(null);
  }

  static Stream<P1008ConstructBinarySearchTreeFromPreorderTraversal> p1008() {
    return Stream.of(
        new P1008ConstructBinarySearchTreeFromPreorderTraversal.SplitLeftAndRight(),
        new P1008ConstructBinarySearchTreeFromPreorderTraversal.ProvideUpperBound());
  }
}
