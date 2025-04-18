package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.testlib.CartesianProduct.cartesianProduct;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1457PseudoPalindromicPathsInABinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1457PseudoPalindromicPathsInABinaryTreeTest {

  @ParameterizedTest
  @MethodSource
  void examples(P1457PseudoPalindromicPathsInABinaryTree p1457, TreeNode root, int expected) {
    assertThat(p1457.pseudoPalindromicPaths(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(funs(), args());
  }

  private static Stream<P1457PseudoPalindromicPathsInABinaryTree> funs() {
    return Stream.of(
        new P1457PseudoPalindromicPathsInABinaryTree.Array(),
        new P1457PseudoPalindromicPathsInABinaryTree.BitMask());
  }

  private static Stream<Arguments> args() {
    return Stream.of(
        Arguments.of(TreeNode.fromLevelOrder(2, 3, 1, 3, 1, null, 1), 2),
        Arguments.of(TreeNode.fromLevelOrder(2, 1, 1, 1, 3, null, null, null, null, null, 1), 1),
        Arguments.of(TreeNode.fromLevelOrder(9), 1));
  }
}
