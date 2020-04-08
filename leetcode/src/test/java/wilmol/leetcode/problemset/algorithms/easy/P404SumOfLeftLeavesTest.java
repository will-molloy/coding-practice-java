package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-08. */
class P404SumOfLeftLeavesTest {

  private final P404SumOfLeftLeaves fun = new P404SumOfLeftLeaves();

  @Test
  void example() {
    assertThat(fun.sumOfLeftLeaves(BinaryTreeNode.fromLevelOrder(3, 9, 20, null, null, 15, 7)))
        .isEqualTo(24);
  }

  @Test
  void oneNode() {
    assertThat(fun.sumOfLeftLeaves(BinaryTreeNode.fromLevelOrder(123))).isEqualTo(0);
  }

  @Test
  void noNodes() {
    assertThat(fun.sumOfLeftLeaves(null)).isEqualTo(0);
  }
}
