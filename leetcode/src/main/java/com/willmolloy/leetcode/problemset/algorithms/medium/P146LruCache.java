package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/lru-cache>LRU Cache.</a>
 *
 * <p>Key idea: hashmap + doubly linked-list. Maintain LRU as either head or tail.
 *
 * <p>Helps to draw out linked-list pointers, to understand how to manipulate them.
 *
 * <p>Note you could also use a {@link java.util.LinkedHashMap}.
 *
 * <p>Complexity: O(1) time, O(n) space.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P460LfuCache
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P146LruCache {

  /** Doubly linked-list node. */
  private static final class Node {
    private final int key;
    private final int value;
    private Node next;
    private Node prev;

    Node(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private final int capacity;

  // map allows O(1) get/put
  private final Map<Integer, Node> map;

  // maintain tail as LRU - allowing O(1) eviction
  // (head/tail created as dummy nodes to avoid null checks)
  private final Node head;
  private final Node tail;

  P146LruCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException(String.format("Invalid capacity: %s", capacity));
    }
    this.capacity = capacity;
    map = new HashMap<>();
    head = new Node(0, 0);
    tail = new Node(0, 0);
    head.next = tail;
    tail.prev = head;
  }

  public int get(int key) {
    Node node = map.get(key);
    if (node != null) {
      // move node to front, in MRU position
      removeNode(node);
      addNodeToFront(node);
      return node.value;
    } else {
      return -1;
    }
  }

  public void put(int key, int value) {
    Node node = map.get(key);
    if (node != null) {
      // remove existing node, we'll update it by inserting a new one
      removeNode(node);
    }

    // insert node in MRU position
    Node newNode = new Node(key, value);
    map.put(key, newNode);
    addNodeToFront(newNode);

    if (map.size() > capacity) {
      // evict the LRU
      Node lru = tail.prev;
      removeNode(lru);
      map.remove(lru.key);
    }
  }

  private void removeNode(Node node) {
    // have: prev <-> node <-> next
    // want: prev <-> next
    Node next = node.next;
    Node prev = node.prev;
    next.prev = prev;
    prev.next = next;
    node.next = null;
    node.prev = null;
  }

  private void addNodeToFront(Node node) {
    // have: head <-> next
    // want: head <-> node <-> next
    Node next = head.next;
    head.next = node;
    next.prev = node;
    node.next = next;
    node.prev = head;
  }
}
