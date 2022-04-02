package com.willmolloy.hackerrank.interviewpreparationkit.linkedlists.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.Test;

/**
 * FindMergePointOfTwoListsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class FindMergePointOfTwoListsTest {

  @Test
  void trivialCaseSameLength() {
    final SinglyLinkedListNode head = SinglyLinkedListNode.of(1);
    head.next = SinglyLinkedListNode.of(2);

    assertThat(FindMergePointOfTwoLists.findMergeNode(head, head)).isEqualTo(1);
  }

  @Test
  void listAIsLonger() {
    final SinglyLinkedListNode headB = SinglyLinkedListNode.of(4);
    headB.next = SinglyLinkedListNode.of(5);

    final SinglyLinkedListNode headA = SinglyLinkedListNode.of(1);
    headA.next = SinglyLinkedListNode.of(2);
    headA.next.next = SinglyLinkedListNode.of(3);
    headA.next.next.next = headB;

    assertThat(FindMergePointOfTwoLists.findMergeNode(headA, headB)).isEqualTo(4);
  }

  @Test
  void listBIsLonger() {
    final SinglyLinkedListNode headA = SinglyLinkedListNode.of(5);

    final SinglyLinkedListNode headB = SinglyLinkedListNode.of(1);
    headB.next = SinglyLinkedListNode.of(2);
    headB.next.next = SinglyLinkedListNode.of(3);
    headB.next.next.next = SinglyLinkedListNode.of(4);
    headB.next.next.next.next = headA;

    assertThat(FindMergePointOfTwoLists.findMergeNode(headA, headB)).isEqualTo(5);
  }
}
