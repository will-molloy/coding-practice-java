package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.StringJoiner;

/**
 * <a href=https://leetcode.com/problems/all-oone-data-structure>All O(1) Data Structure.</a>
 *
 * <p>Key idea: hashmap + doubly-linked list with freq buckets. Maintain list sorted by freq.
 *
 * <p>Complexity: O(1) time, O(n) space.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P146LruCache.CustomLinkedList
 * @see P460LfuCache
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P432AllO1DataStructure {

  // similar to LFU cache, track key -> freq AND freq -> keys (freq buckets)
  // track maxFreq and minFreq for O(1) retrieval

  // could maintain these as sorted structures... i.e. with max freq at front
  // then don't need to track min/max freq separately
  // would need to get freq bucket and swap on inc/dec
  // how to do that when LinkedHashMap only has putFirst/Last? - need List
  // but List needs to maintain empty buckets (O(1) lookup), scanning to next non-empty is NOT O(1)!
  // solution must track min/max freq separately then
  // unless we make our own linked-list structure with swap

  // yeah need to maintain sorted structure
  // the problem is the decrease op - when it hits 0 (remove), unknown what the next minFreq is

  // getting the next maxFreq is fine however - on remove, -1, or set to 0 if overall empty
  // ^so if problem doesn't care about getMin then you can use LinkedHashMap...

  /** Doubly linked-list node. */
  private static final class Node {
    private final int freq;
    private final LinkedHashSet<String> keys = new LinkedHashSet<>();
    private Node next;
    private Node prev;

    Node(int freq) {
      this.freq = freq;
    }

    @Override
    public String toString() {
      return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
          .add("freq=" + freq)
          .add("keys=" + keys)
          .add("next=" + next)
          .toString();
    }
  }

  private final LinkedHashMap<String, Integer> keyToFreq = new LinkedHashMap<>();
  private final LinkedHashMap<Integer, Node> freqToNodes = new LinkedHashMap<>();

  // sorted doubly-linked-list, minFreq -> maxFreq
  private final Node head = new Node(Integer.MIN_VALUE);
  private final Node tail = new Node(Integer.MAX_VALUE);

  {
    head.next = tail;
    tail.prev = head;
  }

  private void removeNode(Node node) {
    freqToNodes.remove(node.freq);

    // have: prev - node - next
    // want: prev - next
    Node next = node.next;
    Node prev = node.prev;
    prev.next = next;
    next.prev = prev;
    node.next = null;
    node.prev = null;
  }

  private void insertNodeAfter(Node node, Node prev) {
    freqToNodes.put(node.freq, node);

    // have: prev - next
    // want: prev - node - next
    Node next = prev.next;
    prev.next = node;
    next.prev = node;
    node.next = next;
    node.prev = prev;
  }

  public void inc(String key) {
    int freq = keyToFreq.getOrDefault(key, 0);
    keyToFreq.put(key, freq + 1);

    if (freq == 0) {
      // add new
      Node node = freqToNodes.get(1);
      if (node == null) {
        node = new Node(1);
        insertNodeAfter(node, head);
      }
      node.keys.add(key);
    } else {
      // inc freq
      Node node = freqToNodes.get(freq);
      Node next = node.next;

      // remove from current bucket, and remove bucket if empty
      node.keys.remove(key);
      if (node.keys.isEmpty()) {
        removeNode(node);
      }

      // add to next bucket
      if (next.freq == freq + 1) {
        next.keys.add(key);
      } else {
        Node newNode = new Node(freq + 1);
        newNode.keys.add(key);
        // insert before the next node
        // (it'll never be in a bucket after that, as only inc by 1)
        insertNodeAfter(newNode, next.prev);
      }
    }
  }

  public void dec(String key) {
    int freq = keyToFreq.getOrDefault(key, 0);
    if (freq == 0) {
      return;
    }

    if (freq == 1) {
      // remove from data structure completely
      keyToFreq.remove(key);

      Node node = freqToNodes.get(freq);
      node.keys.remove(key);
      if (node.keys.isEmpty()) {
        removeNode(node);
      }
    } else {
      // dec freq
      keyToFreq.put(key, freq - 1);

      Node node = freqToNodes.get(freq);
      Node prev = node.prev;

      // remove from current bucket, and remove bucket if empty
      node.keys.remove(key);
      if (node.keys.isEmpty()) {
        removeNode(node);
      }

      // add to prev bucket
      if (prev.freq == freq - 1) {
        prev.keys.add(key);
      } else {
        Node newNode = new Node(freq - 1);
        newNode.keys.add(key);
        // insert after the prev node
        // (it'll never be in a bucket before that, as only dec by 1)
        insertNodeAfter(newNode, prev);
      }
    }
  }

  public String getMaxKey() {
    if (tail.prev == head) {
      return "";
    }
    return tail.prev.keys.getFirst();
  }

  public String getMinKey() {
    if (head.next == tail) {
      return "";
    }
    return head.next.keys.getFirst();
  }
}
