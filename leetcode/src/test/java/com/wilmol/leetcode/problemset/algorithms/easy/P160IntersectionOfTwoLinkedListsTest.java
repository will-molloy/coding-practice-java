package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.common.ListNode;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P160IntersectionOfTwoLinkedListsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P160IntersectionOfTwoLinkedListsTest {

  @ParameterizedTest
  @MethodSource("p160")
  void example1(P160IntersectionOfTwoLinkedLists p160) {
    ListNode a = ListNode.of(4, 1);
    ListNode b = ListNode.of(5, 0, 1);
    ListNode c = ListNode.of(8, 4, 5);
    a.next.next = c;
    b.next.next.next = c;
    assertThat(p160.getIntersectionNode(a, b)).isEqualTo(c);
  }

  @ParameterizedTest
  @MethodSource("p160")
  void example2(P160IntersectionOfTwoLinkedLists p160) {
    ListNode a = ListNode.of(0, 9, 1);
    ListNode b = ListNode.of(3);
    ListNode c = ListNode.of(2, 4);
    a.next.next.next = c;
    b.next = c;
    assertThat(p160.getIntersectionNode(a, b)).isEqualTo(c);
  }

  @ParameterizedTest
  @MethodSource("p160")
  void example3(P160IntersectionOfTwoLinkedLists p160) {
    ListNode a = ListNode.of(2, 6, 4);
    ListNode b = ListNode.of(1, 4);
    assertThat(p160.getIntersectionNode(a, b)).isNull();
  }

  @ParameterizedTest
  @MethodSource("p160")
  void equalLists(P160IntersectionOfTwoLinkedLists p160) {
    ListNode list = ListNode.of(1, 2, 3);
    assertThat(p160.getIntersectionNode(list, list)).isEqualTo(list);
  }

  static Stream<P160IntersectionOfTwoLinkedLists> p160() {
    return Stream.of(
        new P160IntersectionOfTwoLinkedLists.HashSet(),
        new P160IntersectionOfTwoLinkedLists.ConcatenateLists());
  }
}
