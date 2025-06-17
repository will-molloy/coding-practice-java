package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.TreeNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link P104MaximumDepthOfBinaryTree}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P104MaximumDepthOfBinaryTreeTest {

  static Stream<Arguments> solutions() {
    return Stream.of(
        Arguments.of(new P104MaximumDepthOfBinaryTree.Dfs()),
        Arguments.of(new P104MaximumDepthOfBinaryTree.Bfs()));
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example1(P104MaximumDepthOfBinaryTree solution) {
    TreeNode root = TreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(solution.maxDepth(root)).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void example2(P104MaximumDepthOfBinaryTree solution) {
    TreeNode root = TreeNode.fromLevelOrder(1, null, 2);
    assertThat(solution.maxDepth(root)).isEqualTo(2);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void emptyTree(P104MaximumDepthOfBinaryTree solution) {
    assertThat(solution.maxDepth(null)).isEqualTo(0);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void singleNodePerLevel(P104MaximumDepthOfBinaryTree solution) {
    TreeNode root = TreeNode.fromLevelOrder(1, 2, null, 3, null, 4);
    assertThat(solution.maxDepth(root)).isEqualTo(4);
  }
}
