package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedMap;
import java.util.SequencedSet;
import java.util.SortedMap;
import java.util.StringJoiner;
import java.util.TreeMap;

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
sealed interface P432AllO1DataStructure {

  // similar to LFU cache, track key -> freq AND freq -> keys (freq buckets)
  // track maxFreq and minFreq for O(1) retrieval

  // could maintain these as sorted structures... i.e. with max freq at front
  // then don't need to track min/max freq separately
  // would need to get freq bucket and swap on inc/dec

  // how to do that when LinkedHashMap only has putFirst/Last? - need List
  // but List needs to maintain empty buckets (for O(1) lookup), scanning to next non-empty is NOT
  // O(1)!

  // solution must track min/max freq separately then
  // unless we make our own linked-list structure

  // yeah need to maintain sorted structure
  // the problem is the decrease op when buckets get removed:
  // don't have next largest for maxFreq, or next smallest for minFreq if entry completely removed

  // increase op is fine however:
  // minFreq + 1 if bucket removed, maxFreq = max(maxFreq, freq + 1)...
  // ^that's why it works for LFU cache, where freq is only increased

  void inc(String key);

  void dec(String key);

  String getMaxKey();

  String getMinKey();

  /** Custom doubly linked-list approach. */
  final class CustomLinkedList implements P432AllO1DataStructure {

    /** Doubly linked-list node. */
    private static final class Node {
      private final int freq;
      private final SequencedSet<String> keys = new LinkedHashSet<>();
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

    private final SequencedMap<String, Integer> keyToFreq = new LinkedHashMap<>();
    private final SequencedMap<Integer, Node> freqToNodes = new LinkedHashMap<>();

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

    @Override
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

    @Override
    public void dec(String key) {
      int freq = keyToFreq.getOrDefault(key, 0);
      if (freq == 0) {
        return;
      }

      Node node = freqToNodes.get(freq);
      Node prev = node.prev;

      // remove from current bucket, and remove bucket if empty
      node.keys.remove(key);
      if (node.keys.isEmpty()) {
        removeNode(node);
      }

      if (freq == 1) {
        // remove from data structure completely
        keyToFreq.remove(key);
      } else {
        // dec freq
        keyToFreq.put(key, freq - 1);

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

    @Override
    public String getMaxKey() {
      if (tail.prev == head) {
        return "";
      }
      return tail.prev.keys.getFirst();
    }

    @Override
    public String getMinKey() {
      if (head.next == tail) {
        return "";
      }
      return head.next.keys.getFirst();
    }
  }

  /** {@link SortedMap} approach. This is NOT O(1) however. */
  final class BuiltInSortedMap implements P432AllO1DataStructure {

    private final SequencedMap<String, Integer> keyToFreq = new LinkedHashMap<>();
    private final SortedMap<Integer, SequencedSet<String>> freqToKeys = new TreeMap<>();

    @Override
    public void inc(String key) {
      int freq = keyToFreq.getOrDefault(key, 0);

      if (freq > 0) {
        removeEntry(freq, key);
      }

      keyToFreq.put(key, freq + 1);
      freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
    }

    @Override
    public void dec(String key) {
      int freq = keyToFreq.getOrDefault(key, 0);
      if (freq == 0) {
        return;
      }

      removeEntry(freq, key);

      if (freq == 1) {
        // remove completely
        keyToFreq.remove(key);
      } else {
        keyToFreq.put(key, freq - 1);
        freqToKeys.computeIfAbsent(freq - 1, k -> new LinkedHashSet<>()).add(key);
      }
    }

    private void removeEntry(int freq, String key) {
      SequencedSet<String> keys = freqToKeys.get(freq);
      keys.remove(key);
      if (keys.isEmpty()) {
        freqToKeys.remove(freq);
      }
    }

    @Override
    public String getMaxKey() {
      if (freqToKeys.isEmpty()) {
        return "";
      }
      return freqToKeys.lastEntry().getValue().getFirst();
    }

    @Override
    public String getMinKey() {
      if (freqToKeys.isEmpty()) {
        return "";
      }
      return freqToKeys.firstEntry().getValue().getFirst();
    }
  }
}
