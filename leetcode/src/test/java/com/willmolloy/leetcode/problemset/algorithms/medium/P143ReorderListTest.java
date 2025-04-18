package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P143ReorderListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P143ReorderListTest {

  private final P143ReorderList p143 = new P143ReorderList();

  @ParameterizedTest
  @MethodSource
  void examples(ListNode head, ListNode expected) {
    p143.reorderList(head);
    assertThat(head).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ListNode.of(1, 2, 3, 4), ListNode.of(1, 4, 2, 3)),
        Arguments.of(ListNode.of(1, 2, 3, 4, 5), ListNode.of(1, 5, 2, 4, 3)));
  }

  @Test
  void emptyList() {
    p143.reorderList(null);
  }

  @Test
  void singletonList() {
    ListNode head = ListNode.of(1);
    p143.reorderList(head);
    assertThat(head).isEqualTo(ListNode.of(1));
  }
}
