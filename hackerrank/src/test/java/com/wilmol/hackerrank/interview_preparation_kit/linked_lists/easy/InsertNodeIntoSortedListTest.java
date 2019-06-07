package com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.linked_lists.easy.InsertNodeIntoSortedList.sortedInsert;

import org.junit.jupiter.api.Test;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;

class InsertNodeIntoSortedListTest
{

  @Test
  void insertAtStart()
  {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(2);
    inputHead.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    assertThat(sortedInsert(inputHead, 1)).isEqualTo(outputHead);
  }

  @Test
  void insertAtMiddle()
  {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    assertThat(sortedInsert(inputHead, 2)).isEqualTo(outputHead);
  }

  @Test
  void insertAtEnd()
  {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    assertThat(sortedInsert(inputHead, 3)).isEqualTo(outputHead);
  }

}
