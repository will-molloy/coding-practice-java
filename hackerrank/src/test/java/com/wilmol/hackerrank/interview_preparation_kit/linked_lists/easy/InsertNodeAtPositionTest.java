package com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy.InsertNodeAtPosition.insertNodeAtPosition;

import org.junit.jupiter.api.Test;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;

class InsertNodeAtPositionTest
{

  @Test
  void insertInMiddle()
  {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);
    inputHead.next.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(4);
    outputHead.next.next.next = SinglyLinkedListNode.of(3);
    assertThat(insertNodeAtPosition(inputHead, 4, 2)).isEqualTo(outputHead);
  }

  @Test
  void insertAtStart()
  {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);
    inputHead.next.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(4);
    outputHead.next = SinglyLinkedListNode.of(1);
    outputHead.next.next = SinglyLinkedListNode.of(2);
    outputHead.next.next.next = SinglyLinkedListNode.of(3);
    assertThat(insertNodeAtPosition(inputHead, 4, 0)).isEqualTo(outputHead);
  }

  @Test
  void insertAtEnd()
  {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);
    inputHead.next.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    outputHead.next.next.next = SinglyLinkedListNode.of(4);
    assertThat(insertNodeAtPosition(inputHead, 4, 3)).isEqualTo(outputHead);
  }

}
