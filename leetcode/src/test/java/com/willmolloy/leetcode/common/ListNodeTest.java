package com.willmolloy.leetcode.common;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Unit tests for {@link ListNode}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class ListNodeTest {

  @ParameterizedTest
  @MethodSource
  void testToString(ListNode head, String expected) {
    assertThat(head.toString()).isEqualTo(expected);
  }

  static Stream<Arguments> testToString() {
    return Stream.of(
        Arguments.of(singleNode(), "ListNode[1]"),
        Arguments.of(evenLength(), "ListNode[1, 2]"),
        Arguments.of(oddLength(), "ListNode[1, 2, 3]"),
        Arguments.of(singleNodeFactory(), "ListNode[1]"),
        Arguments.of(evenLengthFactory(), "ListNode[1, 2]"),
        Arguments.of(oddLengthFactory(), "ListNode[1, 2, 3]"));
  }

  @ParameterizedTest
  @MethodSource
  void testToStringWithCycle(ListNode head, String expected) {
    assertThat(head.toString()).isEqualTo(expected);
  }

  static Stream<Arguments> testToStringWithCycle() {
    return Stream.of(
        Arguments.of(singleNodeCycle(), "ListNode[1] (cycling)"),
        Arguments.of(evenLengthCycle(), "ListNode[1, 2] (cycling)"),
        Arguments.of(oddLengthCycle(), "ListNode[1, 2, 3] (cycling)"),
        Arguments.of(singleNodeFactoryCycle(), "ListNode[1] (cycling)"),
        Arguments.of(evenLengthFactoryCycle(), "ListNode[1, 2] (cycling)"),
        Arguments.of(oddLengthFactoryCycle(), "ListNode[1, 2, 3] (cycling)"));
  }

  @Test
  void testEqualsAndStaticFactory() {
    new EqualsTester()
        .addEqualityGroup(singleNode(), singleNodeFactory())
        .addEqualityGroup(evenLength(), evenLengthFactory())
        .addEqualityGroup(oddLength(), oddLengthFactory())
        .addEqualityGroup(singleNodeCycle(), singleNodeFactoryCycle())
        .addEqualityGroup(evenLengthCycle(), evenLengthFactoryCycle())
        .addEqualityGroup(oddLengthCycle(), oddLengthFactoryCycle())
        .testEquals();
  }

  private static ListNode singleNode() {
    return new ListNode(1);
  }

  private static ListNode singleNodeFactory() {
    return ListNode.of(1);
  }

  private static ListNode evenLength() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    return head;
  }

  private static ListNode evenLengthFactory() {
    return ListNode.of(1, 2);
  }

  private static ListNode oddLength() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    return head;
  }

  private static ListNode oddLengthFactory() {
    return ListNode.of(1, 2, 3);
  }

  private static ListNode singleNodeCycle() {
    ListNode head = new ListNode(1);
    head.next = head;
    return head;
  }

  private static ListNode singleNodeFactoryCycle() {
    ListNode head = ListNode.of(1);
    head.next = head;
    return head;
  }

  private static ListNode evenLengthCycle() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = head;
    return head;
  }

  private static ListNode evenLengthFactoryCycle() {
    ListNode head = ListNode.of(1, 2);
    head.next.next = head;
    return head;
  }

  private static ListNode oddLengthCycle() {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = head;
    return head;
  }

  private static ListNode oddLengthFactoryCycle() {
    ListNode head = ListNode.of(1, 2, 3);
    head.next.next.next = head;
    return head;
  }
}
