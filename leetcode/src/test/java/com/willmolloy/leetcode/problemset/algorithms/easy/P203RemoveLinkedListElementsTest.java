package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P203RemoveLinkedListElementsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P203RemoveLinkedListElementsTest {

  private final P203RemoveLinkedListElements p203 = new P203RemoveLinkedListElements();

  @Test
  void example() {
    assertThat(p203.removeElements(ListNode.of(1, 2, 6, 3, 4, 5, 6), 6))
        .isEqualTo(ListNode.of(1, 2, 3, 4, 5));
  }

  @Test
  void removeFromStart() {
    assertThat(p203.removeElements(ListNode.of(1, 1, 1, 2, 3), 1)).isEqualTo(ListNode.of(2, 3));
  }

  @Test
  void removeFromEnd() {
    assertThat(p203.removeElements(ListNode.of(1, 2, 3, 3, 3), 3)).isEqualTo(ListNode.of(1, 2));
  }

  @Test
  void removeFromMiddle() {
    assertThat(p203.removeElements(ListNode.of(1, 2, 2, 2, 3), 2)).isEqualTo(ListNode.of(1, 3));
  }

  @Test
  void removeAll() {
    assertThat(p203.removeElements(ListNode.of(1, 1, 1), 1)).isNull();
  }

  @Test
  void removeAlternating() {
    assertThat(p203.removeElements(ListNode.of(1, 2, 1, 2, 1, 2, 1), 1))
        .isEqualTo(ListNode.of(2, 2, 2));
  }
}
