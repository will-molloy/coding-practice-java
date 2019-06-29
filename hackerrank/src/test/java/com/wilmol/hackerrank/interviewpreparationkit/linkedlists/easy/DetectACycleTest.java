package com.wilmol.hackerrank.interviewpreparationkit.linkedlists.easy;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.hackerrank.common.SinglyLinkedListNode;
import org.junit.jupiter.api.Test;

class DetectACycleTest {

  @Test
  void hasCycle() {
    SinglyLinkedListNode head = SinglyLinkedListNode.of(0);
    head.next = SinglyLinkedListNode.of(0);
    head.next.next = SinglyLinkedListNode.of(0);
    head.next.next.next = head;
    assertThat(DetectACycle.hasCycle(head)).isTrue();
  }

  @Test
  void noCycle() {
    SinglyLinkedListNode head = SinglyLinkedListNode.of(0);
    head.next = SinglyLinkedListNode.of(0);
    head.next.next = SinglyLinkedListNode.of(0);
    assertThat(DetectACycle.hasCycle(head)).isFalse();
  }
}