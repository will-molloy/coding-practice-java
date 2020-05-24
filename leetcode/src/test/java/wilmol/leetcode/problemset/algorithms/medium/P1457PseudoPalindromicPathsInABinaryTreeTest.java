package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static wilmol.testlib.TestLib.cartesianProduct;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-05-24. */
class P1457PseudoPalindromicPathsInABinaryTreeTest {

  @ParameterizedTest
  @MethodSource
  void examples(P1457PseudoPalindromicPathsInABinaryTree p1457, BinaryTreeNode root, int expected) {
    assertThat(p1457.pseudoPalindromicPaths(root)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(funs(), args());
  }

  private static List<Arguments> funs() {
    return ImmutableList.of(
        Arguments.of(new P1457PseudoPalindromicPathsInABinaryTree.Array()),
        Arguments.of(new P1457PseudoPalindromicPathsInABinaryTree.BitMask()));
  }

  private static List<Arguments> args() {
    return ImmutableList.of(
        Arguments.of(BinaryTreeNode.fromLevelOrder(2, 3, 1, 3, 1, null, 1), 2),
        Arguments.of(
            BinaryTreeNode.fromLevelOrder(2, 1, 1, 1, 3, null, null, null, null, null, 1), 1),
        Arguments.of(BinaryTreeNode.fromLevelOrder(9), 1));
  }
}
