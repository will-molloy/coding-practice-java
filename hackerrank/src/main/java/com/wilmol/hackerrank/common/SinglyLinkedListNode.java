package com.wilmol.hackerrank.common;

import java.util.Objects;

/** Created by Will on 26/03/2019. */
public final class SinglyLinkedListNode {

  public final int data;

  public SinglyLinkedListNode next;

  private SinglyLinkedListNode(int data) {
    this.data = data;
  }

  public static SinglyLinkedListNode of(int data) {
    return new SinglyLinkedListNode(data);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SinglyLinkedListNode that = (SinglyLinkedListNode) o;
    return data == that.data && Objects.equals(next, that.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, next);
  }
}
