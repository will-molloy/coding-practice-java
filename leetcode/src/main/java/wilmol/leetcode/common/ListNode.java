package wilmol.leetcode.common;

import java.util.Objects;
import java.util.StringJoiner;

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
    return val == listNode.val && Objects.equals(next, listNode.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(val, next);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", "[", "]")
        .add(String.valueOf(val))
        .add(String.valueOf(next))
        .toString();
  }
}
