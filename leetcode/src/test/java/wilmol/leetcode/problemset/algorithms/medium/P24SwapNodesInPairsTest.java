package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by Will on 2019-07-25 at 19:58. */
class P24SwapNodesInPairsTest {

  private final P24SwapNodesInPairs fun = new P24SwapNodesInPairs();

  @Test
  void example() {
    assertThat(fun.swapPairs(ListNode.of(1, 2, 3, 4))).isEqualTo(ListNode.of(2, 1, 4, 3));
  }

  @Test
  void manyNodes() {
    assertThat(fun.swapPairs(ListNode.of(1, 2, 3, 4, 5, 6)))
        .isEqualTo(ListNode.of(2, 1, 4, 3, 6, 5));
  }

  @Test
  void singleNode() {
    assertThat(fun.swapPairs(ListNode.of(1))).isEqualTo(ListNode.of(1));
  }

  @Test
  void oddAmountOfRows() {
    assertThat(fun.swapPairs(ListNode.of(1, 2, 3))).isEqualTo(ListNode.of(2, 1, 3));
    assertThat(fun.swapPairs(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(2, 1, 4, 3, 5));
  }

  @Test
  void noNodes() {
    assertThat(fun.swapPairs(null)).isEqualTo(null);
  }
}
