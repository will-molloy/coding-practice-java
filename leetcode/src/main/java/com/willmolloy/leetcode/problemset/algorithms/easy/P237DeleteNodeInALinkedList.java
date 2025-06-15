package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;

/**
 * <a
 * href=https://leetcode.com/problems/delete-node-in-a-linked-list>https://leetcode.com/problems/delete-node-in-a-linked-list/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key idea: Since we can't access the previous node, overwrite current node with next node
 * (effectively duplicating the next node while deleting the current node) then delete next node.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P237DeleteNodeInALinkedList {

  public void deleteNode(ListNode node) {
    // have no access to prev node, so overwrite this node with next node
    node.val = node.next.val;
    // delete next node
    node.next = node.next.next;
  }
}
