package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list>https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(n)
 *
 * <p>Key idea: storing current level before proceeding to next level; stack/recursion to traverse
 * depth first
 *
 * @see P114FlattenBinaryTreeToLinkedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P430FlattenAMultilevelDoublyLinkedList {

  Node flatten(Node head);

  /** Using a stack. */
  class Stack implements P430FlattenAMultilevelDoublyLinkedList {

    @Override
    public Node flatten(Node head) {
      // use stack to store current level before traversing a child
      // this way when child level bottoms out we can go back to the most recent level (FIFO)
      Deque<Node> stack = new ArrayDeque<>();
      Node node = head;

      while (node != null) {
        if (node.child != null) {
          // have a child, traverse it depth first
          // store current level (if it continues)
          if (node.next != null) {
            stack.push(node.next);
          }
          // change next pointer to child, and clear child
          node.next = node.child;
          node.next.prev = node;
          node.child = null;
        } else if (node.next == null && !stack.isEmpty()) {
          // reached end of level, point back to stored above level (if present)
          node.next = stack.pop();
          node.next.prev = node;
        }
        // continue iterating
        node = node.next;
      }
      return head;
    }

    @Override
    public String toString() {
      return getClass().getSimpleName();
    }
  }

  /** Using recursion. */
  class Recursion implements P430FlattenAMultilevelDoublyLinkedList {

    @Override
    public Node flatten(Node head) {
      flatten0(head);
      return head;
    }

    // returns the last node in the flattened list
    private Node flatten0(Node node) {
      Node prev = null;
      while (node != null) {
        if (node.child != null) {
          // have a child, traverse it depth first
          // save next node so we can go back to it
          Node nextSaved = node.next;
          Node lastOfChildTraversal = flatten0(node.child);
          // change next pointer to child, and clear child
          node.next = node.child;
          node.next.prev = node;
          node.child = null;
          // point back to this level
          lastOfChildTraversal.next = nextSaved;
          if (nextSaved != null) {
            nextSaved.prev = lastOfChildTraversal;
          }
          // continue iterating,
          // can safely jump to end of child traversal (it was processed already in the recursion)
          prev = node;
          node = lastOfChildTraversal;
        } else {
          // continue iterating
          prev = node;
          node = node.next;
        }
      }
      return prev;
    }

    @Override
    public String toString() {
      return getClass().getSimpleName();
    }
  }

  /** Node. */
  @SuppressFBWarnings(
      value = "URF_UNREAD_PUBLIC_OR_PROTECTED_FIELD",
      justification = "Required for leetcode submission")
  class Node {
    public final int val;
    public Node prev;
    public Node next;
    public Node child;

    Node(int val) {
      this.val = val;
    }

    // see serialiseMultilevel()
    static Node multiLevel(List<List<Integer>> lists) {
      Node topLevel = singleLevel(lists.get(0));
      Node node = topLevel;
      for (int i = 1; i < lists.size(); i++) {
        // find first non-null to insert child level
        for (int j = 0; j < lists.get(i).size(); j++) {
          if (lists.get(i).get(j) != null) {
            // non-null, insert the child level
            node.child = singleLevel(lists.get(i).subList(j, lists.get(i).size()));
            node = node.child;
            break;
          }
          node = node.next;
        }
      }
      return topLevel;
    }

    // assumes list contains no nulls
    static Node singleLevel(List<Integer> list) {
      Node head = new Node(list.get(0));
      Node node = head;
      for (int i = 1; i < list.size(); i++) {
        node.next = new Node(list.get(i));
        node.next.prev = node;
        node = node.next;
      }
      return head;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return serialiseMultilevel().equals(node.serialiseMultilevel());
    }

    @Override
    public int hashCode() {
      return serialiseMultilevel().hashCode();
    }

    @Override
    public String toString() {
      return serialiseMultilevel().toString();
    }

    // same serialisation as done on leetcode problem description
    // there will only be one child pointer per level
    private List<List<Integer>> serialiseMultilevel() {
      List<List<Integer>> lists = new ArrayList<>();
      Node node = this;
      lists.add(node.serialiseSingleLevel());
      List<Integer> list = new ArrayList<>();
      while (node != null) {
        if (node.child != null) {
          // found child, serialise and move to next level
          list.addAll(node.child.serialiseSingleLevel());
          lists.add(list);
          list = new ArrayList<>();
          node = node.child;
        } else {
          // fill with 'null' to indicate no connection to upper node
          list.add(null);
          node = node.next;
        }
      }
      return lists;
    }

    private List<Integer> serialiseSingleLevel() {
      List<Integer> list = new ArrayList<>();
      Node node = this;
      while (node != null) {
        list.add(node.val);
        node = node.next;
      }
      return list;
    }
  }
}
