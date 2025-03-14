package com.willmolloy.leetcode.problemset.algorithms.medium;

import com.willmolloy.leetcode.common.ListNode;
import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/swapping-nodes-in-a-linked-list>https://leetcode.com/problems/swapping-nodes-in-a-linked-list/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n) TODO O(1) memory is possible
 *
 * <p>Key idea: Dump into array first.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1721SwappingNodesInALinkedList {

  public ListNode swapNodes(ListNode head, int k) {
    ArrayList<Integer> array = toArray(head);
    // swap
    array.set(k - 1, array.set(array.size() - k, array.get(k - 1)));
    return toLinkedList(array);
  }

  private ArrayList<Integer> toArray(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();
    while (head != null) {
      list.add(head.val);
      head = head.next;
    }
    return list;
  }

  private ListNode toLinkedList(List<Integer> list) {
    ListNode head = new ListNode(list.get(0));
    ListNode node = head;
    for (int i = 1; i < list.size(); i++) {
      node.next = new ListNode(list.get(i));
      node = node.next;
    }
    return head;
  }
}
