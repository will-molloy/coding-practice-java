package wilmol.leetcode.problemset.algorithms.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Will on 2019-07-25 at 21:42.
 *
 * <p><a
 * href=https://leetcode.com/problems/design-linked-list>https://leetcode.com/problems/design-linked-list</a>
 *
 * <p>Runtime: O(n) get, O(1) addAtHead, O(n) addAtTail, O(n) addAtIndex, O(n) deleteAtIndex
 */
class P707DesignLinkedList {

  // for testing
  List<Integer> asArrayList() {
    List<Integer> values = new ArrayList<>();
    ListNode node = head;
    while (node != null) {
      values.add(node.val);
      node = node.next;
    }
    return values;
  }

  private static class ListNode {
    final int val;
    ListNode next;

    ListNode(int val) {
      this.val = val;
    }
  }

  private ListNode head;

  /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
  public int get(int index) {
    int count = 0;
    ListNode node = head;
    while (node != null) {
      if (count == index) {
        return node.val;
      }
      count += 1;
      node = node.next;
    }
    return -1;
  }

  /**
   * Add a node of value val before the first element of the linked list. After the insertion, the
   * new node will be the first node of the linked list.
   */
  public void addAtHead(int val) {
    ListNode newHead = new ListNode(val);
    newHead.next = head;
    head = newHead;
  }

  /** Append a node of value val to the last element of the linked list. */
  public void addAtTail(int val) {
    if (head == null) {
      addAtHead(val);
      return;
    }

    ListNode last = head;
    while (last.next != null) {
      last = last.next;
    }

    last.next = new ListNode(val);
  }

  /**
   * Add a node of value val before the index-th node in the linked list. If index equals to the
   * length of linked list, the node will be appended to the end of linked list. If index is greater
   * than the length, the node will not be inserted.
   */
  public void addAtIndex(int index, int val) {
    if (index <= 0) {
      addAtHead(val);
      return;
    }

    int length = 0;
    ListNode node = head;
    while (node != null) {
      // before index because we need the prev node
      if (length == index - 1) {
        ListNode next = node.next;
        ListNode newNode = new ListNode(val);
        node.next = newNode;
        newNode.next = next;
        return;
      }
      length += 1;
      node = node.next;
    }
  }

  /** Delete the index-th node in the linked list, if the index is valid. */
  public void deleteAtIndex(int index) {
    if (index == 0 && head != null) {
      head = head.next;
      return;
    }

    int length = 0;
    ListNode node = head;
    while (node != null) {
      // before index because we need the prev node
      if (length == index - 1) {
        node.next = node.next == null ? null : node.next.next;
      }
      length += 1;
      node = node.next;
    }
  }
}
