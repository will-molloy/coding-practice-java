package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * <a
 * href=https://leetcode.com/problems/insert-delete-getrandom-o1>https://leetcode.com/problems/insert-delete-getrandom-o1/</a>
 *
 * <p>Runtime: O(1) {@code insert}, {@code remove}, {@code getRandom}
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Using just list, {@code remove} is O(n); using just map/set, {@code getRandom} is O(n).
 * Therefore need a combination. Key is storing indices in map and overwriting with last element in
 * list so list remove becomes O(1) because we always just delete the last list element.
 *
 * @see P398RandomPickIndex
 * @see P497RandomPointInNonOverlappingRectangles
 * @see P528RandomPickWithWeight
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P380InsertDeleteGetRandomO1 {

  // originally got it working with just a list (which had O(n) remove)
  // answer is explained here:
  // https://leetcode.com/problems/insert-delete-getrandom-o1/discuss/683165/Algorithm-Explained-or-O(1)-insert()-or-O(1)-delete-or-O(1)-getRandom()

  /** RandomizedSet. */
  static class RandomizedSet {

    private final List<Integer> list;

    // [value -> index]
    private final Map<Integer, Integer> indexMap;

    /** Initialize your data structure here. */
    RandomizedSet() {
      list = new ArrayList<>();
      indexMap = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified
     * element.
     *
     * @param val value to insert
     * @return {@code true} if the set did not already contain the specified element
     */
    public boolean insert(int val) {
      if (indexMap.containsKey(val)) {
        return false;
      }
      list.add(val);
      indexMap.put(val, list.size() - 1);
      return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     *
     * @param value to remove
     * @return {@code true} if the set contained the specified element
     */
    public boolean remove(int val) {
      if (!indexMap.containsKey(val)) {
        return false;
      }

      // overwrite value with last element in list
      int valIndex = indexMap.get(val);
      int lastIndex = list.size() - 1;
      int lastElement = list.get(lastIndex);
      list.set(valIndex, lastElement);

      // update last elements new index
      indexMap.put(lastElement, valIndex);

      // now remove the value (and dupe last element); removing from end of ArrayList is O(1)
      indexMap.remove(val);
      list.remove(lastIndex);
      return true;
    }

    /**
     * Get a random element from the set.
     *
     * @return a random element from the set
     */
    public int getRandom() {
      return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }
  }
}
