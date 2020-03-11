package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-03-11. */
class P129SumRootToLeafNumbersTest {

  private final P129SumRootToLeafNumbers fun = new P129SumRootToLeafNumbers();

  @Test
  void example1() {
    assertThat(fun.sumNumbers(BinaryTreeNode.fromLevelOrder(1, 2, 3))).isEqualTo(25);
  }

  @Test
  void example2() {
    assertThat(fun.sumNumbers(BinaryTreeNode.fromLevelOrder(4, 9, 0, 5, 1))).isEqualTo(1026);
  }

  @Test
  void nullInput() {
    assertThat(fun.sumNumbers(null)).isEqualTo(0);
  }

  @Test
  void singlePath() {
    assertThat(fun.sumNumbers(BinaryTreeNode.fromLevelOrder(1, 2, null, 3))).isEqualTo(123);
  }
}
