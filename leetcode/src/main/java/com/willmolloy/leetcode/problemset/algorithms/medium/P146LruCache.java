package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.LinkedHashMap;

/**
 * <a href=https://leetcode.com/problems/lru-cache>https://leetcode.com/problems/lru-cache</a>
 *
 * <p>Key idea: map for O(1) operations + linked list to track least recently used
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P146LruCache {

  private final int capacity;

  // in an interview may be required to implement our own linked map...
  private final LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

  @SuppressFBWarnings("CT_CONSTRUCTOR_THROW")
  P146LruCache(int capacity) {
    if (capacity <= 0) {
      throw new IllegalArgumentException(String.format("Invalid capacity: %s", capacity));
    }
    this.capacity = capacity;
  }

  // O(1)
  public int get(int key) {
    int value = map.getOrDefault(key, -1);
    if (value != -1) {
      // refresh key
      map.remove(key);
      map.put(key, value);
    }
    return value;
  }

  // O(1)
  public void put(int key, int value) {
    if (map.containsKey(key)) {
      // remove existing key so its refreshed
      map.remove(key);
    } else if (map.size() == capacity) {
      // evict head
      map.remove(map.keySet().iterator().next());
    }
    map.put(key, value);
  }
}
