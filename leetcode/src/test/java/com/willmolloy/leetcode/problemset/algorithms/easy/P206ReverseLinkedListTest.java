package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P206ReverseLinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P206ReverseLinkedListTest {

  @ParameterizedTest
  @MethodSource("p206")
  void example(P206ReverseLinkedList p206) {
    assertThat(p206.reverseList(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(5, 4, 3, 2, 1));
  }

  @ParameterizedTest
  @MethodSource("p206")
  void emptyList(P206ReverseLinkedList p206) {
    assertThat(p206.reverseList(null)).isEqualTo(null);
  }

  @ParameterizedTest
  @MethodSource("p206")
  void singletonList(P206ReverseLinkedList p206) {
    assertThat(p206.reverseList(ListNode.of(1))).isEqualTo(ListNode.of(1));
  }

  static Stream<P206ReverseLinkedList> p206() {
    return Stream.of(new P206ReverseLinkedList.Iterative(), new P206ReverseLinkedList.Recursive());
  }
}
