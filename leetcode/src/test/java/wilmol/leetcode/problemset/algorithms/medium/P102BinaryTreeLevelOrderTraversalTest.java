package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-11. */
class P102BinaryTreeLevelOrderTraversalTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example(P102BinaryTreeLevelOrderTraversal fun) {
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7);
    assertThat(fun.levelOrder(root))
        .containsExactly(ImmutableList.of(3), ImmutableList.of(9, 20), ImmutableList.of(15, 7))
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
    BinaryTreeNode root = BinaryTreeNode.fromLevelOrder(1, 2, null, 3, null, null, null, 4);
    assertThat(fun.levelOrder(root))
        .containsExactly(
            ImmutableList.of(1), ImmutableList.of(2), ImmutableList.of(3), ImmutableList.of(4))
        .inOrder();
  }

  static Stream<Arguments> funs() {
    return Stream.of(
        Arguments.of(new P102BinaryTreeLevelOrderTraversal.Dfs()),
        Arguments.of(new P102BinaryTreeLevelOrderTraversal.Bfs()));
  }
}
