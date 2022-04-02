package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.IdentityHashMap;
import java.util.Map;

/**
 * <a
 * href=https://leetcode.com/problems/copy-list-with-random-pointer>https://leetcode.com/problems/copy-list-with-random-pointer/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n) TODO O(1) space is possible
 *
 * <p>Key: Store copied nodes in map so lookup same node if already created copy.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P138CopyListWithRandomPointer {

  public Node copyRandomList(Node head) {
    if (head == null) {
      return null;
    }

    // map original -> copy
    Map<Node, Node> map = new IdentityHashMap<>();

    Node node = head;
    Node copyDummy = new Node(0);
    Node copy = copyDummy;
    while (node != null) {
      copy.next = map.getOrDefault(node, new Node(node.val));
      copy = copy.next;
      map.put(node, copy);
      if (node.random != null) {
        copy.random = map.getOrDefault(node.random, new Node(node.random.val));
        map.put(node.random, copy.random);
      }
      node = node.next;
    }
    return copyDummy.next;
  }

  /** Linked List Node with Random pointer. */
  static class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
      this.val = val;
      this.next = null;
      this.random = null;
    }
  }
}
