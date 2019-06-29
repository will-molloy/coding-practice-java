package com.wilmol.hackerrank.interviewpreparationkit.linkedlists.easy;

import com.google.common.truth.Truth;
import com.wilmol.hackerrank.common.DoublyLinkedListNode;
import org.junit.jupiter.api.Test;

class ReverseListTest {

  @Test
  void reverseThreeElements() {
    DoublyLinkedListNode inputHead = DoublyLinkedListNode.of(1);
    inputHead.next = DoublyLinkedListNode.of(2);
    inputHead.next.prev = inputHead;
    inputHead.next.next = DoublyLinkedListNode.of(3);
    inputHead.next.next.prev = inputHead.next;

    DoublyLinkedListNode expectedHead = DoublyLinkedListNode.of(3);
    expectedHead.next = DoublyLinkedListNode.of(2);
    expectedHead.next.prev = expectedHead;
    expectedHead.next.next = DoublyLinkedListNode.of(1);
    expectedHead.next.next.prev = expectedHead.next;

    Truth.assertThat(ReverseList.reverse(inputHead)).isEqualTo(expectedHead);
  }

  @Test
  void reverseOneElement() {
    DoublyLinkedListNode inputHead = DoublyLinkedListNode.of(1);

    DoublyLinkedListNode expectedHead = DoublyLinkedListNode.of(1);

    Truth.assertThat(ReverseList.reverse(inputHead)).isEqualTo(expectedHead);
  }
}