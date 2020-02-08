package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.leetcode.common.ListNode;

/** Created by wilmol on 2020-02-08. */
class P206ReverseLinkedListTest {

  private final P206ReverseLinkedList func = new P206ReverseLinkedList();

  @Test
  void example() {
    assertThat(func.reverseList(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(5, 4, 3, 2, 1));
  }

  @Test
  void emptyList() {
    assertThat(func.reverseList(ListNode.of())).isEqualTo(null);
  }

  @Test
  void singletonList() {
    assertThat(func.reverseList(ListNode.of(1))).isEqualTo(ListNode.of(1));
  }
}
