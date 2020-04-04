package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-04. */
class P1325DeleteLeavesWithAGivenValueTest {

  private final P1325DeleteLeavesWithAGivenValue fun = new P1325DeleteLeavesWithAGivenValue();

  @Test
  void example1() {
    assertThat(fun.removeLeafNodes(BinaryTreeNode.fromLevelOrder(1, 2, 3, 2, null, 2, 4), 2))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(1, null, 3, null, null, null, 4));
  }

  @Test
  void example2() {
    assertThat(fun.removeLeafNodes(BinaryTreeNode.fromLevelOrder(1, 3, 3, 3, 2), 3))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(1, 3, null, null, 2));
  }

  @Test
  void example3() {
    assertThat(
            fun.removeLeafNodes(
                BinaryTreeNode.fromLevelOrder(1, 2, null, 2, null, null, null, 2), 2))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(1));
  }

  @Test
  void example4() {
    assertThat(fun.removeLeafNodes(BinaryTreeNode.fromLevelOrder(1, 1, 1), 1)).isNull();
  }

  @Test
  void example5() {
    assertThat(fun.removeLeafNodes(BinaryTreeNode.fromLevelOrder(1, 2, 3), 1))
        .isEqualTo(BinaryTreeNode.fromLevelOrder(1, 2, 3));
  }
}
