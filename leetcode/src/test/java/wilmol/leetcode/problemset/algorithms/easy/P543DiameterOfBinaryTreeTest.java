package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-11. */
class P543DiameterOfBinaryTreeTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example(P543DiameterOfBinaryTree fun) {
    assertThat(fun.diameterOfBinaryTree(BinaryTreeNode.fromLevelOrder(1, 2, 3, 4, 5))).isEqualTo(3);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void bestNotThroughRoot(P543DiameterOfBinaryTree fun) {
    assertThat(
            fun.diameterOfBinaryTree(
                BinaryTreeNode.fromLevelOrder(1, 2, null, 3, 4, null, null, 5, null, 6)))
        .isEqualTo(4);
  }

  @ParameterizedTest
  @MethodSource("funs")
  void empty(P543DiameterOfBinaryTree fun) {
    assertThat(fun.diameterOfBinaryTree(null)).isEqualTo(0);
  }

  static Stream<P543DiameterOfBinaryTree> funs() {
    return Stream.of(
        new P543DiameterOfBinaryTree.Quadratic(), new P543DiameterOfBinaryTree.Linear());
  }
}
