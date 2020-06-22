package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-25 at 21:55. */
class P707DesignLinkedListTest {

  private P707DesignLinkedList linkedList;

  @BeforeEach
  void setUp() {
    linkedList = new P707DesignLinkedList();
    assertThat(linkedList.asArrayList()).isEmpty();
  }

  @Test
  void example() {
    linkedList.addAtHead(1);
    assertThat(linkedList.asArrayList()).containsExactly(1);

    linkedList.addAtTail(3);
    assertThat(linkedList.asArrayList()).containsExactly(1, 3).inOrder();

    linkedList.addAtIndex(1, 2);
    assertThat(linkedList.asArrayList()).containsExactly(1, 2, 3).inOrder();

    assertThat(linkedList.get(1)).isEqualTo(2);

    linkedList.deleteAtIndex(1);
    assertThat(linkedList.asArrayList()).containsExactly(1, 3).inOrder();

    assertThat(linkedList.get(1)).isEqualTo(3);
  }

  @Test
  void insertManyNodesAtHead() {
    IntStream.range(0, 10).forEach(linkedList::addAtHead);
    assertThat(linkedList.asArrayList()).containsExactly(9, 8, 7, 6, 5, 4, 3, 2, 1, 0).inOrder();
  }

  @Test
  void insertManyNodesAtTail() {
    IntStream.range(0, 10).forEach(linkedList::addAtTail);
    assertThat(linkedList.asArrayList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).inOrder();
  }

  @Test
  void insertManyNodesAtIndex() {
    IntStream.range(0, 10).forEach(i -> linkedList.addAtIndex(i, i));
    assertThat(linkedList.asArrayList()).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).inOrder();
  }

  @Test
  void insertAtIndexOf0() {
    // Given
    assertThat(linkedList.get(0)).isEqualTo(-1);

    // When
    linkedList.addAtIndex(0, 1);

    // Then
    assertThat(linkedList.asArrayList()).containsExactly(1);
  }

  @Test
  void deleteHead() {
    // Given
    linkedList.addAtHead(1);
    assertThat(linkedList.asArrayList()).containsExactly(1);

    linkedList.addAtTail(2);
    assertThat(linkedList.asArrayList()).containsExactly(1, 2).inOrder();

    // When
    linkedList.deleteAtIndex(0);

    // Then
    assertThat(linkedList.asArrayList()).containsExactly(2);
  }

  @Test
  void addAtTailWhenEmpty() {
    // When
    linkedList.addAtTail(1);

    // Then
    assertThat(linkedList.asArrayList()).containsExactly(1);
  }

  @Test
  void insertAtNegativeIndex() {
    // When
    linkedList.addAtIndex(-1, 0);

    // Then
    assertThat(linkedList.get(0)).isEqualTo(0);

    linkedList.deleteAtIndex(-1);
    assertThat(linkedList.asArrayList()).containsExactly(0);
  }

  @Test
  void insertAtIndexBeyondLength() {
    // When
    linkedList.addAtIndex(1, 0);

    // Then
    assertThat(linkedList.asArrayList()).isEmpty();
  }
}
