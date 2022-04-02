package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P104MaximumDepthOfBinaryTreeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P104MaximumDepthOfBinaryTreeTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example(P104MaximumDepthOfBinaryTree fun) {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.maxDepth(root)).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void emptyTree(P104MaximumDepthOfBinaryTree fun) {
    assertThat(fun.maxDepth(null)).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void singleNodePerLevel(P104MaximumDepthOfBinaryTree fun) {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, null, 3, null, null, null, 4);
    assertThat(fun.maxDepth(root)).isEqualTo(4);
  }

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P104MaximumDepthOfBinaryTree.Dfs()),
        Arguments.of(new P104MaximumDepthOfBinaryTree.Bfs()));
  }
}
