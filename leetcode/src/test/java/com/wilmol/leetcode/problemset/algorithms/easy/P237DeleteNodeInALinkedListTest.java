package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.easy.P237DeleteNodeInALinkedList.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P237DeleteNodeInALinkedListTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P237DeleteNodeInALinkedListTest {

  private final P237DeleteNodeInALinkedList p237 = new P237DeleteNodeInALinkedList();

  @Test
  void example1() {
    ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9, null))));
    p237.deleteNode(head.next);
    assertThat(head).isEqualTo(new ListNode(4, new ListNode(1, new ListNode(9, null))));
  }

  @Test
  void example2() {
    ListNode head = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9, null))));
    p237.deleteNode(head.next.next);
    assertThat(head).isEqualTo(new ListNode(4, new ListNode(5, new ListNode(9, null))));
  }
}
