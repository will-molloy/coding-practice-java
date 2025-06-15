package com.willmolloy.leetcode.common;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Definition for singly-linked list.
 *
 * @author leetcode
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public final class ListNode {

  /** Constructs a new linked list containing the given values, in order. */
  public static ListNode of(int... values) {
    ListNode head = new ListNode(values[0]);
    ListNode node = head;
    for (int i = 1; i < values.length; i++) {
      node.next = new ListNode(values[i]);
      node = node.next;
    }
    return head;
  }

  public int val;

  @SuppressFBWarnings("PA_PUBLIC_PRIMITIVE_ATTRIBUTE")
  @Nullable
  public ListNode next;

  public ListNode(int val) {
    this.val = val;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ListNode listNode)) {
      return false;
    }
    return serialise().equals(listNode.serialise());
  }

  @Override
  public int hashCode() {
    return serialise().hashCode();
  }

  @Override
  public String toString() {
    return getClass().getSimpleName() + serialise();
  }

  private String serialise() {
    List<Integer> values = new ArrayList<>();
    ListNode slow = this;
    ListNode fast = this;

    while (slow != null) {
      values.add(slow.val);
      slow = slow.next;

      if (fast != null && fast.next != null) {
        fast = fast.next.next;
      } else {
        // reached end of list, cycle is impossible
        fast = null;
      }

      if (fast != null && slow == fast) {
        return values + " (cycling)";
      }
    }
    return values.toString();
  }
}
