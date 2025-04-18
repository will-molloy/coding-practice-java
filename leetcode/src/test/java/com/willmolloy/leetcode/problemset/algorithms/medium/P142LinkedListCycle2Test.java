package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P142LinkedListCycle2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P142LinkedListCycle2Test {

  private final P142LinkedListCycle2 p142 = new P142LinkedListCycle2();

  @Test
  void example1() {
    ListNode head = ListNode.of(3, 2, 0, -4);
    head.next.next.next.next = head.next;
    assertThat(p142.detectCycle(head)).isSameInstanceAs(head.next);
  }

  @Test
  void example2() {
    ListNode head = ListNode.of(1, 2);
    head.next.next = head;
    assertThat(p142.detectCycle(head)).isSameInstanceAs(head);
  }

  @Test
  void example3() {
    ListNode head = ListNode.of(1);
    assertThat(p142.detectCycle(head)).isNull();
  }
}
