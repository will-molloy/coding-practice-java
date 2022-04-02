package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P147InsertionSortLinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P147InsertionSortLinkedListTest {

  private final P147InsertionSortLinkedList p147 = new P147InsertionSortLinkedList();

  @ParameterizedTest
  @MethodSource
  void examples(ListNode head, ListNode expected) {
    assertThat(p147.insertionSortList(head)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ListNode.of(4, 2, 1, 3), ListNode.of(1, 2, 3, 4)),
        Arguments.of(ListNode.of(-1, 5, 3, 4, 0), ListNode.of(-1, 0, 3, 4, 5)),
        Arguments.of(null, null));
  }
}
