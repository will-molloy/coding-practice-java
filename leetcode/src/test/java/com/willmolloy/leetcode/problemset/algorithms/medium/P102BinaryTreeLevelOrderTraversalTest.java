package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P102BinaryTreeLevelOrderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P102BinaryTreeLevelOrderTraversalTest {

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P102BinaryTreeLevelOrderTraversal.Dfs()),
        Arguments.of(new P102BinaryTreeLevelOrderTraversal.Bfs()));
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example(P102BinaryTreeLevelOrderTraversal fun) {
    TreeNode root = TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.levelOrder(root))
        .containsExactly(List.of(3), List.of(9, 20), List.of(15, 7))
        .inOrder();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void emptyTree(P102BinaryTreeLevelOrderTraversal fun) {
    assertThat(fun.levelOrder(null)).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void singleNodePerLeve(P102BinaryTreeLevelOrderTraversal fun) {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, null, 3, null, 4);
    assertThat(fun.levelOrder(root))
        .containsExactly(List.of(1), List.of(2), List.of(3), List.of(4))
        .inOrder();
  }
}
