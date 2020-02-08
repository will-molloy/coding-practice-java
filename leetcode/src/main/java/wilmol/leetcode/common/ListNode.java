package wilmol.leetcode.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

/** Created by Will on 2019-06-23 at 20:43. */
public final class ListNode {

  public final int val;

  /** public field required for leetcode submission. */
  @SuppressWarnings("PublicField")
  public ListNode next;

  /**
   * Creates linked list from varargs int argument.
   *
   * @param values int values to create list from (in order)
   * @return head of new list (null if values is empty)
   */
  public static ListNode of(int... values) {
    if (values.length == 0) {
      return null;
    }
    return new ListNode(values);
  }

  private ListNode(int... values) {
    this.val = values[0];
    ListNode node = this;
    // skip first since already processed
    for (int i = 1; i < values.length; i++) {
      node.next = ListNode.of(values[i]);
      node = node.next;
    }
  }

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
    // must use identity comparison for cycle detection; equals/hashCode overflow
    Set<ListNode> seen = Collections.newSetFromMap(new IdentityHashMap<>());
    ListNode node = this;
    while (node != null) {
      if (seen.contains(node)) {
        return values + " (cycling)";
      }
      seen.add(node);
      values.add(node.val);
      node = node.next;
    }
    return values.toString();
  }
}
