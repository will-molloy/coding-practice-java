package com.willmolloy.hackerrank.interviewpreparationkit.linkedlists.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.Test;

/**
 * InsertNodeAtPositionTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class InsertNodeAtPositionTest {

  @Test
  void insertInMiddle() {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);
    inputHead.next.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(4);
    outputHead.next.next.next = SinglyLinkedListNode.of(3);
    assertThat(InsertNodeAtPosition.insertNodeAtPosition(inputHead, 4, 2)).isEqualTo(outputHead);
  }

  @Test
  void insertAtStart() {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);
    inputHead.next.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(4);
    outputHead.next = SinglyLinkedListNode.of(1);
    outputHead.next.next = SinglyLinkedListNode.of(2);
    outputHead.next.next.next = SinglyLinkedListNode.of(3);
    assertThat(InsertNodeAtPosition.insertNodeAtPosition(inputHead, 4, 0)).isEqualTo(outputHead);
  }

  @Test
  void insertAtEnd() {
    SinglyLinkedListNode inputHead = SinglyLinkedListNode.of(1);
    inputHead.next = SinglyLinkedListNode.of(2);
    inputHead.next.next = SinglyLinkedListNode.of(3);

    SinglyLinkedListNode outputHead = SinglyLinkedListNode.of(1);
    outputHead.next = SinglyLinkedListNode.of(2);
    outputHead.next.next = SinglyLinkedListNode.of(3);
    outputHead.next.next.next = SinglyLinkedListNode.of(4);
    assertThat(InsertNodeAtPosition.insertNodeAtPosition(inputHead, 4, 3)).isEqualTo(outputHead);
  }
}
