package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.willmolloy.leetcode.common.ListNode;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1019NextGreaterNodeInLinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1019NextGreaterNodeInLinkedListTest {

  private final P1019NextGreaterNodeInLinkedList p1019 = new P1019NextGreaterNodeInLinkedList();

  @ParameterizedTest
  @MethodSource
  void examples(ListNode head, List<Integer> expected) {
    assertThat(p1019.nextLargerNodes(head)).asList().containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(ListNode.of(2, 1, 5), ImmutableList.of(5, 5, 0)),
        Arguments.of(ListNode.of(2, 7, 4, 3, 5), ImmutableList.of(7, 0, 5, 5, 0)),
        Arguments.of(
            ListNode.of(1, 7, 5, 1, 9, 2, 5, 1), ImmutableList.of(7, 9, 9, 9, 0, 5, 0, 0)));
  }
}
