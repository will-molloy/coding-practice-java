package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.BinaryTreeNode;

/** Created by wilmol on 2020-04-03. */
class P1315SumOfNodesWithEvenValuedGrandparentTest {

  private final P1315SumOfNodesWithEvenValuedGrandparent fun =
      new P1315SumOfNodesWithEvenValuedGrandparent();

  @Test
  void example1() {
    assertThat(
            fun.sumEvenGrandparent(
                BinaryTreeNode.fromLevelOrder(
                    6, 7, 8, 2, 7, 1, 3, 9, null, 1, 4, null, null, null, 5)))
        .isEqualTo(18);
  }
}
