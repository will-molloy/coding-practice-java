package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by wilmol on 2020-02-08. */
class P92ReverseLinkedList2Test {

  private final P92ReverseLinkedList2 func = new P92ReverseLinkedList2();

  @Test
  void example() {
    assertThat(func.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 2, 4))
        .isEqualTo(ListNode.of(1, 4, 3, 2, 5));
  }

  @Test
  void reverseWholeRange() {
    assertThat(func.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 1, 5))
        .isEqualTo(ListNode.of(5, 4, 3, 2, 1));
  }

  @Test
  void reverseStart() {
    assertThat(func.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 1, 2))
        .isEqualTo(ListNode.of(2, 1, 3, 4, 5));
  }

  @Test
  void reverseEnd() {
    assertThat(func.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 4, 5))
        .isEqualTo(ListNode.of(1, 2, 3, 5, 4));
  }

  @Test
  void reverseSingletonRange() {
    assertThat(func.reverseBetween(ListNode.of(1, 2, 3, 4, 5), 3, 3))
        .isEqualTo(ListNode.of(1, 2, 3, 4, 5));
  }
}
