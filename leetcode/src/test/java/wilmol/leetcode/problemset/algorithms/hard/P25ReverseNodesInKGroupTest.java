package wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by Will on 2019-07-25 at 20:13. */
class P25ReverseNodesInKGroupTest {

  private final P25ReverseNodesInKGroup fun = new P25ReverseNodesInKGroup();

  @Test
  void exampleKOf2FitsTwice() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 2))
        .isEqualTo(ListNode.of(2, 1, 4, 3, 5));
  }

  @Test
  void exampleKOf3LeftOutNodesRemainAsIs() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 3))
        .isEqualTo(ListNode.of(3, 2, 1, 4, 5));
  }

  @Test
  void kOf5FitsOnce() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 5))
        .isEqualTo(ListNode.of(5, 4, 3, 2, 1));
  }

  @Test
  void kOf1() {
    assertThat(fun.reverseKGroup(ListNode.of(1, 2, 3, 4, 5), 1))
        .isEqualTo(ListNode.of(1, 2, 3, 4, 5));
  }

  @Test
  void noNodes() {
    assertThat(fun.reverseKGroup(null, 2)).isEqualTo(null);
  }
}
