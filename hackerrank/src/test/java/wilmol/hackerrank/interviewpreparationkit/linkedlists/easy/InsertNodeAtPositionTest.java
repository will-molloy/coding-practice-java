package wilmol.hackerrank.interviewpreparationkit.linkedlists.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.hackerrank.common.SinglyLinkedListNode;

/** Created by Will on 27/03/2019. */
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
