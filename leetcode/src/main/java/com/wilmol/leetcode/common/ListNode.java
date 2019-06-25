package com.wilmol.leetcode.common;

import com.google.common.base.Preconditions;
import java.util.Objects;

/** Created by Will on 2019-06-23 at 20:43 */
public class ListNode {

  public final int value;

  public ListNode next;

  public static ListNode of(int... values) {
    return new ListNode(values);
  }

  private ListNode(int... values) {
    Preconditions.checkArgument(values.length > 0);
    this.value = values[0];
    ListNode node = this;
    // skip first since already processed
    for (int i = 1; i < values.length; i++) {
      node.next = new ListNode(values[i]);
      node = node.next;
    }
  }

  /** public constructor required for leetcode submission */
  public ListNode(int value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return String.format("%d, %s", value, next);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListNode listNode = (ListNode) o;
    return value == listNode.value && Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, next);
  }
}
