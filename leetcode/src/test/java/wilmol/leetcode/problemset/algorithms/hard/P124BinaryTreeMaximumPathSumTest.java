package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-02-23. */
class P124BinaryTreeMaximumPathSumTest {

  private final P124BinaryTreeMaximumPathSum fun = new P124BinaryTreeMaximumPathSum();

  @Test
  void example1() {
    assertThat(fun.maxPathSum(BinaryTreeNode.fromLevelOrder(1, 2, 3))).isEqualTo(6);
  }

  @Test
  void example2() {
    assertThat(fun.maxPathSum(BinaryTreeNode.fromLevelOrder(-10, 9, 20, null, null, 15, 7)))
        .isEqualTo(42);
  }

  @Test
  void cutPathShort() {
    assertThat(fun.maxPathSum(BinaryTreeNode.fromLevelOrder(2, -1))).isEqualTo(2);
  }
}
