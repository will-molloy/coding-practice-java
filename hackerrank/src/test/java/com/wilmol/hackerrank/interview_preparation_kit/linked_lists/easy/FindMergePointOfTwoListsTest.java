package com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;

class FindMergePointOfTwoListsTest
{

  @Test
  void trivialCaseSameLength()
  {
    SinglyLinkedListNode head = SinglyLinkedListNode.of(1);
    head.next = SinglyLinkedListNode.of(2);

    assertThat(FindMergePointOfTwoLists.findMergeNode(head, head)).isEqualTo(1);
  }

  @Test
  void listAIsLonger()
  {
    SinglyLinkedListNode headB = SinglyLinkedListNode.of(4);
    headB.next = SinglyLinkedListNode.of(5);

    SinglyLinkedListNode headA = SinglyLinkedListNode.of(1);
    headA.next = SinglyLinkedListNode.of(2);
    headA.next.next = SinglyLinkedListNode.of(3);
    headA.next.next.next = headB;

    assertThat(FindMergePointOfTwoLists.findMergeNode(headA, headB)).isEqualTo(4);
  }

  @Test
  void listBIsLonger()
  {
    SinglyLinkedListNode headA = SinglyLinkedListNode.of(5);

    SinglyLinkedListNode headB = SinglyLinkedListNode.of(1);
    headB.next = SinglyLinkedListNode.of(2);
    headB.next.next = SinglyLinkedListNode.of(3);
    headB.next.next.next = SinglyLinkedListNode.of(4);
    headB.next.next.next.next = headA;

    assertThat(FindMergePointOfTwoLists.findMergeNode(headA, headB)).isEqualTo(5);
  }

}
