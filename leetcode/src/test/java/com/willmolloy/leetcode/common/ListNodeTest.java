package com.willmolloy.leetcode.common;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.testing.EqualsTester;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link ListNode}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class ListNodeTest {

  @Test
  void testToStringNoCycle() {
    ListNode head = ListNode.of(1, 2, 3);
    assertThat(head.toString()).isEqualTo("ListNode[1, 2, 3]");
  }

  @Test
  void testToStringWithCycle() {
    ListNode node = new ListNode(1);
    ListNode node2 = new ListNode(2);
    node.next = node2;
    node2.next = node;
    assertThat(node.toString()).isEqualTo("ListNode[1, 2] (cycling)");
  }

  @Test
  void testEqualsAndStaticFactory() {
    ListNode threeElements = new ListNode(1);
    threeElements.next = new ListNode(2);
    threeElements.next.next = new ListNode(3);

    ListNode threeElementsCycling = new ListNode(1);
    threeElementsCycling.next = new ListNode(2);
    threeElementsCycling.next.next = new ListNode(3);
    threeElementsCycling.next.next.next = threeElementsCycling;

    ListNode threeElementsCyclingStaticFactory = ListNode.of(1, 2, 3);
    threeElementsCyclingStaticFactory.next.next.next = threeElementsCyclingStaticFactory;

    new EqualsTester()
        .addEqualityGroup(new ListNode(1), ListNode.of(1))
        .addEqualityGroup(threeElements, ListNode.of(1, 2, 3))
        .addEqualityGroup(threeElementsCycling, threeElementsCyclingStaticFactory)
        .testEquals();
  }
}
