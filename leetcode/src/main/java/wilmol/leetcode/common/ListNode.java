package wilmol.leetcode.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/** Created by Will on 2019-06-23 at 20:43. */
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

  public final int val;

  @SuppressWarnings("PublicField")
  public ListNode next;

  /** public constructor required for leetcode submission. */
  public ListNode(int val) {
    this.val = val;
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
    return toString().equals(listNode.toString());
  }

  @Override
  public int hashCode() {
    return toString().hashCode();
  }

  @Override
  public String toString() {
    List<Integer> values = new ArrayList<>();
    Set<ListNode> seen = Collections.newSetFromMap(new IdentityHashMap<>());
    ListNode node = this;
    while (node != null) {
      if (seen.contains(node)) {
        return getClass().getSimpleName() + values + " (cycling)";
      }
      seen.add(node);
      values.add(node.val);
      node = node.next;
    }
    return getClass().getSimpleName() + values;
  }
}
