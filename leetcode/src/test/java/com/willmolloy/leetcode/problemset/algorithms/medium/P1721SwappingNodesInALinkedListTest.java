package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1721SwappingNodesInALinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1721SwappingNodesInALinkedListTest {

  private final P1721SwappingNodesInALinkedList p1721SwappingNodesInALinkedList =
      new P1721SwappingNodesInALinkedList();

  @ParameterizedTest
  @MethodSource
  void examples(ListNode head, int k, ListNode expected) {
    assertThat(p1721SwappingNodesInALinkedList.swapNodes(head, k)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ListNode.of(1, 2, 3, 4, 5), 2, ListNode.of(1, 4, 3, 2, 5)),
        Arguments.of(
            ListNode.of(7, 9, 6, 6, 7, 8, 3, 0, 9, 5),
            5,
            ListNode.of(7, 9, 6, 6, 8, 7, 3, 0, 9, 5)),
        Arguments.of(ListNode.of(1), 1, ListNode.of(1)),
        Arguments.of(ListNode.of(1, 2), 1, ListNode.of(2, 1)),
        Arguments.of(ListNode.of(1, 2, 3), 2, ListNode.of(1, 2, 3)));
  }
}
