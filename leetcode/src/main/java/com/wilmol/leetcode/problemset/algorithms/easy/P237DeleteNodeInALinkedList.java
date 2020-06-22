package com.wilmol.leetcode.problemset.algorithms.easy;

import com.wilmol.leetcode.common.ListNode;
import java.util.Objects;
import java.util.StringJoiner;

/**
 * Created by wilmol on 2020-06-02.
 *
 * <p><a
 * href=https://leetcode.com/problems/delete-node-in-a-linked-list>https://leetcode.com/problems/delete-node-in-a-linked-list/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Since we can't access the previous node, overwrite current node with next node
 * (effectively duplicating the next node while deleting the current node) then delete next node.
 */
class P237DeleteNodeInALinkedList {

  public void deleteNode(ListNode node) {
    // have no access to prev node, so overwrite this node with next node
    node.val = node.next.val;
    // delete next node
    node.next = node.next.next;
  }

  static class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
      val = x;
      this.next = next;
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
      return new StringJoiner(", ", ListNode.class.getSimpleName() + "[", "]")
          .add("val=" + val)
          .add("next=" + next)
          .toString();
    }
  }
}
