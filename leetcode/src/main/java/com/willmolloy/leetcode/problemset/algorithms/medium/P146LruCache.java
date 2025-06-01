package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/lru-cache>LRU Cache.</a>
 *
 * <p>Key idea: hashmap + doubly linked-list. Maintain LRU as either head or tail.
 *
 * <p>Complexity: O(1) time, O(n) space.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P460LfuCache
 * @see com.willmolloy.leetcode.problemset.algorithms.hard.P432AllO1DataStructure
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
sealed interface P146LruCache {

  int get(int key);

  void put(int key, int value);

  /**
   * Custom doubly linked-list approach.
   *
   * <p>Helps to draw out linked-list pointers, to understand how to manipulate them.
   */
  final class CustomLinkedList implements P146LruCache {

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

    // map allows O(1) get/put to nodes
    private final Map<Integer, Node> map;

    // maintain tail as LRU - allowing O(1) eviction
    // (head/tail created as dummy nodes to avoid null checks)
    private final Node head;
    private final Node tail;

    CustomLinkedList(int capacity) {
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

  /** Built-in doubly linked-list approach, using {@link LinkedHashMap}. */
  final class BuiltInLinkedList implements P146LruCache {

    private final int capacity;
    // tail maintained as LRU
    private final LinkedHashMap<Integer, Integer> map;

    BuiltInLinkedList(int capacity) {
      if (capacity <= 0) {
        throw new IllegalArgumentException(String.format("Invalid capacity: %s", capacity));
      }
      this.capacity = capacity;
      this.map = new LinkedHashMap<>();
    }

    @Override
    public int get(int key) {
      Integer value = map.get(key);
      if (value == null) {
        return -1;
      }

      // move to MRU
      map.remove(key);
      map.putFirst(key, value);

      return value;
    }

    @Override
    public void put(int key, int value) {
      // move to MRU
      map.remove(key);
      map.putFirst(key, value);

      if (map.size() > capacity) {
        // evict LRU
        map.remove(map.lastEntry().getKey());
      }
    }
  }

  /** Approach which delegates to {@link LinkedHashMap#removeEldestEntry}. */
  final class LinkedHashMapDelegate implements P146LruCache {

    private final LinkedHashMap<Integer, Integer> delegate;

    @SuppressFBWarnings("SIC_INNER_SHOULD_BE_STATIC_ANON")
    LinkedHashMapDelegate(int capacity) {
      if (capacity <= 0) {
        throw new IllegalArgumentException(String.format("Invalid capacity: %s", capacity));
      }

      // must set accessOrder=true such that 'get' moves the entry
      this.delegate =
          new LinkedHashMap<>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
              return size() > capacity;
            }
          };
    }

    @Override
    public int get(int key) {
      return delegate.getOrDefault(key, -1);
    }

    @Override
    public void put(int key, int value) {
      delegate.put(key, value);
    }
  }
}
