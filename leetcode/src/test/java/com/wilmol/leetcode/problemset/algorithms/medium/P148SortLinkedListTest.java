package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P148SortLinkedListTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P148SortLinkedListTest {

  private final P148SortLinkedList p148 = new P148SortLinkedList();

  @ParameterizedTest
  @MethodSource
  void examples(ListNode head, ListNode expected) {
    assertThat(p148.sortList(head)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ListNode.of(4, 2, 1, 3), ListNode.of(1, 2, 3, 4)),
        Arguments.of(ListNode.of(-1, 5, 3, 4, 0), ListNode.of(-1, 0, 3, 4, 5)),
        Arguments.of(null, null));
  }
}
