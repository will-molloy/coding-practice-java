package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * <a href=https://leetcode.com/problems/lfu-cache>LFU Cache.</a>
 *
 * <p>Key idea: frequency buckets (in LRU order).
 *
 * <p>Complexity: O(1) time, O(n) space.
 *
 * @see com.willmolloy.leetcode.problemset.algorithms.medium.P146LruCache
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P460LfuCache {

  // need to maintain LFU and LRU order
  // LRU - map + doubly linked-list (same as before)
  // LFU - map + doubly linked-list with frequency buckets

  // Could implement custom linked-list -> will need 'LruCache' on each 'LfuNode'
  // Just use LinkedHashMap...
  // communicate this if interview

  // TODO SequencedSet

  private final int capacity;
  private final Map<Integer, Integer> keyToValue;
  private final Map<Integer, Integer> keyToFreq;
  private final Map<Integer, LinkedHashSet<Integer>> freqToKeysLruOrder;
  private int minFreq;

  P460LfuCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException(String.format("Invalid capacity: %s", capacity));
    }
    this.capacity = capacity;
    this.keyToFreq = new HashMap<>();
    this.keyToValue = new HashMap<>();
    this.freqToKeysLruOrder = new HashMap<>();
  }

  public int get(int key) {
    int value = keyToValue.getOrDefault(key, -1);
    if (value == -1) {
      return -1;
    }

    // now we can assume the key exists in all maps

    // update freq and insert again in MRU position
    int freq = keyToFreq.get(key);

    LinkedHashSet<Integer> freqKeys = freqToKeysLruOrder.get(freq);
    freqKeys.remove(key);
    keyToFreq.put(key, freq + 1);
    freqToKeysLruOrder.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).addFirst(key);

    // try advance minFreq
    if (freqKeys.isEmpty()) {
      if (minFreq == freq) {
        minFreq++;
      }
      // cleanup
      freqToKeysLruOrder.remove(freq);
    }

    return value;
  }

  public void put(int key, int value) {
    if (keyToValue.containsKey(key)) {
      keyToValue.put(key, value);
      // reuse get; this will update the keys freq and position
      get(key);
    } else {
      // evict BEFORE adding the new value - otherwise always removing from freq=1
      if (keyToValue.size() + 1 > capacity) {
        // evict LFU -> LRU
        LinkedHashSet<Integer> lfuKeys = freqToKeysLruOrder.get(minFreq);
        int lruKey = lfuKeys.getLast();
        keyToValue.remove(lruKey);
        keyToFreq.remove(lruKey);
        lfuKeys.remove(lruKey);

        // cleanup
        if (lfuKeys.isEmpty()) {
          freqToKeysLruOrder.remove(minFreq);
        }
      }

      // add new value in MRU position
      keyToValue.put(key, value);
      keyToFreq.put(key, 1);
      freqToKeysLruOrder.computeIfAbsent(1, k -> new LinkedHashSet<>()).addFirst(key);
      minFreq = 1;
    }
  }
}
