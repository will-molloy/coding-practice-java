package com.willmolloy.leetcode.problemset.algorithms.easy;

import com.willmolloy.leetcode.common.ListNode;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/intersection-of-two-linked-lists>https://leetcode.com/problems/intersection-of-two-linked-lists/</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P160IntersectionOfTwoLinkedLists {

  ListNode getIntersectionNode(ListNode headA, ListNode headB);

  /**
   * Solution which uses a hashset to test when the intersection node occurs.
   *
   * <p>Runtime: O(a + b)
   *
   * <p>Extra space: O(a)
   *
   * <p>Key idea: {@code HashSet} for O(1) contains call.
   */
  final class HashSet implements P160IntersectionOfTwoLinkedLists {

    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      Set<ListNode> set = Collections.newSetFromMap(new IdentityHashMap<>());
      ListNode a = headA;
      while (a != null) {
        set.add(a);
        a = a.next;
      }

      ListNode b = headB;
      while (b != null) {
        if (set.contains(b)) {
          return b;
        }
        b = b.next;
      }

      return null;
    }
  }

  /**
   * Solution which traverses the lists in sync (two pointers for each, one node at a time). When a
   * reaches the end it starts traversing b, and similar for b. Therefore, when the pointers are
   * equal, the intersection node has been found.
   *
   * <p>Diagram:
   *
   * <p>a = a1 -> a2 -> c1 -> c2 -> c3 -> b1 -> b2 -> b3 -> (c1) -> c2 -> c3
   *
   * <p>b = b1 -> b2 -> b3 -> c1 -> c2 -> c3 -> a1 -> a2 -> (c1) -> c2 -> c3
   *
   * <p>Runtime: O(a + b)
   *
   * <p>Extra space: O(1)
   *
   * <p>Key idea: Concatenate the lists.
   */
  final class ConcatenateLists implements P160IntersectionOfTwoLinkedLists {

    @Override
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      boolean aToB = false;
      boolean bToA = false;
      ListNode a = headA;
      ListNode b = headB;
      while (a != null && b != null) {
        if (a == b) {
          return a;
        }
        a = a.next;
        b = b.next;
        if (!aToB && a == null) {
          a = headB;
          aToB = true;
        }
        if (!bToA && b == null) {
          b = headA;
          bToA = true;
        }
      }
      return null;
    }
  }
}
