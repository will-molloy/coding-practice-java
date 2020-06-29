package com.wilmol.hackerrank.common;

import java.util.Objects;

/**
 * DoublyLinkedListNode.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
public final class DoublyLinkedListNode {

  public final int data;

  public DoublyLinkedListNode next;

  public DoublyLinkedListNode prev;

  private DoublyLinkedListNode(int data) {
    this.data = data;
  }

  public static DoublyLinkedListNode of(int data) {
    return new DoublyLinkedListNode(data);
  }

  @Override
  public String toString() {
    return "DoublyLinkedListNode{" + "data=" + data + ", next=" + next + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DoublyLinkedListNode that = (DoublyLinkedListNode) o;
    return data == that.data && Objects.equals(next, that.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, next);
  }
}
