package com.wilmol.hackerrank.interviewpreparationkit.linkedlists.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.Test;

/** Created by Will on 28/03/2019. */
class InsertNodeIntoSortedListTest {

  @Test
  void insertAtStart() {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(2);
    inputHead.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    assertThat(InsertNodeIntoSortedList.sortedInsert(inputHead, 1)).isEqualTo(outputHead);
  }

  @Test
  void insertAtMiddle() {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    assertThat(InsertNodeIntoSortedList.sortedInsert(inputHead, 2)).isEqualTo(outputHead);
  }

  @Test
  void insertAtEnd() {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    assertThat(InsertNodeIntoSortedList.sortedInsert(inputHead, 3)).isEqualTo(outputHead);
  }
}
