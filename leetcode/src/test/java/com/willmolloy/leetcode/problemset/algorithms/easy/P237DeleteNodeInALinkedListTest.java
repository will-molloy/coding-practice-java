package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P237DeleteNodeInALinkedListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P237DeleteNodeInALinkedListTest {

  private final P237DeleteNodeInALinkedList p237 = new P237DeleteNodeInALinkedList();

  @Test
  void example1() {
    ListNode head = ListNode.of(4, 5, 1, 9);
    p237.deleteNode(head.next);
    assertThat(head).isEqualTo(ListNode.of(4, 1, 9));
  }

  @Test
  void example2() {
    ListNode head = ListNode.of(4, 5, 1, 9);
    p237.deleteNode(head.next.next);
    assertThat(head).isEqualTo(ListNode.of(4, 5, 9));
  }
}
