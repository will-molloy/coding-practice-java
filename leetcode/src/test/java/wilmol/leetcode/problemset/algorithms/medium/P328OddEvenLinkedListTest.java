package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by wilmol on 2020-05-16. */
class P328OddEvenLinkedListTest {

  private final P328OddEvenLinkedList p328 = new P328OddEvenLinkedList();

  @Test
  void example1() {
    assertThat(p328.oddEvenList(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(1, 3, 5, 2, 4));
  }

  @Test
  void example2() {
    assertThat(p328.oddEvenList(ListNode.of(2, 1, 3, 5, 6, 4, 7)))
        .isEqualTo(ListNode.of(2, 3, 6, 7, 1, 5, 4));
  }

  @Test
  void emptyList() {
    assertThat(p328.oddEvenList(null)).isNull();
  }

  @Test
  void oneElement() {
    assertThat(p328.oddEvenList(ListNode.of(1))).isEqualTo(ListNode.of(1));
  }

  @Test
  void twoElements() {
    assertThat(p328.oddEvenList(ListNode.of(1, 2))).isEqualTo(ListNode.of(1, 2));
  }

  @Test
  void threeElements() {
    assertThat(p328.oddEvenList(ListNode.of(1, 2, 3))).isEqualTo(ListNode.of(1, 3, 2));
  }
}
