package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P141LinkedListCycleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P141LinkedListCycleTest {

  private final P141LinkedListCycle p141 = new P141LinkedListCycle();

  @Test
  void example1() {
    ListNode head = ListNode.of(3, 2, 0, -4);
    head.next.next.next.next = head.next;
    assertThat(p141.hasCycle(head)).isTrue();
  }

  @Test
  void example2() {
    ListNode head = ListNode.of(1, 2);
    head.next.next = head;
    assertThat(p141.hasCycle(head)).isTrue();
  }

  @Test
  void example3() {
    ListNode head = ListNode.of(1);
    assertThat(p141.hasCycle(head)).isFalse();
  }
}
